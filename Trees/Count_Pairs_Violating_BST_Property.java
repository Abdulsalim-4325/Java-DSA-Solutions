/*
 * Problem: Count Pairs Violating BST Property (GeeksforGeeks - Medium)
 * 
 * Given root of a binary tree in which all node values are distinct, count pairs 
 * of nodes that violate any of the following Binary Search Tree (BST) properties:
 * - All values in the left subtree are strictly smaller.
 * - All values in the right subtree are strictly greater.
 * 
 * Examples:
 * Input: root[] = [10, 50, 40, N, N, 20, 30]
 * Output: 5
 * Explanation: Pairs violating BST property are:
 * (10, 50), 10 should be greater than its left child value.
 * (40, 30), 40 should be less than its right child value.
 * (50, 20), (50, 30) and (50, 40).
 * 
 * Constraints:
 * 1 <= size of binary tree <= 5*10^4
 * 1 <= node.data <= 10^9
 * All node values are distinct.
 * 
 * Approach:
 * Extract the in-order traversal of the tree into a list. In a perfect BST, 
 * the in-order traversal is strictly increasing. Thus, counting BST violations 
 * is mathematically equivalent to counting inversions in this in-order array. 
 * Use Merge Sort to efficiently compute the inversion count in O(N log N).
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class Count_Pairs_Violating_BST_Property {

    public int pairsViolatingBST(Node root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        
        int n = inOrderList.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = inOrderList.get(i);
        }
        
        return mergeSortAndCount(arr, 0, n - 1);
    }
    
    private void inOrderTraversal(Node node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }
    
    private int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }
    
    private int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        
        int i = 0, j = 0, k = left, swaps = 0;
        
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (leftArr.length - i);
            }
        }
        
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
        
        return swaps;
    }

    public static void main(String[] args) {
        Count_Pairs_Violating_BST_Property solution = new Count_Pairs_Violating_BST_Property();

        // Construct Tree: [10, 50, 40, N, N, 20, 30]
        Node root = new Node(10);
        root.left = new Node(50);
        root.right = new Node(40);
        root.right.left = new Node(20);
        root.right.right = new Node(30);

        System.out.println(solution.pairsViolatingBST(root)); // Expected: 5
    }
}
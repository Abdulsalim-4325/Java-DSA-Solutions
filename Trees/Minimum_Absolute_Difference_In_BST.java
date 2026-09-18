/*
 * Minimum Absolute Difference In BST
 * Difficulty: Medium | Accuracy: 56.22% | Submissions: 39K+ | Points: 4
 * 
 * Given the root of a Binary Search Tree (BST) containing n (n > 1) nodes, find the 
 * minimum absolute difference between the values of any two different nodes in the tree.
 * Return the minimum absolute difference.
 * 
 * Examples:
 * Input: root[] = [50, 30, 70, 20, N, 60, 80]
 * Output: 10
 * Explanation: There are no two nodes whose absolute difference is smaller than 10.
 * 
 * Input: root[] = [60, 30, 90, 10]
 * Output: 20
 * 
 * Constraints:
 * 2 <= size of binary tree <= 10^5
 * 0 <= node.data <= 10^6
 */

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Minimum_Absolute_Difference_In_BST {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct Test Case 1: [50, 30, 70, 20, null, 60, 80]
        Node root1 = new Node(50);
        root1.left = new Node(30);
        root1.right = new Node(70);
        root1.left.left = new Node(20);
        root1.right.left = new Node(60);
        root1.right.right = new Node(80);
        System.out.println("Test Case 1: " + solver.absDiff(root1)); // Expected: 10

        // Construct Test Case 2: [60, 30, 90, 10]
        Node root2 = new Node(60);
        root2.left = new Node(30);
        root2.right = new Node(90);
        root2.left.left = new Node(10);
        System.out.println("Test Case 2: " + solver.absDiff(root2)); // Expected: 20
    }
}

class Solution {
    private Integer prevValue;
    private int minDiff;

    public int absDiff(Node root) {
        prevValue = null;
        minDiff = Integer.MAX_VALUE;
        
        inorder(root);
        
        return minDiff;
    }
    
    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        
        if (prevValue != null) {
            minDiff = Math.min(minDiff, node.data - prevValue);
        }
        prevValue = node.data;
        
        inorder(node.right);
    }
}
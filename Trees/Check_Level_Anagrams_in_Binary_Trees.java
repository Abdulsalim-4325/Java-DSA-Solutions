/*
 * Check Level Anagrams in Binary Trees
 * Difficulty: Medium | Accuracy: 56.88% | Submissions: 28K+ | Points: 4
 * 
 * Given the roots of two binary trees root1 and root2, check whether the nodes 
 * at every corresponding level of the two trees are anagrams of each other.
 * Two levels are considered anagrams if they contain the same node values with 
 * the same frequencies, regardless of their order.
 * 
 * Examples:
 * Input: root1 = [1, 3, 2, N, N, 5, 4], root2 = [1, 2, 3, 4, 5, N, N]
 * Output: true
 * Explanation: 
 * Level 0: [1] and [1]
 * Level 1: [3, 2] and [2, 3]
 * Level 2: [5, 4] and [4, 5]
 * The node values at every corresponding level are anagrams.
 * 
 * Input: root1 = [1, 2, 3, 5, 4], root2 = [1, 2, 4, 5, 3]
 * Output: false
 * Explanation: Level 1 in root1 is [2, 3], in root2 is [2, 4]. Not anagrams.
 * 
 * Constraints:
 * 1 <= size of binary tree <= 10^5
 * 1 <= node.data <= 10^6
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

public class Check_Level_Anagrams_in_Binary_Trees {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct Test Case 1
        Node root1A = new Node(1);
        root1A.left = new Node(3);
        root1A.right = new Node(2);
        root1A.left.left = null;
        root1A.left.right = null;
        root1A.right.left = new Node(5);
        root1A.right.right = new Node(4);

        Node root1B = new Node(1);
        root1B.left = new Node(2);
        root1B.right = new Node(3);
        root1B.left.left = new Node(4);
        root1B.left.right = new Node(5);

        System.out.println("Test Case 1: " + solver.areAnagrams(root1A, root1B)); // Expected: true

        // Construct Test Case 2
        Node root2A = new Node(1);
        root2A.left = new Node(2);
        root2A.right = new Node(3);
        root2A.left.left = new Node(5);
        root2A.left.right = new Node(4);

        Node root2B = new Node(1);
        root2B.left = new Node(2);
        root2B.right = new Node(4);
        root2B.left.left = new Node(5);
        root2B.left.right = new Node(3);

        System.out.println("Test Case 2: " + solver.areAnagrams(root2A, root2B)); // Expected: false
    }
}

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.offer(root1);
        q2.offer(root2);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            
            if (size1 != size2) return false;
            
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            
            for (int i = 0; i < size1; i++) {
                Node curr = q1.poll();
                freqMap.put(curr.data, freqMap.getOrDefault(curr.data, 0) + 1);
                
                if (curr.left != null) q1.offer(curr.left);
                if (curr.right != null) q1.offer(curr.right);
            }
            
            for (int i = 0; i < size2; i++) {
                Node curr = q2.poll();
                
                int count = freqMap.getOrDefault(curr.data, 0);
                if (count == 0) {
                    return false; 
                } else if (count == 1) {
                    freqMap.remove(curr.data);
                } else {
                    freqMap.put(curr.data, count - 1);
                }
                
                if (curr.left != null) q2.offer(curr.left);
                if (curr.right != null) q2.offer(curr.right);
            }
            
            if (!freqMap.isEmpty()) return false;
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
}
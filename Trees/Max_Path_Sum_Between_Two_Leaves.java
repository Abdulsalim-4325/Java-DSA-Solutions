/*
 * Max Path Sum Between Two Leaves
 * Difficulty: Hard | Accuracy: 18.39% | Submissions: 217K+ | Points: 8
 * 
 * Given the root of a binary tree, where each node contains an integer value, 
 * find the maximum possible path sum between any two leaf nodes. 
 * If the tree has fewer than two leaf nodes, return -1.
 * 
 * Example 1:
 * Input: root = [3, 4, 5, -10, 4, N, N]
 * Output: 16
 * Explanation: Maximum path is 4 -> 4 -> 3 -> 5 = 16.
 * 
 * Example 2:
 * Input: root = [3, 4, 1, -10, 4, N, N]
 * Output: 12
 * Explanation: Maximum path is 4 -> 4 -> 3 -> 1 = 12.
 * 
 * Constraints:
 * 0 <= size of binary tree <= 10^4
 * -10^3 <= node.data <= 10^3
 */

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Max_Path_Sum_Between_Two_Leaves {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        // Tree: [3, 4, 5, -10, 4, N, N]
        Node root1 = new Node(3);
        root1.left = new Node(4);
        root1.right = new Node(5);
        root1.left.left = new Node(-10);
        root1.left.right = new Node(4);
        System.out.println("Test Case 1: " + solver.maxPathSum(root1)); 
        // Expected: 16

        // Test Case 2
        // Tree: [3, 4, 1, -10, 4, N, N]
        Node root2 = new Node(3);
        root2.left = new Node(4);
        root2.right = new Node(1);
        root2.left.left = new Node(-10);
        root2.left.right = new Node(4);
        System.out.println("Test Case 2: " + solver.maxPathSum(root2)); 
        // Expected: 12

        // Test Case 3 (Fewer than 2 leaves)
        Node root3 = new Node(1);
        root3.left = new Node(2);
        System.out.println("Test Case 3: " + solver.maxPathSum(root3)); 
        // Expected: -1
    }
}

class Solution {
    int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        
        if (root == null) {
            return -1;
        }
        
        dfs(root);
        
        if (maxSum == Integer.MIN_VALUE) {
            return -1;
        }
        
        return maxSum;
    }
    
    private int dfs(Node node) {
        if (node.left == null && node.right == null) {
            return node.data;
        }
        
        if (node.left != null && node.right != null) {
            int leftMax = dfs(node.left);
            int rightMax = dfs(node.right);
            
            maxSum = Math.max(maxSum, leftMax + rightMax + node.data);
            
            return Math.max(leftMax, rightMax) + node.data;
        }
        
        if (node.left != null) {
            return dfs(node.left) + node.data;
        }
        
        return dfs(node.right) + node.data;
    }
}
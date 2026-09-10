/*
 * LeetCode 2265. Count Nodes Equal to Average of Subtree
 * Medium
 * 
 * Given the root of a binary tree, return the number of nodes where the value of the 
 * node is equal to the average of the values in its subtree.
 * 
 * Note:
 * The average of n elements is the sum of the n elements divided by n and rounded down 
 * to the nearest integer.
 * A subtree of root is a tree consisting of root and all of its descendants.
 * 
 * Example 1:
 * Input: root = [4,8,5,0,1,null,6]
 * Output: 5
 * Explanation: 
 * For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
 * For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
 * For the node with value 0: The average of its subtree is 0 / 1 = 0.
 * For the node with value 1: The average of its subtree is 1 / 1 = 1.
 * For the node with value 6: The average of its subtree is 6 / 1 = 6.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Count_Nodes_Equal_to_Average_of_Subtree {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct Example 1: [4,8,5,0,1,null,6]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(6);

        System.out.println("Test Case 1: " + solver.averageOfSubtree(root1)); // Expected: 5

        // Construct Example 2: [1]
        TreeNode root2 = new TreeNode(1);
        
        // Need to reset the solution object or create a new one because of global state
        Solution solver2 = new Solution();
        System.out.println("Test Case 2: " + solver2.averageOfSubtree(root2)); // Expected: 1
    }
}

class Solution {
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return matchingNodesCount;
    }

    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        if (currentSum / currentCount == node.val) {
            matchingNodesCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}
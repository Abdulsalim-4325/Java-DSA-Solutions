/*
Longest Consecutive Sequence in Binary Tree

Given the root of a Binary Tree, find the length of the longest path
consisting of connected nodes such that each next node has a value
exactly 1 greater than its parent.

The path must move from parent to child only.

If no such path exists, return -1.

Examples:

Input: [1,2,3]
Output: 2

Input: [10,20,30,40,null,60,90]
Output: -1
*/


public class Longest_Consecutive_Sequence_in_Binary_Tree {

  

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxLength;

    public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return -1;
        }

        maxLength = 1;
        dfs(root, 1);

        return maxLength == 1 ? -1 : maxLength;
    }

    private static void dfs(TreeNode node, int length) {
        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, length);

        if (node.left != null) {
            if (node.left.val == node.val + 1) {
                dfs(node.left, length + 1);
            } else {
                dfs(node.left, 1);
            }
        }

        if (node.right != null) {
            if (node.right.val == node.val + 1) {
                dfs(node.right, length + 1);
            } else {
                dfs(node.right, 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(longestConsecutive(root));
    }
}
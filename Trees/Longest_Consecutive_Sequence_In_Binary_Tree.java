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

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Longest_Consecutive_Sequence_In_Binary_Tree {

    private int maxLength = 0;

    public int longestConsecutive(Node root) {

        if (root == null) {
            return -1;
        }

        dfs(root, 1);

        return maxLength > 1 ? maxLength : -1;
    }

    private void dfs(Node node, int currentLength) {

        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, currentLength);

        if (node.left != null) {

            if (node.left.data == node.data + 1) {
                dfs(node.left, currentLength + 1);
            } else {
                dfs(node.left, 1);
            }

        }

        if (node.right != null) {

            if (node.right.data == node.data + 1) {
                dfs(node.right, currentLength + 1);
            } else {
                dfs(node.right, 1);
            }

        }
    }

    public static void main(String[] args) {

        Longest_Consecutive_Sequence_In_Binary_Tree solver =
                new Longest_Consecutive_Sequence_In_Binary_Tree();

        // Test Case 1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        System.out.println("Test Case 1:");
        System.out.println(solver.longestConsecutive(root1)); // Expected: 2
        System.out.println();

        // Test Case 2
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);
        root2.right.left = new Node(60);
        root2.right.right = new Node(90);

        System.out.println("Test Case 2:");
        System.out.println(solver.longestConsecutive(root2)); // Expected: -1
        System.out.println();

        // Test Case 3
        Node root3 = new Node(5);
        root3.left = new Node(6);
        root3.left.left = new Node(7);
        root3.left.left.left = new Node(8);

        System.out.println("Test Case 3:");
        System.out.println(solver.longestConsecutive(root3)); // Expected: 4
    }
}
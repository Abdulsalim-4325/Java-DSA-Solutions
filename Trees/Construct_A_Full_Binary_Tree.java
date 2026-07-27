/*
Construct a Full Binary Tree

Given two arrays:
1. pre[]       -> Preorder traversal
2. preMirror[] -> Mirror preorder traversal

Construct the original Full Binary Tree.

Example 1:
pre = [0,1,2]
mirror = [0,2,1]

Example 2:
pre = [1,2,4,5,3,6,7]
mirror = [1,3,7,6,2,5,4]
*/

import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
    }
}

public class Construct_A_Full_Binary_Tree {

    private int preIndex;
    private HashMap<Integer, Integer> mirrorIndex;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        preIndex = 0;
        mirrorIndex = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            mirrorIndex.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int left, int right) {

        if (preIndex >= pre.length || left > right) {
            return null;
        }

        Node root = new Node(pre[preIndex++]);

        if (left == right || preIndex >= pre.length) {
            return root;
        }

        int index = mirrorIndex.get(pre[preIndex]);

        root.left = build(pre, index, right);
        root.right = build(pre, left + 1, index - 1);

        return root;
    }

    // Preorder Traversal
    public void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Construct_A_Full_Binary_Tree solver =
                new Construct_A_Full_Binary_Tree();

        // Test Case 1
        int[] pre1 = {0, 1, 2};
        int[] mirror1 = {0, 2, 1};

        Node root1 = solver.constructBinaryTree(pre1, mirror1);

        System.out.print("Test Case 1: ");
        solver.preorder(root1); // Expected: 0 1 2
        System.out.println();

        // Test Case 2
        solver = new Construct_A_Full_Binary_Tree();

        int[] pre2 = {1, 2, 4, 5, 3, 6, 7};
        int[] mirror2 = {1, 3, 7, 6, 2, 5, 4};

        Node root2 = solver.constructBinaryTree(pre2, mirror2);

        System.out.print("Test Case 2: ");
        solver.preorder(root2); // Expected: 1 2 4 5 3 6 7
        System.out.println();
    }
}
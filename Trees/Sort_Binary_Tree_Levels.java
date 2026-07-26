/*
Sort Binary Tree Levels

Given an integer array representing the nodes of a Complete Binary Tree
in level order traversal, return the nodes at each level after sorting
them in ascending order.

Examples:

Input:
arr = [7, 6, 5, 4, 3, 2, 1]

Output:
[[7], [5, 6], [1, 2, 3, 4]]

Input:
arr = [7, 16, 1, 4, 13]

Output:
[[7], [1, 16], [4, 13]]

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^9
*/

import java.util.ArrayList;
import java.util.Collections;

public class Sort_Binary_Tree_Levels {

    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length;
        int index = 0;
        int levelSize = 1;

        while (index < n) {

            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize && index < n; i++) {
                level.add(arr[index]);
                index++;
            }

            Collections.sort(level);
            result.add(level);

            levelSize *= 2;
        }

        return result;
    }

    public static void main(String[] args) {

        Sort_Binary_Tree_Levels solver = new Sort_Binary_Tree_Levels();

        // Test Case 1
        int[] arr1 = {7, 6, 5, 4, 3, 2, 1};

        System.out.println("Test Case 1:");
        System.out.println(solver.levelSort(arr1));
        // Expected: [[7], [5, 6], [1, 2, 3, 4]]

        System.out.println();

        // Test Case 2
        int[] arr2 = {7, 16, 1, 4, 13};

        System.out.println("Test Case 2:");
        System.out.println(solver.levelSort(arr2));
        // Expected: [[7], [1, 16], [4, 13]]

        System.out.println();

        // Test Case 3
        int[] arr3 = {10};

        System.out.println("Test Case 3:");
        System.out.println(solver.levelSort(arr3));
        // Expected: [[10]]
    }
}
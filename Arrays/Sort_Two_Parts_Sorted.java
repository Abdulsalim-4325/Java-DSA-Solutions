
/*
 * Problem: Sort Two Parts Sorted (GFG)
 *
 * Given an array whose two parts are individually sorted,
 * merge them into one sorted array.
 *
 * Approach:
 * Find the breakpoint, then merge the two sorted parts
 * using two pointers and a temporary array.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;

public class Sort_Two_Parts_Sorted {

    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = -1;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            return;
        }

        int[] merged = new int[n];
        int i = 0;
        int j = breakPoint;
        int k = 0;

        while (i < breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i < breakPoint) {
            merged[k++] = arr[i++];
        }

        while (j < n) {
            merged[k++] = arr[j++];
        }

        System.arraycopy(merged, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Sort_Two_Parts_Sorted solution = new Sort_Two_Parts_Sorted();

        int[] arr1 = {2, 3, 8, -1, 7, 10};
        solution.mergeTwoParts(arr1);
        System.out.println(Arrays.toString(arr1));
        // [-1, 2, 3, 7, 8, 10]

        int[] arr2 = {-4, 6, 9, -1, 3};
        solution.mergeTwoParts(arr2);
        System.out.println(Arrays.toString(arr2));
        // [-4, -1, 3, 6, 9]

        int[] arr3 = {10, 20, 30};
        solution.mergeTwoParts(arr3);
        System.out.println(Arrays.toString(arr3));
        // [10, 20, 30]
    }
}
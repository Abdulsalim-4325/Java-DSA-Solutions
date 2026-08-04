
/*
Pairs with Less Than K Diff

Given an array arr[] of positive integers and an
integer k, find the total number of unique pairs
whose absolute difference is strictly less than k.

Pair (i, j) is considered the same as (j, i).


Examples:

Input:
arr = [1, 10, 4, 2]
k = 3

Output:
2

Explanation:
The valid pairs are:

(1, 2)
(4, 2)


Input:
arr = [2, 3, 4]
k = 5

Output:
3

Explanation:
The valid pairs are:

(2, 3)
(2, 4)
(3, 4)
*/

import java.util.Arrays;

public class Pairs_With_Less_Than_K_Diff {

    public static int countPairs(
            int[] arr,
            int k
    ) {

        int n = arr.length;

        /*
         * The absolute difference cannot be less
         * than 0.
         */
        if (k <= 0) {
            return 0;
        }

        /*
         * Sort the array so that:
         *
         * arr[right] - arr[left]
         *
         * is equal to the absolute difference
         * when right > left.
         */
        Arrays.sort(arr);

        /*
         * Store the total number of valid pairs.
         *
         * long is used during calculation because
         * the number of pairs can be large.
         */
        long pairCount = 0;

        /*
         * right only moves forward, making the
         * two-pointer traversal linear after sorting.
         */
        int right = 0;

        /*
         * Fix the left element of each pair.
         */
        for (int left = 0;
             left < n;
             left++) {

            /*
             * right must be greater than left.
             */
            if (right <= left) {
                right = left + 1;
            }

            /*
             * Move right while the difference is
             * strictly less than k.
             */
            while (right < n
                    && arr[right] - arr[left] < k) {

                right++;
            }

            /*
             * Every element from:
             *
             * left + 1
             *
             * to:
             *
             * right - 1
             *
             * forms a valid pair with arr[left].
             *
             * Number of valid elements:
             *
             * right - left - 1
             */
            pairCount += right - left - 1;
        }

        return (int) pairCount;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {1, 10, 4, 2};
        int k1 = 3;

        System.out.println(
                "Input: [1, 10, 4, 2], k = 3"
        );

        System.out.println(
                "Number of valid pairs: "
                        + countPairs(arr1, k1)
        );
        // Expected: 2

        System.out.println();

        // Test Case 2
        int[] arr2 = {2, 3, 4};
        int k2 = 5;

        System.out.println(
                "Input: [2, 3, 4], k = 5"
        );

        System.out.println(
                "Number of valid pairs: "
                        + countPairs(arr2, k2)
        );
        // Expected: 3

        System.out.println();

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 2;

        System.out.println(
                "Input: [1, 2, 3, 4, 5], k = 2"
        );

        System.out.println(
                "Number of valid pairs: "
                        + countPairs(arr3, k3)
        );
        // Expected: 4
    }
}



/*
3731. Find Missing Elements

You are given an integer array nums containing
unique integers.

Originally, nums contained every integer within
a certain range, but some integers may have
gone missing.

The smallest and largest values from the
original range are still present.

Return all missing integers in sorted order.

Examples:

Input:
nums = [1, 4, 2, 5]

Output:
[3]


Input:
nums = [7, 8, 6, 9]

Output:
[]


Input:
nums = [5, 1]

Output:
[2, 3, 4]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Missing_Elements {

    public List<Integer> findMissingElements(int[] nums) {

        /*
         * Sort the array so that consecutive
         * values can be compared easily.
         */
        Arrays.sort(nums);

        /*
         * Store all missing integers.
         */
        List<Integer> missingElements =
                new ArrayList<>();

        /*
         * Compare every pair of adjacent values.
         */
        for (int i = 1; i < nums.length; i++) {

            /*
             * Add every number between:
             *
             * nums[i - 1]
             * and
             * nums[i]
             *
             * to the result.
             */
            for (int number = nums[i - 1] + 1;
                 number < nums[i];
                 number++) {

                missingElements.add(number);
            }
        }

        return missingElements;
    }

    public static void main(String[] args) {

        Find_Missing_Elements solver =
                new Find_Missing_Elements();

        // Test Case 1
        int[] nums1 = {1, 4, 2, 5};

        System.out.println(
                "Input: [1, 4, 2, 5]"
        );

        System.out.println(
                "Missing elements: "
                        + solver.findMissingElements(nums1)
        );
        // Expected: [3]

        System.out.println();

        // Test Case 2
        int[] nums2 = {7, 8, 6, 9};

        System.out.println(
                "Input: [7, 8, 6, 9]"
        );

        System.out.println(
                "Missing elements: "
                        + solver.findMissingElements(nums2)
        );
        // Expected: []

        System.out.println();

        // Test Case 3
        int[] nums3 = {5, 1};

        System.out.println(
                "Input: [5, 1]"
        );

        System.out.println(
                "Missing elements: "
                        + solver.findMissingElements(nums3)
        );
        // Expected: [2, 3, 4]
    }
}


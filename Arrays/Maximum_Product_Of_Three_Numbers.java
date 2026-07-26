/*
628. Maximum Product of Three Numbers

Given an integer array nums, find three numbers whose product
is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6

Example 2:

Input: nums = [1,2,3,4]
Output: 24

Example 3:

Input: nums = [-1,-2,-3]
Output: -6

Constraints:

3 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000
*/

import java.util.Arrays;

public class Maximum_Product_Of_Three_Numbers {

    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(product1, product2);
    }

    public static void main(String[] args) {

        Maximum_Product_Of_Three_Numbers solver =
                new Maximum_Product_Of_Three_Numbers();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + solver.maximumProduct(nums1)); // Expected: 6
        System.out.println();

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.println("Output: " + solver.maximumProduct(nums2)); // Expected: 24
        System.out.println();

        // Test Case 3
        int[] nums3 = {-1, -2, -3};
        System.out.println("Input: [-1, -2, -3]");
        System.out.println("Output: " + solver.maximumProduct(nums3)); // Expected: -6
        System.out.println();

        // Test Case 4
        int[] nums4 = {-10, -10, 5, 2};
        System.out.println("Input: [-10, -10, 5, 2]");
        System.out.println("Output: " + solver.maximumProduct(nums4)); // Expected: 500
    }
}


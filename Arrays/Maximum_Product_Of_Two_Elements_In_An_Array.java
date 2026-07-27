/*
1464. Maximum Product of Two Elements in an Array

Given the array of integers nums, choose two different indices i and j.
Return the maximum value of:

(nums[i] - 1) * (nums[j] - 1)

Example 1:

Input: nums = [3,4,5,2]
Output: 12

Example 2:

Input: nums = [1,5,4,5]
Output: 16

Example 3:

Input: nums = [3,7]
Output: 12

Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 1000
*/

public class Maximum_Product_Of_Two_Elements_In_An_Array {

    public int maxProduct(int[] nums) {

        int largest = 0;
        int secondLargest = 0;

        for (int num : nums) {

            if (num >= largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }

    public static void main(String[] args) {

        Maximum_Product_Of_Two_Elements_In_An_Array solver =
                new Maximum_Product_Of_Two_Elements_In_An_Array();

        // Test Case 1
        int[] nums1 = {3, 4, 5, 2};
        System.out.println("Input: [3, 4, 5, 2]");
        System.out.println("Output: " + solver.maxProduct(nums1)); // Expected: 12
        System.out.println();

        // Test Case 2
        int[] nums2 = {1, 5, 4, 5};
        System.out.println("Input: [1, 5, 4, 5]");
        System.out.println("Output: " + solver.maxProduct(nums2)); // Expected: 16
        System.out.println();

        // Test Case 3
        int[] nums3 = {3, 7};
        System.out.println("Input: [3, 7]");
        System.out.println("Output: " + solver.maxProduct(nums3)); // Expected: 12
        System.out.println();

        // Test Case 4
        int[] nums4 = {10, 2, 8, 9};
        System.out.println("Input: [10, 2, 8, 9]");
        System.out.println("Output: " + solver.maxProduct(nums4)); // Expected: 72
    }
}
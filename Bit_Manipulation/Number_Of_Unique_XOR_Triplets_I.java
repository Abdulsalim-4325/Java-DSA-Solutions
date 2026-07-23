/*
3513. Number of Unique XOR Triplets I

You are given an integer array nums of length n, where nums is a permutation
of the numbers in the range [1, n].

A XOR triplet is defined as the XOR of three elements:
nums[i] XOR nums[j] XOR nums[k]
where i <= j <= k.

Return the number of unique XOR triplet values from all possible triplets.

Example 1:

Input: nums = [1,2]
Output: 2

Example 2:

Input: nums = [3,1,2]
Output: 4

Constraints:

1 <= n == nums.length <= 10^5
nums is a permutation of the numbers from 1 to n.
*/

public class Number_Of_Unique_XOR_Triplets_I {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // For arrays of size 1 or 2,
        // only the original elements can appear as unique XOR values.
        if (n <= 2) {
            return n;
        }

        // Find the smallest power of 2 greater than n.
        int powerOfTwo = 1;

        while (powerOfTwo <= n) {
            powerOfTwo <<= 1;
        }

        return powerOfTwo;
    }

    public static void main(String[] args) {

        Number_Of_Unique_XOR_Triplets_I solver = new Number_Of_Unique_XOR_Triplets_I();

        // Test Case 1
        int[] nums1 = {1, 2};
        System.out.println("Input: [1, 2]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums1)); // Expected: 2
        System.out.println();

        // Test Case 2
        int[] nums2 = {3, 1, 2};
        System.out.println("Input: [3, 1, 2]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums2)); // Expected: 4
        System.out.println();

        // Test Case 3
        int[] nums3 = {1};
        System.out.println("Input: [1]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums3)); // Expected: 1
        System.out.println();

        // Test Case 4
        int[] nums4 = {2, 1};
        System.out.println("Input: [2, 1]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums4)); // Expected: 2
    }
}
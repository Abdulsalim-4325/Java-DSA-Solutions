/*
3514. Number of Unique XOR Triplets II

You are given an integer array nums.

A XOR triplet is defined as the XOR of three elements:
nums[i] XOR nums[j] XOR nums[k]
where i <= j <= k.

Return the number of unique XOR triplet values from all possible triplets.

Example 1:

Input: nums = [1,3]
Output: 2

Example 2:

Input: nums = [6,7,8,9]
Output: 4

Constraints:

1 <= nums.length <= 1500
1 <= nums[i] <= 1500
*/

public class Number_Of_Unique_XOR_Triplets_II {

    public int uniqueXorTriplets(int[] nums) {

        final int MAX_XOR = 2048; // 2^11

        boolean[] seen = new boolean[MAX_XOR];
        boolean[] pairXor = new boolean[MAX_XOR];

        // Store all XOR values from one or two elements.
        for (int i = 0; i < nums.length; i++) {

            seen[nums[i]] = true;

            for (int j = i; j < nums.length; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        // Combine every pair XOR with every element.
        for (int xorValue = 0; xorValue < MAX_XOR; xorValue++) {

            if (!pairXor[xorValue]) {
                continue;
            }

            for (int num : nums) {
                seen[xorValue ^ num] = true;
            }
        }

        int uniqueCount = 0;

        for (boolean exists : seen) {
            if (exists) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static void main(String[] args) {

        Number_Of_Unique_XOR_Triplets_II solver = new Number_Of_Unique_XOR_Triplets_II();

        // Test Case 1
        int[] nums1 = {1, 3};
        System.out.println("Input: [1, 3]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums1)); // Expected: 2
        System.out.println();

        // Test Case 2
        int[] nums2 = {6, 7, 8, 9};
        System.out.println("Input: [6, 7, 8, 9]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums2)); // Expected: 4
        System.out.println();

        // Test Case 3
        int[] nums3 = {5};
        System.out.println("Input: [5]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums3)); // Expected: 1
        System.out.println();

        // Test Case 4
        int[] nums4 = {2, 4, 6};
        System.out.println("Input: [2, 4, 6]");
        System.out.println("Output: " + solver.uniqueXorTriplets(nums4));
    }
}
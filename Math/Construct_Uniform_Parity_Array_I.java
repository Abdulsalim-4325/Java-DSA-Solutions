/*
Problem: Construct Uniform Parity Array I

Given an array of distinct integers, construct another array where all
elements are either odd or even.

For every index i, choose one operation:
1. nums2[i] = nums1[i]
2. nums2[i] = nums1[i] - nums1[j], where j != i

Approach:
A valid construction always exists.

- If nums1 already contains numbers of one parity only, keep every
  number unchanged.
- If nums1 contains both odd and even values:
  - Keep odd values unchanged.
  - Convert each even value using:
    even - odd = odd

Thus, nums2 can always be made uniformly odd or uniformly even.

Time Complexity: O(1)
Space Complexity: O(1)
*/

public class Construct_Uniform_Parity_Array_I {

    public static boolean uniformArray(int[] nums1) {
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3};
        System.out.println(uniformArray(nums1));
        // Expected Output: true

        int[] nums2 = {4, 6};
        System.out.println(uniformArray(nums2));
        // Expected Output: true
    }
}
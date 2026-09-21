/*
 * LeetCode 3524. Find X Value of Array I
 * Medium
 * 
 * You are given an array of positive integers nums, and a positive integer k.
 * You are allowed to perform an operation once on nums, where in each operation you can 
 * remove any non-overlapping prefix and suffix from nums such that nums remains non-empty.
 * 
 * You need to find the x-value of nums, which is the number of ways to perform this operation 
 * so that the product of the remaining elements leaves a remainder of x when divided by k.
 * Return an array result of size k where result[x] is the x-value of nums for 0 <= x <= k - 1.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5], k = 3
 * Output: [9,2,4]
 * 
 * Example 2:
 * Input: nums = [1,2,4,8,16,32], k = 4
 * Output: [18,1,2,0]
 * 
 * Example 3:
 * Input: nums = [1,1,2,1,1], k = 2
 * Output: [9,6]
 * 
 * Constraints:
 * 1 <= nums[i] <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= k <= 5
 */

import java.util.Arrays;

public class Find_X_Value_of_Array_I {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 1: " + Arrays.toString(solver.resultArray(nums1, 3))); 
        // Expected: [9, 2, 4]

        int[] nums2 = {1, 2, 4, 8, 16, 32};
        System.out.println("Test Case 2: " + Arrays.toString(solver.resultArray(nums2, 4))); 
        // Expected: [18, 1, 2, 0]

        int[] nums3 = {1, 1, 2, 1, 1};
        System.out.println("Test Case 3: " + Arrays.toString(solver.resultArray(nums3, 2))); 
        // Expected: [9, 6]
    }
}

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] currentCounts = new long[k];
        long[] nextCounts = new long[k];

        for (int num : nums) {
            int val = num % k;
            
            for (int i = 0; i < k; i++) {
                nextCounts[i] = 0;
            }
            
            nextCounts[val]++;

            for (int r = 0; r < k; r++) {
                if (currentCounts[r] > 0) {
                    int nextR = (r * val) % k;
                    nextCounts[nextR] += currentCounts[r];
                }
            }

            for (int r = 0; r < k; r++) {
                result[r] += nextCounts[r];
                currentCounts[r] = nextCounts[r];
            }
        }

        return result;
    }
}
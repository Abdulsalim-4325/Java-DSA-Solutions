/*
 * LeetCode 3904. Smallest Stable Index II
 * Medium
 * 
 * You are given an integer array nums of length n and an integer k.
 * For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).
 * In other words:
 * max(nums[0..i]) is the largest value among the elements from index 0 to index i.
 * min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
 * An index i is called stable if its instability score is less than or equal to k.
 * Return the smallest stable index. If no such index exists, return -1.
 * 
 * Example 1:
 * Input: nums = [5,0,1,4], k = 3
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [3,2,1], k = 1
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [0], k = 0
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= k <= 10^9
 */

public class Smallest_Stable_Index_II {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {5, 0, 1, 4};
        System.out.println("Test Case 1: " + solver.firstStableIndex(nums1, 3)); // Expected: 3

        int[] nums2 = {3, 2, 1};
        System.out.println("Test Case 2: " + solver.firstStableIndex(nums2, 1)); // Expected: -1

        int[] nums3 = {0};
        System.out.println("Test Case 3: " + solver.firstStableIndex(nums3, 0)); // Expected: 0
    }
}

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        
        int currentMax = nums[0];
        
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            
            if (currentMax - minRight[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
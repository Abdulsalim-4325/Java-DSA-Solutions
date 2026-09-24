/*
 * LeetCode 3550. Smallest Index With Digit Sum Equal to Index
 * Easy
 * 
 * You are given an integer array nums.
 * Return the smallest index i such that the sum of the digits of nums[i] is equal to i.
 * If no such index exists, return -1.
 * 
 * Example 1:
 * Input: nums = [1,3,2]
 * Output: 2
 * Explanation: For nums[2] = 2, the sum of digits is 2, which is equal to index i = 2. 
 * Thus, the output is 2.
 * 
 * Example 2:
 * Input: nums = [1,10,11]
 * Output: 1
 * Explanation: For nums[1] = 10, the sum of digits is 1 + 0 = 1, which is equal to index i = 1.
 * Since index 1 is the smallest, the output is 1.
 * 
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation: Since no index satisfies the condition, the output is -1.
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */

public class Smallest_Index_Digit_Sum {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 3, 2};
        System.out.println("Test Case 1: " + solver.smallestIndex(nums1)); // Expected: 2

        int[] nums2 = {1, 10, 11};
        System.out.println("Test Case 2: " + solver.smallestIndex(nums2)); // Expected: 1

        int[] nums3 = {1, 2, 3};
        System.out.println("Test Case 3: " + solver.smallestIndex(nums3)); // Expected: -1
    }
}

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int temp = nums[i];
            
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            
            if (sum == i) {
                return i;
            }
        }
        
        return -1;
    }
}
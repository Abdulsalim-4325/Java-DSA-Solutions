/*
 * LeetCode 1658. Minimum Operations to Reduce X to Zero
 * Medium
 * 
 * You are given an integer array nums and an integer x. In one operation, you can either 
 * remove the leftmost or the rightmost element from the array nums and subtract its value from x. 
 * Note that this modifies the array for future operations.
 * 
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, 
 * otherwise, return -1.
 * 
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * 
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the 
 * first two elements (5 operations in total) to reduce x to zero.
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 1 <= x <= 10^9
 */

public class Min_Operations_Reduce_X_to_Zero {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 1, 4, 2, 3};
        System.out.println("Test Case 1: " + solver.minOperations(nums1, 5)); // Expected: 2

        int[] nums2 = {5, 6, 7, 8, 9};
        System.out.println("Test Case 2: " + solver.minOperations(nums2, 4)); // Expected: -1

        int[] nums3 = {3, 2, 20, 1, 1, 3};
        System.out.println("Test Case 3: " + solver.minOperations(nums3, 10)); // Expected: 5
    }
}

class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum - x;
        if (target == 0) return nums.length;
        if (target < 0) return -1;
        
        int maxLength = -1;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        return maxLength != -1 ? nums.length - maxLength : -1;
    }
}
/*
 * LeetCode 2091. Removing Minimum and Maximum From Array
 * Medium
 * 
 * You are given a 0-indexed array of distinct integers nums.
 * There is an element in nums that has the lowest value and an element that has the highest value. 
 * We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 * A deletion is defined as either removing an element from the front of the array or removing an element 
 * from the back of the array.
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 * 
 * Example 1:
 * Input: nums = [2,10,7,5,4,1,8,6]
 * Output: 5
 * 
 * Example 2:
 * Input: nums = [0,-4,19,1,8,-2,-3,5]
 * Output: 3
 * 
 * Example 3:
 * Input: nums = [101]
 * Output: 1
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * The integers in nums are distinct.
 */

public class Removing_Minimum_and_Maximum_From_Array {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {2, 10, 7, 5, 4, 1, 8, 6};
        System.out.println("Test Case 1: " + solver.minimumDeletions(nums1)); // Expected: 5

        int[] nums2 = {0, -4, 19, 1, 8, -2, -3, 5};
        System.out.println("Test Case 2: " + solver.minimumDeletions(nums2)); // Expected: 3

        int[] nums3 = {101};
        System.out.println("Test Case 3: " + solver.minimumDeletions(nums3)); // Expected: 1
    }
}

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int minIndex = 0;
        int maxIndex = 0;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int i = Math.min(minIndex, maxIndex);
        int j = Math.max(minIndex, maxIndex);

        int bothFromFront = j + 1;
        int bothFromBack = n - i;
        int frontAndBack = (i + 1) + (n - j);

        return Math.min(bothFromFront, Math.min(bothFromBack, frontAndBack));
    }
}
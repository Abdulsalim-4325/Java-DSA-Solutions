/*
 * Problem: 462. Minimum Moves to Equal Array Elements II (LeetCode - Medium)
 * 
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.
 * In one move, you can increment or decrement an element of the array by 1.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * Example 2:
 * Input: nums = [1,10,2,9]
 * Output: 16
 * 
 * Constraints:
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * Approach:
 * The optimal target to minimize absolute differences is the median. 
 * By sorting the array and pairing elements from the outside in, the required 
 * moves for each pair to reach the median is exactly nums[right] - nums[left].
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements_II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int moves = 0;
        
        while (left < right) {
            moves += nums[right] - nums[left];
            left++;
            right--;
        }
        
        return moves;
    }

    public static void main(String[] args) {
        Minimum_Moves_to_Equal_Array_Elements_II solution = 
                new Minimum_Moves_to_Equal_Array_Elements_II();

        int[] nums1 = {1, 2, 3};
        System.out.println(solution.minMoves2(nums1)); // Expected: 2

        int[] nums2 = {1, 10, 2, 9};
        System.out.println(solution.minMoves2(nums2)); // Expected: 16
    }
}
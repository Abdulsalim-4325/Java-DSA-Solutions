/*
 * Problem: 453. Minimum Moves to Equal Array Elements (LeetCode - Medium)
 * 
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.
 * In one move, you can increment n - 1 elements of the array by 1.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed:
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * Constraints:
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * Approach:
 * Incrementing n - 1 elements by 1 is relatively equivalent to decrementing 
 * 1 element by 1. The target baseline to make all elements equal using only 
 * decrements is the minimum element in the array. Find the minimum element, 
 * then accumulate the differences of all elements from this minimum.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Minimum_Moves_to_Equal_Array_Elements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }
        
        return moves;
    }

    public static void main(String[] args) {
        Minimum_Moves_to_Equal_Array_Elements solution = new Minimum_Moves_to_Equal_Array_Elements();

        // Example 1
        int[] nums1 = {1, 2, 3};
        System.out.println(solution.minMoves(nums1)); // Expected: 3

        // Example 2
        int[] nums2 = {1, 1, 1};
        System.out.println(solution.minMoves(nums2)); // Expected: 0
    }
}
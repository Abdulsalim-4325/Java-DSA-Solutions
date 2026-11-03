/*
 * Problem: 3736. Minimum Moves to Equal Array Elements III (LeetCode - Easy)
 * 
 * You are given an integer array nums.
 * In one move, you may increase the value of any single element nums[i] by 1.
 * 
 * Return the minimum total number of moves required so that all elements 
 * in nums become equal.
 * 
 * Example 1:
 * Input: nums = [2,1,3]
 * Output: 3
 * Explanation:
 * - Increase nums[0] = 2 by 1 to make it 3.
 * - Increase nums[1] = 1 by 1 to make it 2.
 * - Increase nums[1] = 2 by 1 to make it 3.
 * Now, all elements of nums are equal to 3. The minimum total moves is 3.
 * 
 * Example 2:
 * Input: nums = [4,4,5]
 * Output: 2
 * Explanation:
 * - Increase nums[0] = 4 by 1 to make it 5.
 * - Increase nums[1] = 4 by 1 to make it 5.
 * Now, all elements of nums are equal to 5. The minimum total moves is 2.
 * 
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 * 
 * Approach:
 * Find the maximum element in the array. Since we can only increment, the 
 * optimal target is the maximum element. The result is the sum of differences 
 * between the maximum element and every other element.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Minimum_Moves_to_Equal_Array_Elements_III {

    public int minMoves(int[] nums) {
        int max = nums[0];
        
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        int moves = 0;
        
        for (int num : nums) {
            moves += max - num;
        }
        
        return moves;
    }

    public static void main(String[] args) {
        Minimum_Moves_to_Equal_Array_Elements_III solution = 
                new Minimum_Moves_to_Equal_Array_Elements_III();

        // Example 1
        int[] nums1 = {2, 1, 3};
        System.out.println(solution.minMoves(nums1)); // Expected: 3

        // Example 2
        int[] nums2 = {4, 4, 5};
        System.out.println(solution.minMoves(nums2)); // Expected: 2
    }
}
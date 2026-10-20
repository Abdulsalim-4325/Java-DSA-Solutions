/*
 * Problem: 3886. Sum of Sortable Integers (LeetCode - Hard)
 * 
 * You are given an integer array nums of length n.
 * An integer k is called sortable if k divides n and you can sort nums in 
 * non-decreasing order by sequentially performing the following operations:
 * - Partition nums into consecutive subarrays of length k.
 * - Cyclically rotate each subarray independently any number of times.
 * Return an integer denoting the sum of all possible sortable integers k.
 * 
 * Example 1:
 * Input: nums = [3,1,2]
 * Output: 3
 * Explanation: Only k = 3 allows the block [3,1,2] to be rotated to [1,2,3].
 * 
 * Example 2:
 * Input: nums = [7,6,5]
 * Output: 0
 * Explanation: No rotation can transform it to [5,6,7].
 * 
 * Constraints:
 * 1 <= n == nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 
 * Approach:
 * Validate each divisor k. For a block to be sortable into its globally correct position, 
 * it must have at most 1 inversion drop and its shifted elements must exactly match 
 * the corresponding sorted target segment.
 * 
 * Time Complexity: O(N log N + D * N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;

public class Sum_of_Sortable_Integers {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        int sum = 0;
        
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            
            if (isSortable(nums, sortedNums, k, n)) {
                sum += k;
            }
        }
        
        return sum;
    }
    
    private boolean isSortable(int[] nums, int[] sortedNums, int k, int n) {
        for (int b = 0; b < n / k; b++) {
            int L = b * k;
            int R = L + k - 1;
            
            int drops = 0;
            int dropIdx = -1;
            
            for (int i = L; i < R; i++) {
                if (nums[i] > nums[i + 1]) {
                    drops++;
                    dropIdx = i;
                }
            }
            
            if (drops > 1) return false;
            
            if (drops == 0) {
                for (int i = L; i <= R; i++) {
                    if (nums[i] != sortedNums[i]) return false;
                }
            } else {
                if (nums[R] > nums[L]) return false;
                
                int sIdx = L;
                for (int i = dropIdx + 1; i <= R; i++) {
                    if (nums[i] != sortedNums[sIdx++]) return false;
                }
                for (int i = L; i <= dropIdx; i++) {
                    if (nums[i] != sortedNums[sIdx++]) return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Sum_of_Sortable_Integers solution = new Sum_of_Sortable_Integers();

        int[] nums1 = {3, 1, 2};
        System.out.println(solution.sortableIntegers(nums1)); // Expected: 3

        int[] nums2 = {7, 6, 5};
        System.out.println(solution.sortableIntegers(nums2)); // Expected: 0

        int[] nums3 = {5, 8};
        System.out.println(solution.sortableIntegers(nums3)); // Expected: 3
    }
}
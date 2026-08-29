/*
 * LeetCode 2948. Make Lexicographically Smallest Array by Swapping Elements
 * Difficulty: Medium 
 * 
 * You are given a 0-indexed array of positive integers nums and a positive integer limit.
 * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] 
 * if |nums[i] - nums[j]| <= limit.
 * 
 * Return the lexicographically smallest array that can be obtained by performing the 
 * operation any number of times.
 * 
 * Example 1:
 * Input: nums = [1,5,3,9,8], limit = 2
 * Output: [1,3,5,8,9]
 * Explanation: Apply the operation 2 times:
 * - Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
 * - Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
 * 
 * Example 2:
 * Input: nums = [1,7,6,18,2,1], limit = 3
 * Output: [1,6,7,18,1,2]
 * 
 * Example 3:
 * Input: nums = [1,7,28,19,10], limit = 3
 * Output: [1,7,28,19,10]
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= limit <= 10^9
 */

import java.util.Arrays;

public class Make_Lexicographically_Smallest_Array_by_Swapping_Elements {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 5, 3, 9, 8};
        System.out.println("Test Case 1: " + Arrays.toString(solver.lexicographicallySmallestArray(nums1, 2))); 
        // Expected: [1, 3, 5, 8, 9]

        int[] nums2 = {1, 7, 6, 18, 2, 1};
        System.out.println("Test Case 2: " + Arrays.toString(solver.lexicographicallySmallestArray(nums2, 3))); 
        // Expected: [1, 6, 7, 18, 1, 2]

        int[] nums3 = {1, 7, 28, 19, 10};
        System.out.println("Test Case 3: " + Arrays.toString(solver.lexicographicallySmallestArray(nums3, 3))); 
        // Expected: [1, 7, 28, 19, 10]
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] res = new int[n];
        int i = 0;
        
        while (i < n) {
            int j = i + 1;
            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
                j++;
            }
            
            int[] indices = new int[j - i];
            for (int k = i; k < j; k++) {
                indices[k - i] = pairs[k][1];
            }
            
            Arrays.sort(indices);
            
            for (int k = i; k < j; k++) {
                res[indices[k - i]] = pairs[k][0];
            }
            
            i = j;
        }
        
        return res;
    }
}
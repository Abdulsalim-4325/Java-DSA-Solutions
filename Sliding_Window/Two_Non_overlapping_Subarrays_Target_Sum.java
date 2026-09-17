/*
 * LeetCode 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 * (Note: Listed in prompt as 477, but actual LeetCode ID for this problem is 1477)
 * Medium
 * 
 * You are given an array of integers arr and an integer target.
 * You have to find two non-overlapping sub-arrays of arr each with a sum equal target. 
 * There can be multiple answers so you have to find an answer where the sum of the 
 * lengths of the two sub-arrays is minimum.
 * 
 * Return the minimum sum of the lengths of the two required sub-arrays, 
 * or return -1 if you cannot find such two sub-arrays.
 * 
 * Example 1:
 * Input: arr = [3,2,2,4,3], target = 3
 * Output: 2
 * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 * 
 * Example 2:
 * Input: arr = [7,3,4,7], target = 7
 * Output: 2
 * 
 * Example 3:
 * Input: arr = [4,3,2,6,2,3,4], target = 6
 * Output: -1
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 1000
 * 1 <= target <= 10^8
 */

public class Two_Non_overlapping_Subarrays_Target_Sum {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {3, 2, 2, 4, 3};
        System.out.println("Test Case 1: " + solver.minSumOfLengths(arr1, 3)); // Expected: 2

        int[] arr2 = {7, 3, 4, 7};
        System.out.println("Test Case 2: " + solver.minSumOfLengths(arr2, 7)); // Expected: 2

        int[] arr3 = {4, 3, 2, 6, 2, 3, 4};
        System.out.println("Test Case 3: " + solver.minSumOfLengths(arr3, 6)); // Expected: -1
    }
}

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n]; 
        
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int currentLen = right - left + 1;
                
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currentLen + minLen[left - 1]);
                }
                
                bestSoFar = Math.min(bestSoFar, currentLen);
            }
            
            minLen[right] = bestSoFar;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
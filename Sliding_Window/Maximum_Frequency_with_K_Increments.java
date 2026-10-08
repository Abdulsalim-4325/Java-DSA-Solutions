/*
 * Maximum Frequency with K Increments
 * Difficulty: Medium | Accuracy: 68.32% | Submissions: 6K+ | Points: 4
 * 
 * Given an integer array arr[]. In one operation, you can choose an index 
 * and increment its value by 1.
 * Find the maximum possible frequency of any element after performing at most 
 * k operations.
 * 
 * Example 1:
 * Input: arr[] = [2, 2, 4], k = 4
 * Output: 3
 * Explanation: Apply two increment operations on index 0 and two operations 
 * on index 1 to make arr[] = [4, 4, 4]. Frequency of 4 is 3.
 * 
 * Example 2:
 * Input: arr[] = [7, 7, 7, 7], k = 5
 * Output: 4
 * Explanation: The frequency of 7 is already 4, so no operations are needed.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <= 10^6
 * 0 <= k <= 10^5
 */

import java.util.Arrays;

public class Maximum_Frequency_with_K_Increments {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {2, 2, 4};
        int k1 = 4;
        System.out.println("Test Case 1: " + solver.maxFrequency(arr1, k1)); 
        // Expected: 3

        int[] arr2 = {7, 7, 7, 7};
        int k2 = 5;
        System.out.println("Test Case 2: " + solver.maxFrequency(arr2, k2)); 
        // Expected: 4
        
        int[] arr3 = {1, 2, 4, 8, 13};
        int k3 = 5;
        System.out.println("Test Case 3: " + solver.maxFrequency(arr3, k3)); 
        // Expected: 2 (Can make [1, 4, 4, 8, 13] or [2, 2, 4, 8, 13])
    }
}

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        
        int left = 0;
        long currentSum = 0;
        int maxFreq = 0;
        
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            
            while ((long) arr[right] * (right - left + 1) - currentSum > k) {
                currentSum -= arr[left];
                left++;
            }
            
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        
        return maxFreq;
    }
}
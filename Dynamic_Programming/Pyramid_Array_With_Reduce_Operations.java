/*
 * Pyramid Array with Reduce Operations
 * Difficulty: Medium | Accuracy: 61.13% | Submissions: 5K+ | Points: 4
 * 
 * Given an array arr[] consisting of stones, where arr[i] represents the height of the i-th stone.
 * You need to transform the stones into a pyramid by only reducing the heights of the stones. 
 * Reducing the height of a stone by 1 costs 1 unit, and stones cannot be increased or moved.
 * 
 * A valid pyramid consists of a contiguous subarray whose heights follow the pattern: 
 * 1, 2, 3, ..., x - 1, x, x - 1, ..., 2, 1 for some positive integer x.
 * Every stone outside this subarray must have a height of 0.
 * 
 * Find the minimum total cost required to build a pyramid. 
 * It is guaranteed that at least one valid pyramid can always be formed.
 * 
 * Examples:
 * Input: arr[] = [1, 2, 3, 4, 2, 1]
 * Output: 4
 * Explanation: We can obtain the array [1, 2, 3, 2, 1, 0] by subtracting 2 out of 4, 
 * 1 out of 2, and 1 out of 1. In total, we will subtract 4.
 * 
 * Input: arr[] = [1, 2, 1]
 * Output: 0
 * Explanation: The array is already in pyramid form.
 * 
 * Constraints:
 * 1 <= arr.size(), arr[i] <= 10^5
 */

public class Pyramid_Array_With_Reduce_Operations {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {1, 2, 3, 4, 2, 1};
        System.out.println("Test Case 1: " + solver.formPyramid(arr1)); // Expected: 4

        int[] arr2 = {1, 2, 1};
        System.out.println("Test Case 2: " + solver.formPyramid(arr2)); // Expected: 0

        int[] arr3 = {1, 2, 2, 2, 1};
        System.out.println("Test Case 3: " + solver.formPyramid(arr3)); // Expected: 4
    }
}

class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }
        
        right[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }
        
        long totalSum = 0;
        int maxPeakHeight = 0;
        
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            int possiblePeak = Math.min(left[i], right[i]);
            if (possiblePeak > maxPeakHeight) {
                maxPeakHeight = possiblePeak;
            }
        }
        
        long maxPyramidSum = (long) maxPeakHeight * maxPeakHeight;
        
        return (int) (totalSum - maxPyramidSum);
    }
}
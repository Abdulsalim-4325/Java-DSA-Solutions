/*
 * Dominant Pairs
 * Difficulty: Easy | Accuracy: 50.57% | Submissions: 47K+ | Points: 2
 * 
 * Given an even-sized integer array arr[], count the number of dominant pairs. 
 * A pair of indices (i, j) is called dominant if all of the following conditions hold:
 * 1. 0 <= i < arr.size() / 2
 * 2. arr.size() / 2 <= j < arr.size() 
 * 3. arr[i] >= 5 * arr[j] 
 * 
 * Return the total number of dominant pairs.
 * 
 * Examples:
 * Input: arr[] = [10, 2, 2, 1]
 * Output: 2
 * Explanation: First half: [10, 2], Second half: [2, 1]. So valid two pairs are: 
 * {0, 2}: 10 >= 5 * 2 
 * {0, 3}: 10 >= 5 * 1 
 * 
 * Input: arr[] = [10, 8, 2, 1, 1, 2]
 * Output: 5
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^4
 * -10^4 <= arr[i] <= 10^4
 * arr.size() is even.
 */

import java.util.Arrays;

public class Dominant_Pairs {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {10, 2, 2, 1};
        System.out.println("Test Case 1: " + solver.dominantPairs(arr1)); // Expected: 2

        int[] arr2 = {10, 8, 2, 1, 1, 2};
        System.out.println("Test Case 2: " + solver.dominantPairs(arr2)); // Expected: 5
        
        int[] arr3 = {-10, -5, -2, -1};
        System.out.println("Test Case 3: " + solver.dominantPairs(arr3)); // Expected: 3
    }
}

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr, 0, n / 2);
        Arrays.sort(arr, n / 2, n);
        
        int count = 0;
        int j = n / 2;
        
        for (int i = 0; i < n / 2; i++) {
            while (j < n && arr[i] >= 5 * arr[j]) {
                j++;
            }
            count += (j - n / 2);
        }
        
        return count;
    }
}
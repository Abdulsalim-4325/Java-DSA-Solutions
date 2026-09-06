/*
 * Sum of Pairwise ANDs
 * Difficulty: Medium | Accuracy: 50.93% | Submissions: 45K+ | Points: 4
 * 
 * Given an array arr[] of integers, calculate the sum of bitwise AND for all pairs 
 * of elements such that the first index is less than the second index.
 * 
 * Examples:
 * 
 * Input: arr = [5, 10, 15]
 * Output: 15
 * Explanation: 
 * Consider all pairs of elements where the first index is less than the second index (i < j).
 * For the array [5, 10, 15], the valid pairs are:
 * (5, 10)  -> 5 & 10  = 0
 * (5, 15)  -> 5 & 15  = 5
 * (10, 15) -> 10 & 15 = 10
 * Now, add all these results: 0 + 5 + 10 = 15
 * 
 * Input: arr = [10, 20, 30, 40]
 * Output: 46
 * Explanation: 
 * Consider all pairs of elements where the first index is less than the second index (i < j).
 * Now, add all these results: 0 + 10 + 8 + 20 + 0 + 8 = 46
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <= 10^8
 */

public class Sum_of_Pairwise_ANDs {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {5, 10, 15};
        System.out.println("Test Case 1: " + solver.pairAndSum(arr1)); // Expected: 15

        int[] arr2 = {10, 20, 30, 40};
        System.out.println("Test Case 2: " + solver.pairAndSum(arr2)); // Expected: 46
    }
}

class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;
        
        for (int bit = 0; bit < 32; bit++) {
            long count = 0;
            
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            long pairs = (count * (count - 1)) / 2;
            totalSum += pairs * (1L << bit);
        }
        
        return totalSum;
    }
}
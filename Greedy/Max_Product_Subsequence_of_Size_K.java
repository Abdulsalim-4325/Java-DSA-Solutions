/*
 * Max Product Subsequence of Size K
 * Difficulty: Medium | Accuracy: 40.06% | Submissions: 8K+ | Points: 4
 * 
 * Given an array arr[] of integers and an integer k, find a subsequence of size k 
 * whose product is maximum among all possible subsequences of size k. 
 * Return the maximum product that can be obtained.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 0, 3], k = 2
 * Output: 6
 * Explanation: Subsequence containing elements {2, 3} gives maximum product: 2*3 = 6
 * 
 * Input: arr[] = [1, 2, -1, -3, -6, 4], k = 4
 * Output: 144
 * Explanation: Subsequence containing {2, -3, -6, 4} gives maximum product: 2*(-3)*(-6)*4 = 144
 * 
 * Constraints:
 * arr.size() <= 30
 * -10 <= arr[i] <= 10
 * 1 <= k <= arr.size()
 */

import java.util.Arrays;

public class Max_Product_Subsequence_of_Size_K {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {1, 2, 0, 3};
        System.out.println("Test Case 1: " + solver.maxProduct(arr1, 2)); // Expected: 6

        int[] arr2 = {1, 2, -1, -3, -6, 4};
        System.out.println("Test Case 2: " + solver.maxProduct(arr2, 4)); // Expected: 144
        
        int[] arr3 = {-5, -4, -3, -2, -1};
        System.out.println("Test Case 3: " + solver.maxProduct(arr3, 3)); // Expected: -6
    }
}

class Solution {
    public int maxProduct(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        long prod = 1;
        
        if (arr[n - 1] <= 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }
            return (int) prod;
        }
        
        int left = 0;
        int right = n - 1;
        
        if (k % 2 != 0) {
            prod *= arr[right];
            right--;
            k--;
        }
        
        while (k > 0) {
            long leftProd = (long) arr[left] * arr[left + 1];
            long rightProd = (long) arr[right] * arr[right - 1];
            
            if (leftProd > rightProd) {
                prod *= leftProd;
                left += 2;
            } else {
                prod *= rightProd;
                right -= 2;
            }
            k -= 2;
        }
        
        return (int) prod;
    }
}
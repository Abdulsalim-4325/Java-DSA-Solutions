/*
 * Problem: Minimum Sum Subarray (GeeksforGeeks - Medium)
 * 
 * Given an array arr[], find the minimum sum of a subarray containing atleast 
 * one element in the given array.
 * 
 * Examples:
 * Input: arr[] = [3, -4, 2, -3, -1, 7, -5]
 * Output: -6
 * Explanation: The subarray [-4, 2, -3, -1] has the minimum sum, which is -6.
 * 
 * Input: arr[] = [4, -6, 3, -2, 5, -8, 2]
 * Output: -8
 * Explanation: The subarray [-8] has the minimum sum, which is -8.
 * 
 * Input: arr[] = [2, 6, 8, 1, 4]
 * Output: 1
 * Explanation: The subarray [1] has the minimum sum, which is 1.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * Approach:
 * Use an inverted version of Kadane's Algorithm. Keep track of the current minimum 
 * sum contiguous subarray and update the global minimum sum dynamically.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Minimum_Sum_Subarray {

    public int minSubarraySum(int[] arr) {
        int minSum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            minSum = Math.min(minSum, currentSum);
        }
        
        return minSum;
    }

    public static void main(String[] args) {
        Minimum_Sum_Subarray solution = new Minimum_Sum_Subarray();

        int[] arr1 = {3, -4, 2, -3, -1, 7, -5};
        System.out.println(solution.minSubarraySum(arr1)); // Expected: -6

        int[] arr2 = {4, -6, 3, -2, 5, -8, 2};
        System.out.println(solution.minSubarraySum(arr2)); // Expected: -8

        int[] arr3 = {2, 6, 8, 1, 4};
        System.out.println(solution.minSubarraySum(arr3)); // Expected: 1
    }
}
/*
 * Problem: Maximum Subarray Sum with One Square Allowed (GeeksforGeeks - Medium)
 * 
 * Given an integer array arr[], find the maximum subarray sum by squaring 
 * at most one element.
 * 
 * Examples:
 * Input: arr[] = [-1, -2, 3, -2, 3]
 * Output: 10
 * Explanation: Squaring -2 yields {3, 4, 3} -> 3 + 4 + 3 = 10.
 * 
 * Input: arr[] = [-4, -4, -2, 5, 2, -1]
 * Output: 27
 * Explanation: Squaring 5 yields {25, 2} -> 25 + 2 = 27.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * -10^3 <= arr[i] <= 10^3
 * 
 * Approach:
 * Use a modified Kadane's Algorithm tracking two concurrent states: 
 * 1. Maximum sum with NO elements squared.
 * 2. Maximum sum with EXACTLY ONE element squared.
 * Evolve both states iteratively and track the global maximum configuration.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Maximum_Subarray_Sum_with_One_Square_Allowed {

    public int maximumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int noSquare = arr[0];
        int oneSquare = arr[0] * arr[0];
        int maxSum = Math.max(noSquare, oneSquare);
        
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int valSq = val * val;
            
            int nextOneSquare = Math.max(valSq, Math.max(noSquare + valSq, oneSquare + val));
            int nextNoSquare = Math.max(val, noSquare + val);
            
            noSquare = nextNoSquare;
            oneSquare = nextOneSquare;
            
            maxSum = Math.max(maxSum, Math.max(noSquare, oneSquare));
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        Maximum_Subarray_Sum_with_One_Square_Allowed solution = 
                new Maximum_Subarray_Sum_with_One_Square_Allowed();

        int[] arr1 = {-1, -2, 3, -2, 3};
        System.out.println(solution.maximumSubarray(arr1)); // Expected: 10
        
        int[] arr2 = {-4, -4, -2, 5, 2, -1};
        System.out.println(solution.maximumSubarray(arr2)); // Expected: 27
    }
}
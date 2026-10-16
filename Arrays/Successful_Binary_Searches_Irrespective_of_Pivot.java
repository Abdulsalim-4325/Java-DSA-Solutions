/*
 * Problem: Successful Binary Searches Irrespective of Pivot (GeeksforGeeks - Medium)
 * 
 * Given an array arr[] of n distinct integers (not necessarily sorted), consider a binary 
 * search for a target where at each step, any index p in [lo, hi] can be chosen as pivot.
 * Count the number of indices i such that searching for target = arr[i] succeeds no 
 * matter which pivot is chosen at every step.
 * 
 * Examples:
 * Input: arr[] = [3, 7, 9, 8, 15]
 * Output: 3
 * Explanation: 3, 7, and 15 (indices 0, 1, 4) are always found.
 * 
 * Input: arr[] = [9, 4, 1, 10, 22, 23, 20]
 * Output: 1
 * Explanation: Only 10 (index 3) is always found.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <= 10^6
 * 
 * Approach:
 * An element is always found if it's strictly greater than all elements to its left 
 * and strictly smaller than all elements to its right. We compute suffix minimums in an 
 * array and track prefix maximums dynamically during traversal.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Successful_Binary_Searches_Irrespective_of_Pivot {

    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] rightMin = new int[n];
        rightMin[n - 1] = Integer.MAX_VALUE;
        
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }
        
        int count = 0;
        int leftMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > leftMax && arr[i] < rightMin[i]) {
                count++;
            }
            leftMax = Math.max(leftMax, arr[i]);
        }
        
        return count;
    }

    public static void main(String[] args) {
        Successful_Binary_Searches_Irrespective_of_Pivot solution = 
                new Successful_Binary_Searches_Irrespective_of_Pivot();

        int[] arr1 = {3, 7, 9, 8, 15};
        System.out.println(solution.countAlwaysFound(arr1)); // Expected: 3

        int[] arr2 = {9, 4, 1, 10, 22, 23, 20};
        System.out.println(solution.countAlwaysFound(arr2)); // Expected: 1
    }
}
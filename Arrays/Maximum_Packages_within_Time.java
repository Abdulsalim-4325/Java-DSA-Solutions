/*
 * Problem: Maximum Packages within Time (GeeksforGeeks - Easy)
 * 
 * A delivery agent has to deliver packages at locations arranged in a line. 
 * The number of packages at the ith location is given by arr[i].
 * - The agent can start at any location and can only visit consecutive locations.
 * - Visiting each location takes 1 unit of time.
 * 
 * Given arr[] and totalTime, find the maximum number of packages the agent 
 * can deliver within totalTime.
 * 
 * Examples:
 * Input: arr[] = [2, 1, 3, 5, 0, 1, 4], totalTime = 3
 * Output: 9
 * Explanation: Maximum packages in any 3 consecutive locations is 1 + 3 + 5 = 9.
 * 
 * Input: arr[] = [1, 6, 2, 5, 3, 4], totalTime = 2
 * Output: 8
 * Explanation: Maximum packages in any 2 consecutive locations is 6 + 2 = 8.
 * 
 * Constraints:
 * 1 <= arr.size(), totalTime <= 10^5
 * 0 <= arr[i] <= 10^3
 * 
 * Approach:
 * Sliding Window pattern. Establish a contiguous window of size 'totalTime'. 
 * Shift the window strictly linearly across the array, adding the leading value 
 * and dropping the trailing value to compute rolling sums efficiently.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Maximum_Packages_within_Time {

    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int currentSum = 0;
        int maxSum = 0;
        
        int limit = Math.min(n, totalTime);
        
        for (int i = 0; i < limit; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        
        for (int i = limit; i < n; i++) {
            currentSum += arr[i] - arr[i - limit];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        Maximum_Packages_within_Time solution = new Maximum_Packages_within_Time();

        int[] arr1 = {2, 1, 3, 5, 0, 1, 4};
        System.out.println(solution.maxPackages(arr1, 3)); // Expected: 9

        int[] arr2 = {1, 6, 2, 5, 3, 4};
        System.out.println(solution.maxPackages(arr2, 2)); // Expected: 8
        
        int[] arr3 = {10, 20};
        System.out.println(solution.maxPackages(arr3, 5)); // Expected: 30
    }
}
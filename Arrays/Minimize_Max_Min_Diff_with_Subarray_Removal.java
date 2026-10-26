/*
 * Problem: Minimize Max Min Diff with Subarray Removal (GeeksforGeeks - Medium)
 * 
 * You are given an array arr[] of size n. You need to remove a subarray of size k, 
 * such that the difference between the maximum and minimum values of the remaining 
 * array is minimized. Find the minimum value obtained after performing the operation 
 * of the removal of the subarray.
 * 
 * Examples:
 * Input: arr = [1, 2, 3, 4, 5], k = 3 
 * Output: 1
 * Explanation: We remove first subarray of length 3, the remaining array is [4,5] 
 * and the difference of maximum and minimum element is 1 i.e 5 - 4 = 1.
 * 
 * Input: arr = [2, 3, 1, 4, 6, 7], k = 3
 * Output: 2
 * Explanation: 
 * If we remove the subarray [2,3,1] then remaining array is [4,6,7] and difference = 3
 * If we remove the subarray [3,1,4] then remaining array is [2,6,7] and difference = 5
 * If we remove the subarray [1,4,6] then remaining array is [2,3,7] and difference = 5
 * If we remove the subarray [4,6,7] then remaining array is [2,3,1] and difference = 2
 * So the answer is min(3,5,5,2) = 2
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k < arr.size()
 * 
 * Approach:
 * Build dynamic state tables evaluating the Prefix Maximum, Prefix Minimum, Suffix Maximum, 
 * and Suffix Minimum structures. Iterate over a virtual window isolating a length-k block 
 * and deduce the remaining array boundaries statically using the cached Prefix/Suffix structures.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Minimize_Max_Min_Diff_with_Subarray_Removal {

    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        
        if (k == 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : arr) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            return max - min;
        }
        
        int[] prefMin = new int[n];
        int[] prefMax = new int[n];
        int[] suffMin = new int[n];
        int[] suffMax = new int[n];
        
        prefMin[0] = arr[0];
        prefMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefMin[i] = Math.min(prefMin[i - 1], arr[i]);
            prefMax[i] = Math.max(prefMax[i - 1], arr[i]);
        }
        
        suffMin[n - 1] = arr[n - 1];
        suffMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], arr[i]);
            suffMax[i] = Math.max(suffMax[i + 1], arr[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n - k; i++) {
            int currentMax = Integer.MIN_VALUE;
            int currentMin = Integer.MAX_VALUE;
            
            if (i > 0) {
                currentMax = Math.max(currentMax, prefMax[i - 1]);
                currentMin = Math.min(currentMin, prefMin[i - 1]);
            }
            
            if (i + k < n) {
                currentMax = Math.max(currentMax, suffMax[i + k]);
                currentMin = Math.min(currentMin, suffMin[i + k]);
            }
            
            minDiff = Math.min(minDiff, currentMax - currentMin);
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        Minimize_Max_Min_Diff_with_Subarray_Removal solution = 
                new Minimize_Max_Min_Diff_with_Subarray_Removal();

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(solution.minDiff(3, arr1)); // Expected: 1

        int[] arr2 = {2, 3, 1, 4, 6, 7};
        System.out.println(solution.minDiff(3, arr2)); // Expected: 2
    }
}
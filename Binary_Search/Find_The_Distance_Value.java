/*
 * Problem: 1385. Find the Distance Value Between Two Arrays (LeetCode - Easy)
 * 
 * Given two integer arrays arr1 and arr2, and the integer d, return the 
 * distance value between the two arrays.
 * 
 * The distance value is defined as the number of elements arr1[i] such that 
 * there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 * 
 * Example:
 * Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * Output: 2
 * Explanation: 
 * For arr1[0]=4, all absolute differences are > 2.
 * For arr1[1]=5, all absolute differences are > 2.
 * For arr1[2]=8, |8-8|=0 <= 2 (invalidates it).
 * 
 * Constraints:
 * 1 <= arr1.length, arr2.length <= 500
 * -1000 <= arr1[i], arr2[j] <= 1000
 * 0 <= d <= 100
 * 
 * Approach:
 * Sort arr2. Iterate through arr1 and use binary search on arr2 to quickly 
 * locate the closest elements. If the absolute difference is ever <= d, the 
 * element fails. If the binary search exhausts without failure, increment count.
 * 
 * Time Complexity: O(M log M + N log M)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class Find_The_Distance_Value {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distanceValue = 0;
        
        for (int num : arr1) {
            int left = 0;
            int right = arr2.length - 1;
            boolean isValid = true;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (Math.abs(arr2[mid] - num) <= d) {
                    isValid = false;
                    break;
                } else if (arr2[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if (isValid) {
                distanceValue++;
            }
        }
        
        return distanceValue;
    }

    public static void main(String[] args) {
        Find_The_Distance_Value solution = new Find_The_Distance_Value();

        // Example 1
        int[] arr1_1 = {4, 5, 8};
        int[] arr2_1 = {10, 9, 1, 8};
        int d1 = 2;
        System.out.println(solution.findTheDistanceValue(arr1_1, arr2_1, d1)); // Expected: 2

        // Example 2
        int[] arr1_2 = {1, 4, 2, 3};
        int[] arr2_2 = {-4, -3, 6, 10, 20, 30};
        int d2 = 3;
        System.out.println(solution.findTheDistanceValue(arr1_2, arr2_2, d2)); // Expected: 2

        // Example 3
        int[] arr1_3 = {2, 1, 100, 3};
        int[] arr2_3 = {-5, -2, 10, -3, 7};
        int d3 = 6;
        System.out.println(solution.findTheDistanceValue(arr1_3, arr2_3, d3)); // Expected: 1
    }
}
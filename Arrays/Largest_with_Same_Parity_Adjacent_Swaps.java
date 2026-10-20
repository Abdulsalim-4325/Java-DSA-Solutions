/*
 * Problem: Largest with Same Parity Adjacent Swaps (GeeksforGeeks - Medium)
 * 
 * Given an array arr[], you are allowed to swap two adjacent elements, arr[i] 
 * and arr[i + 1] only if their sum is even. Find the lexicographically largest 
 * array that can be obtained by performing this operation any number of times, 
 * including zero times. 
 * 
 * Note: An array X is lexicographically larger than another array Y if, at the 
 * first position where they differ, X has the larger element.
 * 
 * Examples:
 * Input: arr[] = [1, 3, 5]
 * Output: [5, 3, 1]
 * Explanation: We can swap any adjacent pair as all have even sum. All possible 
 * obtainable arrays are [1, 3, 5], [1, 5, 3], [3, 1, 5], [3, 5, 1], [5, 1, 3] 
 * and [5, 3, 1]. The array [5, 3, 1] is lexicographically largest.
 * 
 * Input: arr[] = [1, 3, 4, 2]
 * Output: [3, 1, 4, 2]
 * Explanation: [1, 3, 4, 2], [1, 3, 2, 4], [3, 1, 2, 4] and [3, 1, 4, 2] are 
 * all possible, among which the last one is lexicographically largest one.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 0 <= arr[i] <= 10^5
 * Array may contain duplicate elements.
 * 
 * Approach:
 * Elements of opposite parity cannot swap. Identify contiguous blocks of 
 * identical parity and sort each block in descending order independently.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Largest_with_Same_Parity_Adjacent_Swaps {

    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        int i = 0;
        
        while (i < n) {
            int j = i;
            
            while (j < n && arr[j] % 2 == arr[i] % 2) {
                j++;
            }
            
            Arrays.sort(arr, i, j);
            
            int left = i;
            int right = j - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            
            i = j;
        }
        
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int num : arr) {
            result.add(num);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Largest_with_Same_Parity_Adjacent_Swaps solution = 
                new Largest_with_Same_Parity_Adjacent_Swaps();

        int[] arr1 = {1, 3, 5};
        System.out.println(solution.lexicographicallyLargest(arr1)); // Expected: [5, 3, 1]

        int[] arr2 = {1, 3, 4, 2};
        System.out.println(solution.lexicographicallyLargest(arr2)); // Expected: [3, 1, 4, 2]
    }
}
/*
 * Problem: 3551. Minimum Swaps to Sort by Digit Sum (LeetCode - Medium)
 * 
 * You are given an array nums of distinct positive integers. You need to sort the 
 * array in increasing order based on the sum of the digits of each number. If two 
 * numbers have the same digit sum, the smaller number appears first in the sorted order.
 * Return the minimum number of swaps required to rearrange nums into this sorted order.
 * A swap is defined as exchanging the values at two distinct positions in the array.
 * 
 * Example 1:
 * Input: nums = [37,100]
 * Output: 1
 * Explanation:
 * - Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] -> [10, 1]
 * - Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
 * - Thus, the minimum number of swaps required to rearrange nums is 1.
 * 
 * Example 2:
 * Input: nums = [22,14,33,7]
 * Output: 0
 * Explanation:
 * - Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] -> [4, 5, 6, 7]
 * - Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
 * - Thus, the minimum number of swaps required to rearrange nums is 0.
 * 
 * Example 3:
 * Input: nums = [18,43,34,16]
 * Output: 2
 * Explanation:
 * - Compute the digit sum for each integer: [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] -> [9, 7, 7, 7]
 * - Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, and swap 43 with 34.
 * - Thus, the minimum number of swaps required to rearrange nums is 2.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - nums consists of distinct positive integers.
 * 
 * Approach:
 * Combine a custom sort based on digit sums with graph-based cycle detection to count 
 * the minimum swaps needed to reach the sorted arrangement.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;

public class Minimum_Swaps_to_Sort_by_Digit_Sum {

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (a, b) -> {
            int sumA = getDigitSum(a[0]);
            int sumB = getDigitSum(b[0]);
            
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i) {
                continue;
            }
            
            int cycleSize = 0;
            int j = i;
            
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Minimum_Swaps_to_Sort_by_Digit_Sum solution = new Minimum_Swaps_to_Sort_by_Digit_Sum();

        System.out.println(solution.minSwaps(new int[]{37, 100})); // Expected: 1
        System.out.println(solution.minSwaps(new int[]{22, 14, 33, 7})); // Expected: 0
        System.out.println(solution.minSwaps(new int[]{18, 43, 34, 16})); // Expected: 2
    }
}
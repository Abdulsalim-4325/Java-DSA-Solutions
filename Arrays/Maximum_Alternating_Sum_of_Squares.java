/*
 * Problem: 3727. Maximum Alternating Sum of Squares
 *
 * Rearrange the elements of nums to maximize:
 * nums[0]^2 - nums[1]^2 + nums[2]^2 - nums[3]^2 + ...
 *
 * Approach:
 * Square every element, sort the squares, add the largest
 * ceil(N / 2) squares, and subtract the remaining smallest squares.
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;

public class Maximum_Alternating_Sum_of_Squares {

    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long sum = 0;
        int n = squares.length;

        for (int i = 0; i < n; i++) {
            if (i >= n / 2) {
                sum += squares[i];
            } else {
                sum -= squares[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Maximum_Alternating_Sum_of_Squares solution = 
                new Maximum_Alternating_Sum_of_Squares();

        int[] nums1 = {1, 2, 3};
        System.out.println(solution.maxAlternatingSum(nums1)); // 12

        int[] nums2 = {1, -1, 2, -2, 3, -3};
        System.out.println(solution.maxAlternatingSum(nums2)); // 16
    }
}
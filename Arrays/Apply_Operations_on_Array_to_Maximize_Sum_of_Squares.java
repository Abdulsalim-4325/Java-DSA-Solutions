
/*
 * Problem: 2897. Apply Operations on Array to Maximize Sum of Squares
 *
 * Given an integer array nums and an integer k, maximize the sum
 * of squares of k elements after applying the allowed bitwise
 * AND/OR operations.
 *
 * Approach:
 * Count the occurrences of each set bit. Greedily construct k
 * numbers by assigning each available bit to the current number.
 *
 * Time Complexity: O(31 * (N + K)) = O(N + K)
 * Space Complexity: O(1)
 */

import java.util.Arrays;
import java.util.List;

public class Apply_Operations_on_Array_to_Maximize_Sum_of_Squares {

    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int[] bitCount = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < k; i++) {
            long value = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    value |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            answer = (answer + value * value) % MOD;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        Apply_Operations_on_Array_to_Maximize_Sum_of_Squares solution =
                new Apply_Operations_on_Array_to_Maximize_Sum_of_Squares();

        List<Integer> nums1 = Arrays.asList(2, 6, 5, 8);
        System.out.println(solution.maxSum(nums1, 2)); // 261

        List<Integer> nums2 = Arrays.asList(4, 5, 4, 7);
        System.out.println(solution.maxSum(nums2, 3)); // 90

        List<Integer> nums3 = Arrays.asList(1, 2, 3);
        System.out.println(solution.maxSum(nums3, 2)); // 13
    }
}
/*
 * LeetCode 2333 - Minimum Sum of Squared Difference
 *
 * Given two arrays and operation limits k1 and k2, minimize the sum
 * of squared differences between corresponding elements.
 *
 * Each operation changes one array element by +1 or -1.
 *
 * Approach:
 * 1. Calculate absolute differences.
 * 2. Combine k1 and k2 into a total operation budget.
 * 3. Use binary search to find the smallest maximum difference
 *    achievable with the available operations.
 * 4. Reduce differences above that level and use remaining
 *    operations to reduce some differences by one more.
 *
 * Technique:
 * Greedy, Binary Search, Array Traversal
 *
 * Time Complexity: O(n log M), where M is the maximum difference.
 * Space Complexity: O(n), for storing differences.
 */

import java.util.Arrays;

public class Minimum_Sum_of_Squared_Difference {

    public static long minSumSquareDiff(
            int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        // All differences can be reduced to zero.
        if (k >= totalDiff) {
            return 0L;
        }

        // Find the smallest achievable maximum difference.
        int low = 0;
        int high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                needed += Math.max(0, d - mid);
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int level = low;
        long used = 0;
        long result = 0;

        for (int d : diff) {
            int reduced = Math.min(d, level);

            used += d - reduced;
            result += (long) reduced * reduced;
        }

        long remaining = k - used;

        // Each extra operation changes level^2 to (level - 1)^2.
        result -= remaining * (2L * level - 1);

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 10, 20, 19};

        System.out.println(
            minSumSquareDiff(nums1, nums2, 0, 0)
        ); // 579

        int[] nums3 = {1, 4, 10, 12};
        int[] nums4 = {5, 8, 6, 9};

        System.out.println(
            minSumSquareDiff(nums3, nums4, 1, 1)
        ); // 43
    }
}
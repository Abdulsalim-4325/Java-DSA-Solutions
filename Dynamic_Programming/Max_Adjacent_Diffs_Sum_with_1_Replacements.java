/*
 * GFG - Max Adjacent Diffs Sum with 1 Replacements
 *
 * Given an integer array, we may replace any number of elements with 1.
 * Find the maximum possible sum of absolute differences between
 * consecutive elements.
 *
 * Approach:
 * Each element has two choices:
 * 1. Keep its original value.
 * 2. Replace it with 1.
 *
 * We use two DP states:
 * dp0 = maximum sum when the current element is unchanged.
 * dp1 = maximum sum when the current element is replaced by 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Max_Adjacent_Diffs_Sum_with_1_Replacements {

    public static int maxDiffSum(int[] arr) {

        int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        long dp0 = 0;
        long dp1 = 0;

        for (int i = 1; i < n; i++) {

            // Current element remains unchanged.
            long newDp0 = Math.max(
                dp0 + Math.abs(arr[i] - arr[i - 1]),
                dp1 + Math.abs(arr[i] - 1)
            );

            // Current element is replaced by 1.
            long newDp1 = Math.max(
                dp0 + Math.abs(1 - arr[i - 1]),
                dp1
            );

            dp0 = newDp0;
            dp1 = newDp1;
        }

        return (int) Math.max(dp0, dp1);
    }

    public static void main(String[] args) {

        int[] arr1 = {3, 2, 1, 4, 5};
        System.out.println(maxDiffSum(arr1)); // 8

        int[] arr2 = {1, 5};
        System.out.println(maxDiffSum(arr2)); // 4

        int[] arr3 = {5};
        System.out.println(maxDiffSum(arr3)); // 0
    }
}
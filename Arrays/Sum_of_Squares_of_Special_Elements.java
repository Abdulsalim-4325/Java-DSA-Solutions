
/*
 * Problem: 2778. Sum of Squares of Special Elements
 *
 * Given a 1-indexed integer array nums of length n,
 * return the sum of squares of all elements whose
 * indices divide n.
 *
 * Approach:
 * Iterate through all 1-based indices. If n % i == 0,
 * add the square of nums[i - 1] to the sum.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Sum_of_Squares_of_Special_Elements {

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Sum_of_Squares_of_Special_Elements solution =
                new Sum_of_Squares_of_Special_Elements();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.sumOfSquares(nums1)); // 21

        int[] nums2 = {2, 7, 1, 19, 18, 3};
        System.out.println(solution.sumOfSquares(nums2)); // 63
    }
}
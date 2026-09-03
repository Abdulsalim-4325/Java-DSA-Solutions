/*
 * LeetCode 3876 - Construct Uniform Parity Array II
 *
 * Given an array of distinct positive integers, construct another
 * array such that all elements are either odd or all even.
 *
 * For every nums1[i], we can either:
 * 1. Keep nums1[i]
 * 2. Replace it with nums1[i] - nums1[j], where j != i
 *    and the result is at least 1.
 *
 * Approach:
 * If all elements already have the same parity, the answer is true.
 *
 * Otherwise, both odd and even numbers exist.
 * In this case, the minimum element must be odd.
 *
 * If the minimum element is odd:
 * - Keep every odd number unchanged.
 * - For every even number, subtract the minimum odd number.
 *   Even - Odd = Odd.
 *
 * Therefore, all elements can become odd.
 *
 * If the minimum element is even, it is impossible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Construct_Uniform_Parity_Array_II {

    public static boolean uniformArray(int[] nums1) {

        boolean hasOdd = false;
        boolean hasEven = false;

        int min = Integer.MAX_VALUE;

        for (int num : nums1) {

            min = Math.min(min, num);

            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // All elements already have the same parity.
        if (!hasOdd || !hasEven) {
            return true;
        }

        // Both odd and even numbers exist.
        // The minimum element must be odd.
        return min % 2 == 1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 7};
        System.out.println(uniformArray(nums1)); // true

        int[] nums2 = {2, 3};
        System.out.println(uniformArray(nums2)); // false

        int[] nums3 = {4, 6};
        System.out.println(uniformArray(nums3)); // true

        int[] nums4 = {3, 8, 10};
        System.out.println(uniformArray(nums4)); // true
    }
}
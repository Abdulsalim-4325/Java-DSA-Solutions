/*
 * Problem: 3644. Maximum K to Sort a Permutation
 * 
 * You are given an integer array nums of length n, where nums is a permutation 
 * of the numbers in the range [0..n - 1].
 * You may swap elements at indices i and j only if nums[i] AND nums[j] == k.
 * Return the maximum value of k such that the array can be sorted in 
 * non-decreasing order using any number of such swaps. If nums is already 
 * sorted, return 0.
 * 
 * Approach:
 * Any element not in its correct position must be swapped. Therefore, k must 
 * be a bitwise submask of all misplaced elements. To maximize k, we take the 
 * bitwise AND of all elements that satisfy nums[i] != i. The value k itself 
 * can be used as a hub to swap and route all misplaced elements.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Maximum_K_to_Sort_a_Permutation {

    public int sortPermutation(int[] nums) {
        int k = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }
        
        return k == -1 ? 0 : k;
    }

    public static void main(String[] args) {
        Maximum_K_to_Sort_a_Permutation solution = new Maximum_K_to_Sort_a_Permutation();

        int[] nums1 = {0, 3, 2, 1};
        System.out.println(solution.sortPermutation(nums1)); // Expected: 1

        int[] nums2 = {0, 1, 3, 2};
        System.out.println(solution.sortPermutation(nums2)); // Expected: 2

        int[] nums3 = {3, 2, 1, 0};
        System.out.println(solution.sortPermutation(nums3)); // Expected: 0
        
        int[] nums4 = {0, 1, 2, 3};
        System.out.println(solution.sortPermutation(nums4)); // Expected: 0 (Already sorted)
    }
}
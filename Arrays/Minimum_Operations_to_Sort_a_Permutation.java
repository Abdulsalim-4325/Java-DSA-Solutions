/*
 * Problem: 3942. Minimum Operations to Sort a Permutation (LeetCode - Medium)
 * 
 * You are given an integer array nums of length n, where nums is a permutation 
 * of the integers from 0 to n - 1. You may perform only the following operations:
 * - Reverse the entire array.
 * - Rotate Left by One.
 * Return an integer denoting the minimum number of operations required to sort 
 * the array in increasing order. If it is not possible, return -1.
 * 
 * Approach:
 * Validate if the array is an ascending or descending cyclic shift. Use modular 
 * arithmetic to compute bounds. For ascending arrays, compare the cost of standard 
 * left rotations against a simulated right rotation (Reverse -> Rotate -> Reverse).
 * For descending arrays, evaluate the optimal placement of the mandatory reverse step.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Minimum_Operations_to_Sort_a_Permutation {

    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx = i;
                break;
            }
        }
        
        boolean isAscending = true;
        for (int i = 0; i < n; i++) {
            if (nums[(idx + i) % n] != i) {
                isAscending = false;
                break;
            }
        }
        
        boolean isDescending = true;
        for (int i = 0; i < n; i++) {
            if (nums[(idx + i) % n] != (n - i) % n) {
                isDescending = false;
                break;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        if (isAscending) {
            ans = Math.min(ans, idx);
            if (idx != 0) {
                ans = Math.min(ans, n - idx + 2);
            }
        }
        
        if (isDescending) {
            ans = Math.min(ans, n - idx);
            ans = Math.min(ans, (idx + 1) % n + 1);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Minimum_Operations_to_Sort_a_Permutation solution = 
                new Minimum_Operations_to_Sort_a_Permutation();

        System.out.println(solution.minOperations(new int[]{0, 2, 1})); // Expected: 2
        System.out.println(solution.minOperations(new int[]{1, 0, 2})); // Expected: 2
        System.out.println(solution.minOperations(new int[]{2, 0, 1, 3})); // Expected: -1
        
        // Failing test case resolved
        System.out.println(solution.minOperations(new int[]{1, 2, 3, 4, 0})); // Expected: 3
    }
}
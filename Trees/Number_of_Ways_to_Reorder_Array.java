/*
 * Problem: 1569. Number of Ways to Reorder Array to Get Same BST (LeetCode - Hard)
 * 
 * Given an array nums that represents a permutation of integers from 1 to n. 
 * We are going to construct a binary search tree (BST) by inserting the elements of 
 * nums in order into an initially empty BST. Find the number of different ways to 
 * reorder nums so that the constructed BST is identical to that formed from the 
 * original array nums.
 * 
 * For example, given nums = [2,1,3], we will have 2 as the root, 1 as a left child, 
 * and 3 as a right child. The array [2,3,1] also yields the same BST but [3,2,1] 
 * yields a different BST.
 * Return the number of ways to reorder nums such that the BST formed is identical 
 * to the original BST formed from nums.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * 
 * Example 1:
 * Input: nums = [2,1,3]
 * Output: 1
 * Explanation: We can reorder nums to be [2,3,1] which will yield the same BST. 
 * There are no other ways to reorder nums which will yield the same BST.
 * 
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= nums.length
 * - All integers in nums are distinct.
 * 
 * Approach:
 * Use Combinatorics (Binomial Coefficients) to determine how many ways you can 
 * interleave elements of the left and right subtrees while preserving their relative 
 * internal orders. Apply this recursively down the tree.
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 */

import java.util.ArrayList;
import java.util.List;

public class Number_of_Ways_to_Reorder_Array {

    private static final int MOD = 1_000_000_007;
    private long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        return (int) ((dfs(numList) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < m; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);
        long interleaveWays = comb[left.size() + right.size()][left.size()];

        return (leftWays * rightWays % MOD) * interleaveWays % MOD;
    }

    public static void main(String[] args) {
        Number_of_Ways_to_Reorder_Array solution = new Number_of_Ways_to_Reorder_Array();

        System.out.println(solution.numOfWays(new int[]{2, 1, 3})); // Expected: 1
        System.out.println(solution.numOfWays(new int[]{3, 4, 5, 1, 2})); // Expected: 5
        System.out.println(solution.numOfWays(new int[]{1, 2, 3})); // Expected: 0
    }
}
/*
 * Problem: 2916. Subarrays Distinct Element Sum of Squares II (LeetCode - Hard)
 * 
 * You are given a 0-indexed integer array nums.
 * The distinct count of a subarray of nums is defined as:
 * - Let nums[i..j] be a subarray of nums consisting of all the indices from i to j 
 *   such that 0 <= i <= j < nums.length. Then the number of distinct values in 
 *   nums[i..j] is called the distinct count of nums[i..j].
 * Return the sum of the squares of distinct counts of all subarrays of nums.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Example 1:
 * Input: nums = [1,2,1]
 * Output: 15
 * Explanation: Six possible subarrays are:
 * [1]: 1 distinct value
 * [2]: 1 distinct value
 * [1]: 1 distinct value
 * [1,2]: 2 distinct values
 * [2,1]: 2 distinct values
 * [1,2,1]: 2 distinct values
 * The sum of the squares of the distinct counts in all subarrays is equal to 
 * 1^2 + 1^2 + 1^2 + 2^2 + 2^2 + 2^2 = 15.
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 
 * Approach:
 * Using a Segment Tree with Lazy Propagation, dynamically maintain the number of 
 * distinct elements for subarrays. When evaluating a new element at index i, 
 * increment the distinct count count for all subarray start bounds bounded between 
 * [prev_occurrence(nums[i]) + 1, i]. Algebraically update the squared sums 
 * via (a+x)^2 = a^2 + 2ax + x^2.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;

public class Subarrays_Distinct_Element_Sum_of_Squares_II {

    private static final int MOD = 1000000007;

    static class SegTree {
        int n;
        long[] sum, sq_sum, lazy;

        public SegTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq_sum = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void apply(int node, int start, int end, long val) {
            long len = end - start + 1;
            long valSq = (val * val) % MOD;
            
            sq_sum[node] = (sq_sum[node] + 2 * val * sum[node] + valSq * len) % MOD;
            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        private void pushDown(int node, int start, int end) {
            if (lazy[node] != 0) {
                int mid = start + (end - start) / 2;
                apply(2 * node + 1, start, mid, lazy[node]);
                apply(2 * node + 2, mid + 1, end, lazy[node]);
                lazy[node] = 0;
            }
        }

        private void pushUp(int node) {
            sum[node] = (sum[2 * node + 1] + sum[2 * node + 2]) % MOD;
            sq_sum[node] = (sq_sum[2 * node + 1] + sq_sum[2 * node + 2]) % MOD;
        }

        public void update(int node, int start, int end, int l, int r, long val) {
            if (l > end || r < start) return;
            if (l <= start && end <= r) {
                apply(node, start, end, val);
                return;
            }
            pushDown(node, start, end);
            int mid = start + (end - start) / 2;
            update(2 * node + 1, start, mid, l, r, val);
            update(2 * node + 2, mid + 1, end, l, r, val);
            pushUp(node);
        }
        
        public long getTotalSqSum() {
            return sq_sum[0];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegTree tree = new SegTree(n);
        
        int[] last = new int[100005];
        Arrays.fill(last, -1);
        
        long totalResult = 0;
        
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];
            
            tree.update(0, 0, n - 1, prev + 1, i, 1);
            totalResult = (totalResult + tree.getTotalSqSum()) % MOD;
            
            last[x] = i;
        }
        
        return (int) totalResult;
    }

    public static void main(String[] args) {
        Subarrays_Distinct_Element_Sum_of_Squares_II solution = 
                new Subarrays_Distinct_Element_Sum_of_Squares_II();

        int[] nums1 = {1, 2, 1};
        System.out.println(solution.sumCounts(nums1)); // Expected: 15

        int[] nums2 = {2, 2};
        System.out.println(solution.sumCounts(nums2)); // Expected: 3
    }
}
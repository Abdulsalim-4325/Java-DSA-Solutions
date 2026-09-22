/*
 * LeetCode 3525. Find X Value of Array II
 * Hard
 * 
 * You are given an array of positive integers nums and a positive integer k. 
 * You are also given a 2D array queries, where queries[i] = [index, value, start, x].
 * 
 * For each query in queries you need to determine the x-value of nums for xi after 
 * performing the following actions:
 * 1. Update nums[index] to value. Only this step persists for the rest of the queries.
 * 2. Remove the prefix nums[0..(start - 1)].
 * 3. Find the number of non-overlapping suffixes from this remaining array such that 
 *    removing them leaves a non-empty remainder product == x mod k.
 * 
 * Constraints:
 * 1 <= nums[i] <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= k <= 5
 * 1 <= queries.length <= 2 * 10^4
 */

import java.util.Arrays;

public class Find_X_Value_of_Array_II {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 3;
        int[][] queries1 = {
            {2, 2, 0, 2},
            {3, 3, 3, 0},
            {0, 1, 0, 1}
        };
        System.out.println("Test Case 1: " + Arrays.toString(solver.resultArray(nums1, k1, queries1))); 
        // Expected: [2, 2, 2]

        int[] nums2 = {1, 2, 4, 8, 16, 32};
        int k2 = 4;
        int[][] queries2 = {
            {0, 2, 0, 2},
            {0, 2, 0, 1}
        };
        System.out.println("Test Case 2: " + Arrays.toString(solver.resultArray(nums2, k2, queries2))); 
        // Expected: [1, 0]
    }
}

class Solution {
    private int[] totalProd;
    private int[][] prefixCounts;
    private int target_x;
    private int current_total_prod;
    private int current_ans;
    
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        totalProd = new int[4 * n];
        prefixCounts = new int[4 * n][k];
        
        build(1, 0, n - 1, nums, k);
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            update(1, 0, n - 1, idx, val, k);
            
            target_x = x;
            current_total_prod = 1 % k; 
            current_ans = 0;
            
            query(1, 0, n - 1, start, n - 1, k);
            
            result[i] = current_ans;
        }
        
        return result;
    }
    
    private void build(int u, int tl, int tr, int[] nums, int k) {
        if (tl == tr) {
            int val = nums[tl] % k;
            totalProd[u] = val;
            prefixCounts[u][val] = 1;
            return;
        }
        int tm = (tl + tr) / 2;
        build(2 * u, tl, tm, nums, k);
        build(2 * u + 1, tm + 1, tr, nums, k);
        
        pull(u, k);
    }
    
    private void update(int u, int tl, int tr, int pos, int val, int k) {
        if (tl == tr) {
            int v = val % k;
            totalProd[u] = v;
            for (int i = 0; i < k; i++) prefixCounts[u][i] = 0;
            prefixCounts[u][v] = 1;
            return;
        }
        int tm = (tl + tr) / 2;
        if (pos <= tm) {
            update(2 * u, tl, tm, pos, val, k);
        } else {
            update(2 * u + 1, tm + 1, tr, pos, val, k);
        }
        
        pull(u, k);
    }
    
    private void pull(int u, int k) {
        int left = 2 * u;
        int right = 2 * u + 1;
        totalProd[u] = (totalProd[left] * totalProd[right]) % k;
        
        for (int i = 0; i < k; i++) {
            prefixCounts[u][i] = prefixCounts[left][i];
        }
        for (int i = 0; i < k; i++) {
            if (prefixCounts[right][i] > 0) {
                int newProd = (totalProd[left] * i) % k;
                prefixCounts[u][newProd] += prefixCounts[right][i];
            }
        }
    }
    
    private void query(int u, int tl, int tr, int ql, int qr, int k) {
        if (ql > tr || qr < tl) return;
        
        if (ql <= tl && tr <= qr) {
            for (int i = 0; i < k; i++) {
                if ((current_total_prod * i) % k == target_x) {
                    current_ans += prefixCounts[u][i];
                }
            }
            current_total_prod = (current_total_prod * totalProd[u]) % k;
            return;
        }
        
        int tm = (tl + tr) / 2;
        query(2 * u, tl, tm, ql, qr, k);
        query(2 * u + 1, tm + 1, tr, ql, qr, k);
    }
}
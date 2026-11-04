/*
 * Problem: 3505. Minimum Operations to Make Elements Within K Subarrays Equal (LeetCode - Hard)
 * 
 * You are given an integer array nums and two integers, x and k.
 * Return the minimum number of operations needed to have at least k non-overlapping 
 * subarrays of size exactly x in nums, where all elements within each subarray are equal.
 * 
 * Approach:
 * Evaluates dynamic subarrays mapping lazy deletion bounds onto dual structural Priority Queues. 
 * Resolving boundaries iteratively establishes strict median modification constraints scaling efficiently. 
 * Final subsets isolate interval overlaps mapping DP variables tracking non-overlapping states precisely.
 * 
 * Time Complexity: O(N log x + N * K)
 * Space Complexity: O(N * K)
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Minimum_Operations_To_Make_Elements_Within_K_Subarrays_Equal {
    class Node {
        long val;
        int id;
        Node(long val, int id) {
            this.val = val;
            this.id = id;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) return Long.compare(b.val, a.val);
            return Integer.compare(b.id, a.id);
        });
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) return Long.compare(a.val, b.val);
            return Integer.compare(a.id, b.id);
        });
        
        boolean[] inL = new boolean[n];
        long sumL = 0;
        long sumR = 0;
        int sizeL = 0;
        int sizeR = 0;
        
        for (int i = 0; i < n; i++) {
            if (i >= x) {
                int outId = i - x;
                if (inL[outId]) {
                    sumL -= nums[outId];
                    sizeL--;
                } else {
                    sumR -= nums[outId];
                    sizeR--;
                }
            }
            
            while (!maxHeap.isEmpty() && maxHeap.peek().id <= i - x) maxHeap.poll();
            while (!minHeap.isEmpty() && minHeap.peek().id <= i - x) minHeap.poll();
            
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                maxHeap.offer(new Node(nums[i], i));
                sumL += nums[i];
                sizeL++;
                inL[i] = true;
            } else if (!minHeap.isEmpty() && nums[i] > minHeap.peek().val) {
                minHeap.offer(new Node(nums[i], i));
                sumR += nums[i];
                sizeR++;
                inL[i] = false;
            } else {
                maxHeap.offer(new Node(nums[i], i));
                sumL += nums[i];
                sizeL++;
                inL[i] = true;
            }
            
            int limit = Math.min(i + 1, x);
            int targetL = limit / 2;
            
            while (sizeL > targetL) {
                while (!maxHeap.isEmpty() && maxHeap.peek().id <= i - x) maxHeap.poll();
                Node top = maxHeap.poll();
                sumL -= top.val;
                sizeL--;
                inL[top.id] = false;
                sumR += top.val;
                sizeR++;
                minHeap.offer(top);
            }
            
            while (sizeL < targetL) {
                while (!minHeap.isEmpty() && minHeap.peek().id <= i - x) minHeap.poll();
                Node top = minHeap.poll();
                sumR -= top.val;
                sizeR--;
                inL[top.id] = true;
                sumL += top.val;
                sizeL++;
                maxHeap.offer(top);
            }
            
            if (i >= x - 1) {
                while (!minHeap.isEmpty() && minHeap.peek().id <= i - x) minHeap.poll();
                long c = sumR - sumL;
                if (x % 2 != 0) {
                    long median = minHeap.peek().val;
                    c -= median;
                }
                cost[i - x + 1] = c;
            }
        }
        
        long[][] dp = new long[n + 1][k + 1];
        long INF = (long) 1e18;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }
        
        return dp[n][k];
    }

    public static void main(String[] args) {
        Minimum_Operations_To_Make_Elements_Within_K_Subarrays_Equal solution = 
                new Minimum_Operations_To_Make_Elements_Within_K_Subarrays_Equal();

        int[] nums1 = {5, -2, 1, 3, 7, 3, 6, 4, -1};
        System.out.println(solution.minOperations(nums1, 3, 2)); // Expected: 8

        int[] nums2 = {9, -2, -2, -2, 1, 5};
        System.out.println(solution.minOperations(nums2, 2, 2)); // Expected: 3

        int[] nums3 = {-16, -2, 9, -7};
        System.out.println(solution.minOperations(nums3, 4, 1)); // Expected: 30
    }
}
/*
 * Problem: 2747. Count Zero Request Servers (LeetCode - Medium)
 * 
 * You are given an integer n denoting the total number of servers and a 
 * 2D 0-indexed integer array logs, where logs[i] = [server_id, time].
 * You are also given an integer x and a 0-indexed integer array queries.
 * 
 * Return a 0-indexed integer array arr of length queries.length where arr[i] 
 * represents the number of servers that did not receive any requests during 
 * the time interval [queries[i] - x, queries[i]].
 * 
 * Constraints:
 * 1 <= n, logs.length, queries.length <= 10^5
 * 1 <= logs[i][1] <= 10^6
 * 1 <= x <= 10^5
 * 
 * Approach:
 * Offline Query Processing & Sliding Window.
 * 1. Sort both the logs and the queries chronologically.
 * 2. Track the number of active servers handling requests dynamically 
 *    using two pointers marking boundaries (right <= query_time, left < query_time - x).
 * 3. Total un-requested servers = total servers (n) - active servers.
 * 
 * Time Complexity: O(L log L + Q log Q)
 * Space Complexity: O(N + Q)
 */

import java.util.Arrays;

public class Count_Zero_Request_Servers {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int q = queries.length;
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; 
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[q];
        int[] counts = new int[n + 1]; 
        int activeServers = 0;
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < q; i++) {
            int qTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            
            int minTime = qTime - x;
            int maxTime = qTime;
            
            while (right < logs.length && logs[right][1] <= maxTime) {
                int serverId = logs[right][0];
                if (counts[serverId] == 0) {
                    activeServers++; 
                }
                counts[serverId]++;
                right++;
            }
            
            while (left < logs.length && logs[left][1] < minTime) {
                int serverId = logs[left][0];
                counts[serverId]--;
                if (counts[serverId] == 0) {
                    activeServers--; 
                }
                left++;
            }
            
            ans[originalIdx] = n - activeServers;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Count_Zero_Request_Servers solution = new Count_Zero_Request_Servers();
        
        // Example 1
        int n1 = 3;
        int[][] logs1 = {{1, 3}, {2, 6}, {1, 5}};
        int x1 = 5;
        int[] queries1 = {10, 11};
        System.out.println(Arrays.toString(solution.countServers(n1, logs1, x1, queries1))); 
        // Expected: [1, 2]

        // Example 2
        int n2 = 3;
        int[][] logs2 = {{2, 4}, {2, 1}, {1, 2}, {3, 1}};
        int x2 = 2;
        int[] queries2 = {3, 4};
        System.out.println(Arrays.toString(solution.countServers(n2, logs2, x2, queries2))); 
        // Expected: [0, 1]
    }
}
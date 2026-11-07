/*
 * Problem: 1882. Process Tasks Using Servers (LeetCode - Medium)
 * 
 * You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively. 
 * servers[i] is the weight of the ith server, and tasks[j] is the time needed to process 
 * the jth task in seconds.
 * 
 * Tasks are assigned to free servers with the smallest weight, and in case of a tie, the 
 * smallest index. If there are no free servers, we wait until a server becomes free.
 * 
 * Approach:
 * Evaluates queue constraints efficiently mapping parameters entirely offline utilizing 
 * strictly Event-Based Time simulation loops spanning Dual Priority Queues (Min-Heaps).
 * Tracking node boundaries natively protects states against chronological bottlenecks shifting 
 * parameters strictly into discrete evaluation bounds. 
 * 
 * Time Complexity: O((M + N) log N)
 * Space Complexity: O(N)
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Process_Tasks_Using_Servers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            return Long.compare(a[0], b[0]);
        });
        
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }
        
        int m = tasks.length;
        int[] ans = new int[m];
        long time = 0;
        
        for (int j = 0; j < m; j++) {
            time = Math.max(time, (long) j);
            
            if (freeServers.isEmpty()) {
                time = Math.max(time, busyServers.peek()[0]);
            }
            
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                long[] server = busyServers.poll();
                freeServers.offer(new int[]{(int)server[1], (int)server[2]});
            }
            
            int[] bestServer = freeServers.poll();
            ans[j] = bestServer[1];
            
            busyServers.offer(new long[]{time + tasks[j], bestServer[0], bestServer[1]});
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Process_Tasks_Using_Servers solution = new Process_Tasks_Using_Servers();
        
        // Example 1
        int[] servers1 = {3, 3, 2};
        int[] tasks1 = {1, 2, 3, 2, 1, 2};
        System.out.println(Arrays.toString(solution.assignTasks(servers1, tasks1))); 
        // Expected: [2, 2, 0, 2, 1, 2]

        // Example 2
        int[] servers2 = {5, 1, 4, 3, 2};
        int[] tasks2 = {2, 1, 2, 4, 5, 2, 1};
        System.out.println(Arrays.toString(solution.assignTasks(servers2, tasks2))); 
        // Expected: [1, 4, 1, 4, 1, 3, 2]
    }
}
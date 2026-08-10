/*
High Effort vs Low Effort

Given two integer arrays h[] and l[], where h[i] and l[i] denote the number
of tasks that can be completed on the i-th day by performing a high-effort
task and a low-effort task, respectively.

For each day, you may choose exactly one of the following:
- Perform no task.
- Perform a low-effort task.
- Perform a high-effort task, which can only be performed on the first day
  or if no task was performed on the previous day.

Return the maximum total number of tasks that can be completed over all days.
*/

import java.util.*;

public class High_Effort_vs_Low_Effort {

    public static int maxTask(int[] h, int[] l) {
        int n = h.length;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = Math.max(h[0], l[0]);

        for (int i = 2; i <= n; i++) {
            int lowEffort = dp[i - 1] + l[i - 1];
            int highEffort = dp[i - 2] + h[i - 1];
            int noTask = dp[i - 1];

            dp[i] = Math.max(noTask, Math.max(lowEffort, highEffort));
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] h1 = {2, 8, 1};
        int[] l1 = {1, 2, 1};

        System.out.println(maxTask(h1, l1));

        int[] h2 = {3, 6, 8, 7, 6};
        int[] l2 = {1, 5, 4, 5, 3};

        System.out.println(maxTask(h2, l2));
    }
}
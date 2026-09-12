/*
 * LeetCode 3414. Maximum Score of Non-overlapping Intervals
 * Hard
 * 
 * You are given a 2D integer array intervals, where intervals[i] = [li, ri, weighti]. 
 * Interval i starts at position li and ends at ri, and has a weight of weighti. 
 * You can choose up to 4 non-overlapping intervals. The score of the chosen intervals 
 * is defined as the total sum of their weights.
 * 
 * Return the lexicographically smallest array of at most 4 indices from intervals 
 * with maximum score, representing your choice of non-overlapping intervals.
 * Two intervals are said to be non-overlapping if they do not share any points. 
 * 
 * Example 1:
 * Input: intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]
 * Output: [2,3]
 * 
 * Example 2:
 * Input: intervals = [[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]
 * Output: [1,3,5,6]
 * 
 * Constraints:
 * 1 <= intevals.length <= 5 * 10^4
 * intervals[i].length == 3
 * intervals[i] = [li, ri, weighti]
 * 1 <= li <= ri <= 10^9
 * 1 <= weighti <= 10^9
 */

import java.util.Arrays;
import java.util.List;

public class Maximum_Score_of_Non_overlapping_Intervals {
    public static void main(String[] args) {
        Solution solver = new Solution();

        List<List<Integer>> intervals1 = Arrays.asList(
            Arrays.asList(1, 3, 2), Arrays.asList(4, 5, 2), Arrays.asList(1, 5, 5),
            Arrays.asList(6, 9, 3), Arrays.asList(6, 7, 1), Arrays.asList(8, 9, 1)
        );
        System.out.println("Test Case 1: " + Arrays.toString(solver.maximumWeight(intervals1))); // Expected: [2, 3]

        List<List<Integer>> intervals2 = Arrays.asList(
            Arrays.asList(5, 8, 1), Arrays.asList(6, 7, 7), Arrays.asList(4, 7, 3),
            Arrays.asList(9, 10, 6), Arrays.asList(7, 8, 2), Arrays.asList(11, 14, 3),
            Arrays.asList(3, 5, 5)
        );
        System.out.println("Test Case 2: " + Arrays.toString(solver.maximumWeight(intervals2))); // Expected: [1, 3, 5, 6]
    }
}

class Solution {
    class Interval implements Comparable<Interval> {
        int l, r, w, id;
        public Interval(int l, int r, int w, int id) {
            this.l = l; this.r = r; this.w = w; this.id = id;
        }
        @Override
        public int compareTo(Interval other) {
            if (this.l != other.l) return Integer.compare(this.l, other.l);
            return Integer.compare(this.r, other.r);
        }
    }

    class Result {
        long score;
        int[] ids;
        public Result(long score, int[] ids) {
            this.score = score; this.ids = ids;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(
                intervalsList.get(i).get(0), intervalsList.get(i).get(1),
                intervalsList.get(i).get(2), i
            );
        }
        
        Arrays.sort(intervals);
        
        Result[][] dp = new Result[n + 1][5];
        for (int i = 0; i <= n; i++) dp[i][0] = new Result(0L, new int[0]);
        for (int k = 1; k <= 4; k++) dp[n][k] = new Result(0L, new int[0]);
        
        for (int i = n - 1; i >= 0; i--) {
            int low = i + 1, high = n - 1, next_j = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals[mid].l > intervals[i].r) {
                    next_j = mid;
                    high = mid - 1; 
                } else {
                    low = mid + 1;
                }
            }
            
            for (int k = 1; k <= 4; k++) {
                Result skip = dp[i + 1][k];
                Result takePrev = dp[next_j][k - 1];
                
                long newScore = intervals[i].w + takePrev.score;
                int[] newIds = Arrays.copyOf(takePrev.ids, takePrev.ids.length + 1);
                newIds[newIds.length - 1] = intervals[i].id;
                Arrays.sort(newIds);
                
                Result take = new Result(newScore, newIds);
                dp[i][k] = getBetter(skip, take);
            }
        }
        
        return dp[0][4].ids;
    }
    
    private Result getBetter(Result a, Result b) {
        if (a.score > b.score) return a;
        if (b.score > a.score) return b;
        
        for (int i = 0; i < Math.min(a.ids.length, b.ids.length); i++) {
            if (a.ids[i] < b.ids[i]) return a;
            if (b.ids[i] < a.ids[i]) return b;
        }
        return a.ids.length < b.ids.length ? a : b;
    }
}
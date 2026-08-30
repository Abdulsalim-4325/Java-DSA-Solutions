/*
 * Marks from Ranks
 * Medium
 * 
 * Consider an input where all marks obtained are divided into intervals of consecutive numbers 
 * represented as l[] and r[] where l[i] and r[i] represent the starting and ending marks (inclusive) 
 * of the i-th interval. The intervals are sorted in increasing order and do not overlap. 
 * The rank of a mark is defined by its position among all valid marks in increasing order, 
 * with the smallest mark assigned rank 1, the next smallest rank 2, and so on. 
 * Given an array rank[], for each value in rank[], find the corresponding mark and return as an array.
 *
 * Example 1:
 * Input: l[] =, r[] =, rank[] = [2, 5, 8]
 * Output: [2, 7, 14]
 *
 * Example 2:
 * Input: l[] =, r[] =, rank[] = [1, 4, 6]
 * Output: [5, 10, 12]
 *
 * Constraints:
 * 1 <= l.size(), r.size(), rank.size() <= 10^5
 * 1 <= l[i], r[i], rank[i] <= 10^5
 */

import java.util.ArrayList;

public class Marks_from_Ranks {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] l1 = {1, 6, 14};
        int[] r1 = {3, 9, 15};
        int[] rank1 = {2, 5, 8};
        System.out.println("Test Case 1: " + solver.getMarks(l1, r1, rank1)); // Expected: [2, 7, 14]

        // Test Case 2
        int[] l2 = {5, 10};
        int[] r2 = {7, 12};
        int[] rank2 = {1, 4, 6};
        System.out.println("Test Case 2: " + solver.getMarks(l2, r2, rank2)); // Expected: [5, 10, 12]
    }
}

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        int[] pref = new int[n];
        
        pref[0] = r[0] - l[0] + 1;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + (r[i] - l[i] + 1);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int rk : rank) {
            int low = 0;
            int high = n - 1;
            int idx = 0;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] >= rk) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            
            int elementsBefore = (idx > 0) ? pref[idx - 1] : 0;
            int offset = rk - elementsBefore - 1;
            result.add(l[idx] + offset);
        }
        
        return result;
    }
}

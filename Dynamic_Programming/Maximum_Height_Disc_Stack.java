/*
 * Maximum Height Disc Stack
 * Difficulty: Hard | Accuracy: 48.05% | Submissions: 5K+ | Points: 8
 * 
 * Given two arrays r[] and h[] of size n, where r[i] and h[i] represent the 
 * radius and height of the i-th circular disc, respectively.
 * A disc can be placed above another disc only if both its radius and height 
 * are strictly smaller than those of the disc below it.
 * Find the maximum possible height of a stack that can be formed using the 
 * given discs. Each disc can be used at most once.
 * 
 * Examples:
 * Input: r[] = [5, 7, 3], h[] = [6, 5, 4]
 * Output: 10
 * Explanation: The discs (3, 4) and (5, 6) form a valid stack. 
 * Therefore, the maximum possible height is 4 + 6 = 10.
 * 
 * Input: r[] = [3, 7], h[] = [7, 4]
 * Output: 7
 * Explanation: Neither disc can be placed above the other because both 
 * required dimensions are not strictly smaller. Maximum possible height is 7.
 * 
 * Constraints:
 * 1 <= r.size(), h.size() <= 10^5
 * 1 <= r[i], h[i] <= 1000
 */

import java.util.Arrays;

public class Maximum_Height_Disc_Stack {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] r1 = {5, 7, 3};
        int[] h1 = {6, 5, 4};
        System.out.println("Test Case 1: " + solver.maxStackHeight(r1, h1)); // Expected: 10

        int[] r2 = {3, 7};
        int[] h2 = {7, 4};
        System.out.println("Test Case 2: " + solver.maxStackHeight(r2, h2)); // Expected: 7
    }
}

class Solution {
    static class Disc implements Comparable<Disc> {
        int r, h;
        
        Disc(int r, int h) {
            this.r = r;
            this.h = h;
        }
        
        @Override
        public int compareTo(Disc other) {
            if (this.r != other.r) {
                return Integer.compare(this.r, other.r);
            }
            return Integer.compare(other.h, this.h);
        }
    }

    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        Disc[] discs = new Disc[n];
        int maxH = 0;
        
        for (int i = 0; i < n; i++) {
            discs[i] = new Disc(r[i], h[i]);
            if (h[i] > maxH) {
                maxH = h[i];
            }
        }

        Arrays.sort(discs);

        int[] bit = new int[maxH + 2];
        int maxTotalHeight = 0;

        for (Disc d : discs) {
            int prevMax = query(bit, d.h - 1);
            int currentHeight = prevMax + d.h;
            maxTotalHeight = Math.max(maxTotalHeight, currentHeight);
            update(bit, d.h, currentHeight, maxH + 1);
        }

        return maxTotalHeight;
    }

    private void update(int[] bit, int idx, int val, int limit) {
        for (; idx <= limit; idx += idx & -idx) {
            bit[idx] = Math.max(bit[idx], val);
        }
    }

    private int query(int[] bit, int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res = Math.max(res, bit[idx]);
        }
        return res;
    }
}
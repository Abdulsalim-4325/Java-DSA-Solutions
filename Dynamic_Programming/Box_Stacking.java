/*
 * Box Stacking
 * Difficulty: Hard | Accuracy: 41.0% | Submissions: 40K+ | Points: 8
 * 
 * Given three arrays height[], width[], and length[] of size n, representing 
 * the dimensions of the ith box, find the maximum possible height of a stack 
 * formed using these boxes.
 * 
 * Rules:
 * - A box can be rotated so that any of its dimensions becomes its height.
 * - A box can be placed on top of another only if BOTH dimensions of its base 
 *   are strictly smaller than those of the box below.
 * - Multiple instances of the same box can be used.
 * 
 * Constraints:
 * 1 <= height.size(), width.size(), length.size() <= 100
 * 1 <= height[i], width[i], length[i] <= 10^6
 */

import java.util.Arrays;

public class Box_Stacking {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] height1 = {4, 1, 4, 10};
        int[] width1 = {6, 2, 5, 12};
        int[] length1 = {7, 3, 6, 32};
        System.out.println("Test Case 1: " + solver.maxHeight(height1, width1, length1)); 
        // Expected: 60

        int[] height2 = {1, 4, 3};
        int[] width2 = {2, 5, 4};
        int[] length2 = {3, 6, 1};
        System.out.println("Test Case 2: " + solver.maxHeight(height2, width2, length2)); 
        // Expected: 15
    }
}

class Solution {
    static class Box implements Comparable<Box> {
        int h, w, l;

        Box(int h, int w, int l) {
            this.h = h;
            this.w = Math.min(w, l);
            this.l = Math.max(w, l);
        }

        @Override
        public int compareTo(Box other) {
            long areaThis = (long) this.w * this.l;
            long areaOther = (long) other.w * other.l;
            return Long.compare(areaOther, areaThis);
        }
    }

    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        Box[] boxes = new Box[n * 3];

        for (int i = 0; i < n; i++) {
            int h = height[i];
            int w = width[i];
            int l = length[i];

            boxes[i * 3] = new Box(h, w, l);
            boxes[i * 3 + 1] = new Box(w, h, l);
            boxes[i * 3 + 2] = new Box(l, h, w);
        }

        Arrays.sort(boxes);

        int[] dp = new int[n * 3];
        int maxStackHeight = 0;

        for (int i = 0; i < n * 3; i++) {
            dp[i] = boxes[i].h; 
            
            for (int j = 0; j < i; j++) {
                if (boxes[i].w < boxes[j].w && boxes[i].l < boxes[j].l) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i].h);
                }
            }
            maxStackHeight = Math.max(maxStackHeight, dp[i]);
        }

        return maxStackHeight;
    }
}
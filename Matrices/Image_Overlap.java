/*
 * LeetCode 835. Image Overlap
 * Medium
 * 
 * You are given two images, img1 and img2, represented as binary, square matrices of size n x n. 
 * A binary matrix has only 0s and 1s as values.
 * We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down 
 * any number of units. We then place it on top of the other image. We can then calculate the overlap 
 * by counting the number of positions that have a 1 in both images.
 * 
 * Example 1:
 * Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
 * Output: 3
 * 
 * Example 2:
 * Input: img1 = [[1]], img2 = [[1]]
 * Output: 1
 * 
 * Example 3:
 * Input: img1 = [[0]], img2 = [[0]]
 * Output: 0
 * 
 * Constraints:
 * n == img1.length == img1[i].length
 * n == img2.length == img2[i].length
 * 1 <= n <= 30
 * img1[i][j] is either 0 or 1.
 * img2[i][j] is either 0 or 1.
 */

import java.util.ArrayList;
import java.util.List;

public class Image_Overlap {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] img1_1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        int[][] img2_1 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };
        System.out.println("Test Case 1: " + solver.largestOverlap(img1_1, img2_1)); // Expected: 3

        int[][] img1_2 = {{1}};
        int[][] img2_2 = {{1}};
        System.out.println("Test Case 2: " + solver.largestOverlap(img1_2, img2_2)); // Expected: 1

        int[][] img1_3 = {{0}};
        int[][] img2_3 = {{0}};
        System.out.println("Test Case 3: " + solver.largestOverlap(img1_3, img2_3)); // Expected: 0
    }
}

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) list1.add(new int[]{r, c});
                if (img2[r][c] == 1) list2.add(new int[]{r, c});
            }
        }
        
        int maxOverlap = 0;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        
        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                int dx = p2[0] - p1[0] + n;
                int dy = p2[1] - p1[1] + n;
                
                count[dx][dy]++;
                
                if (count[dx][dy] > maxOverlap) {
                    maxOverlap = count[dx][dy];
                }
            }
        }
        
        return maxOverlap;
    }
}
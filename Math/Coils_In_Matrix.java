/*
 * Coils in Matrix
 * Difficulty: Medium | Accuracy: 64.35% | Submissions: 8K+ | Points: 4
 * 
 * Given a positive integer n, consider a 4n * 4n matrix filled with integers 
 * from 1 to (4n) * (4n) in row-major order (left to right, top to bottom). 
 * Form two coils from the matrix:
 * - The first coil starts from the top-left cell (0, 0) and spirals inward.
 * - The second coil starts from the bottom-right cell (4n - 1, 4n - 1) and 
 *   spirals inward in the opposite direction.
 * Return these two coils in the same order.
 * 
 * Example 1:
 * Input: n = 1
 * Output: [[1, 5, 9, 13, 14, 15, 11, 7], [16, 12, 8, 4, 3, 2, 6, 10]]
 * 
 * Constraints:
 * 1 <= n <= 20
 */

import java.util.ArrayList;

public class Coils_In_Matrix {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1 (n = 1):");
        ArrayList<ArrayList<Integer>> result1 = solver.formCoils(1);
        System.out.println("Coil 1: " + result1.get(0));
        System.out.println("Coil 2: " + result1.get(1));

        System.out.println("\nTest Case 2 (n = 2):");
        ArrayList<ArrayList<Integer>> result2 = solver.formCoils(2);
        System.out.println("Coil 1: " + result2.get(0));
        System.out.println("Coil 2: " + result2.get(1));
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();
        
        int m = 4 * n;
        int totalElements = m * m;
        
        int x = 0;
        int y = 0;
        coil1.add(1);
        
        for (int i = 0; i < m - 1; i++) {
            x++;
            coil1.add(x * m + y + 1);
        }
        
        int stepLength = m - 2;
        int flag = 0; 
        
        while (stepLength > 0) {
            if (flag == 0) {
                for (int i = 0; i < stepLength; i++) {
                    y++;
                    coil1.add(x * m + y + 1);
                }
                for (int i = 0; i < stepLength; i++) {
                    x--;
                    coil1.add(x * m + y + 1);
                }
            } else {
                for (int i = 0; i < stepLength; i++) {
                    y--;
                    coil1.add(x * m + y + 1);
                }
                for (int i = 0; i < stepLength; i++) {
                    x++;
                    coil1.add(x * m + y + 1);
                }
            }
            stepLength -= 2;
            flag = 1 - flag;
        }
        
        for (int val : coil1) {
            coil2.add(totalElements + 1 - val);
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(coil1);
        result.add(coil2);
        
        return result;
    }
}
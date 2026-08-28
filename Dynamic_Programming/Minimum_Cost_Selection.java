/*
 * Minimum Cost Selection
 * Difficulty: Medium | Accuracy: 50.75% | Submissions: 11K+ | Points: 4
 * 
 * Given an n × 3 matrix mat[][], where each row represents the costs of three available choices 
 * at a shop, select exactly one choice from each row such that the same choice is not selected 
 * in two adjacent rows.
 * Return the minimum total cost required.
 * 
 * Examples:
 * 
 * Input: mat[][] = [[1, 50, 50], [50, 50, 50], [1, 50, 50]]
 * Output: 52
 * Explanation: One optimal selection is- Row 1: Choice 1 (Cost = 1), Row 2: Choice 2 (Cost = 50), Row 3: Choice 1 (Cost = 1)
 * Total cost = 1 + 50 + 1 = 52.
 * 
 * Input: mat[][] = [[1, 4, 1], [3, 2, 2], [3, 2, 3]]
 * Output: 5
 * Explanation: One optimal selection is- Row 1: Choice 1 (Cost = 1), Row 2: Choice 2 (Cost = 2), Row 3: Choice 3 (Cost = 2)
 * Total cost = 1 + 2 + 2 = 5.
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 3 <= mat[0].size() <= 3
 * 1 <= mat[i][j] <= 100
 * mat.rows = n
 */

public class Minimum_Cost_Selection {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] mat1 = {
            {1, 50, 50},
            {50, 50, 50},
            {1, 50, 50}
        };
        System.out.println("Test Case 1: " + solver.minCost(mat1)); // Expected: 52

        int[][] mat2 = {
            {1, 4, 1},
            {3, 2, 2},
            {3, 2, 3}
        };
        System.out.println("Test Case 2: " + solver.minCost(mat2)); // Expected: 5
    }
}

class Solution {
    public int minCost(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        
        int cost0 = mat[0][0];
        int cost1 = mat[0][1];
        int cost2 = mat[0][2];
        
        for (int i = 1; i < mat.length; i++) {
            int curr0 = mat[i][0] + Math.min(cost1, cost2);
            int curr1 = mat[i][1] + Math.min(cost0, cost2);
            int curr2 = mat[i][2] + Math.min(cost0, cost1);
            
            cost0 = curr0;
            cost1 = curr1;
            cost2 = curr2;
        }
        
        return Math.min(cost0, Math.min(cost1, cost2));
    }
}
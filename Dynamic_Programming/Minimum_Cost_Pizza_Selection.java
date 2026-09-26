/*
 * Minimum Cost Pizza Selection
 * Difficulty: Medium | Accuracy: 64.66% | Submissions: 7K+ | Points: 4
 * 
 * Given the area of Small, Medium, and Large pizzas as s, m, and l units, 
 * and their respective costs as cs, cm, and cl, find the minimum amount of money 
 * required to buy pizzas whose total area is at least x. 
 * You may buy any number of pizzas of each type.
 * 
 * Examples:
 * Input: x = 16, s = 3, m = 6, l = 9, cs = 50, cm = 150, cl = 300
 * Output: 300
 * Explanation: We want at least 16 sq. units of Pizza. 
 * 6 units of s = 18 sq units, Cost = 300.
 * Of all the Arrangements, Minimum Cost is Rs. 300.
 * 
 * Input: x = 10, s = 1, m = 3, l = 10, cs = 10, cm = 20, cl = 50
 * Output: 50
 * 
 * Constraints:
 * 1 <= x <= 500
 * 1 <= s <= m <= l <= 100
 * 1 <= cs <= cm <= cl <= 100
 */

public class Minimum_Cost_Pizza_Selection {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int x1 = 16, s1 = 3, m1 = 6, l1 = 9;
        int cs1 = 50, cm1 = 150, cl1 = 300;
        System.out.println("Test Case 1: " + solver.minimumCost(x1, s1, m1, l1, cs1, cm1, cl1)); 
        // Expected: 300

        // Test Case 2
        int x2 = 10, s2 = 1, m2 = 3, l2 = 10;
        int cs2 = 10, cm2 = 20, cl2 = 50;
        System.out.println("Test Case 2: " + solver.minimumCost(x2, s2, m2, l2, cs2, cm2, cl2)); 
        // Expected: 50
    }
}

class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int[] dp = new int[x + 1];
        
        for (int i = 1; i <= x; i++) {
            int costS = (i <= s) ? cs : dp[i - s] + cs;
            int costM = (i <= m) ? cm : dp[i - m] + cm;
            int costL = (i <= l) ? cl : dp[i - l] + cl;
            
            dp[i] = Math.min(costS, Math.min(costM, costL));
        }
        
        return dp[x];
    }
}
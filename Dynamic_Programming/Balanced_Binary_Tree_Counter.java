/*
 * Problem: Balanced Binary Tree Counter (GeeksforGeeks - Easy)
 * 
 * Given a height h, find the maximum number of distinct balanced binary 
 * trees of height exactly h.
 * A binary tree is balanced if, for every node, the heights of its left 
 * and right subtrees differ by at most 1. A tree with a single node has 
 * height 1. An empty tree has height 0.
 * 
 * Note: Since the answer can be very large, return it modulo 10^9 + 7.
 * 
 * Examples:
 * Input: h = 1
 * Output: 1
 * Explanation: Only one tree of height 1 exists i.e. a single node.
 * 
 * Input: h = 2
 * Output: 3
 * Explanation: 3 distinct balanced trees of height 2 exist.
 * 
 * Constraints:
 * 1 <= h <= 10^6
 * 
 * Approach:
 * Employ dynamic programming to tally combinatorial options iteratively. 
 * A balanced tree of height h requires children of heights (h-1, h-1), 
 * (h-1, h-2), or (h-2, h-1). Optimizing DP from O(N) space to O(1) space 
 * strictly requires overlapping updating parameters storing previously 
 * evaluated heights natively.
 * 
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */

public class Balanced_Binary_Tree_Counter {

    public int countBT(int h) {
        if (h == 0 || h == 1) {
            return 1;
        }
        
        long MOD = 1000000007;
        long dp0 = 1; 
        long dp1 = 1; 
        
        for (int i = 2; i <= h; i++) {
            long dp2 = (dp1 * dp1 % MOD + 2 * dp1 * dp0 % MOD) % MOD;
            
            dp0 = dp1;
            dp1 = dp2;
        }
        
        return (int) dp1;
    }

    public static void main(String[] args) {
        Balanced_Binary_Tree_Counter solution = new Balanced_Binary_Tree_Counter();

        System.out.println(solution.countBT(1)); // Expected: 1
        System.out.println(solution.countBT(2)); // Expected: 3
        System.out.println(solution.countBT(3)); // Expected: 15
        System.out.println(solution.countBT(4)); // Expected: 315
    }
}
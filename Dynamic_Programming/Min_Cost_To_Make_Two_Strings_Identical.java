/*
 * Min Cost To Make Two Strings Identical
 * Difficulty: Medium | Accuracy: 52.29% | Submissions: 37K+ | Points: 4
 * 
 * Given two strings s1 and s2, and two integers costS1 and costS2, where costS1 
 * is the cost of deleting one character from s1 and costS2 is the cost of deleting 
 * one character from s2, find the minimum cost required to make the two strings identical.
 * You can delete any number of characters from either string, but the order of the 
 * remaining characters must be preserved.
 * 
 * Examples:
 * 
 * Input: s1 = "abcd", s2 = "acdb", costS1 = 10, costS2 = 20
 * Output: 30
 * Explanation: Delete 'b' from both strings to obtain "acd". The total cost is 10 + 20 = 30.
 * 
 * Input: s1 = "ef", s2 = "gh", costS1 = 10, costS2 = 20
 * Output: 60
 * Explanation: The two strings have no common characters, so delete all characters 
 * from both strings. The total cost is (2 * 10) + (2 * 20) = 60.
 * 
 * Constraints:
 * 1 <= s1.size(), s2.size() <= 1000
 * 1 <= costS1, costS2 <= 10^5
 */

public class Min_Cost_To_Make_Two_Strings_Identical {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.findMinCost("abcd", "acdb", 10, 20)); // Expected: 30
        System.out.println("Test Case 2: " + solver.findMinCost("ef", "gh", 10, 20));     // Expected: 60
        System.out.println("Test Case 3: " + solver.findMinCost("geeks", "geeks", 15, 25)); // Expected: 0
    }
}

class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int m = s1.length();
        int n = s2.length();
        
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        int lcsLength = prev[n];
        
        int deletionsS1 = m - lcsLength;
        int deletionsS2 = n - lcsLength;
        
        return (deletionsS1 * costS1) + (deletionsS2 * costS2);
    }
}
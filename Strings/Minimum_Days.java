/*
 * Problem: Minimum Days (GeeksforGeeks - Medium)
 * 
 * Given a string s of length n containing only lowercase English letters, and 
 * a permutation array p[] of length n containing integers from 0 to n - 1.
 * 
 * On the (i + 1)th day, the character at index p[i] in the string is replaced 
 * with '?'. Find the minimum number of days required so that no two adjacent 
 * characters in s are equal, unless at least one of them is '?'.
 * 
 * Examples:
 * Input: s = "aabb", p = [2, 1, 3, 0]
 * Output: 2
 * Explanation: 
 * Day 1: s[2] -> '?', s becomes "aa?b".
 * Day 2: s[1] -> '?', s becomes "a??b". No two adjacent valid characters are equal.
 * 
 * Constraints:
 * 1 <= s.size() <= 10^5
 * 0 <= p[i] < s.size()
 * 
 * Approach:
 * Track the total count of initial adjacent duplicate pairs (violations). 
 * Simulate replacing characters day-by-day based on the permutation array p[]. 
 * When replacing a character, check if its immediate left or right neighbor 
 * was identically matching it; if so, decrement the violation count. 
 * Return the day when violations hit 0.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Minimum_Days {

    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        if (n <= 1) return 0;
        
        char[] chars = s.toCharArray();
        int violationCount = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                violationCount++;
            }
        }
        
        if (violationCount == 0) return 0;
        
        for (int i = 0; i < n; i++) {
            int idx = p[i];
            
            if (idx > 0 && chars[idx] == chars[idx - 1]) {
                violationCount--;
            }
            if (idx < n - 1 && chars[idx] == chars[idx + 1]) {
                violationCount--;
            }
            
            chars[idx] = '?';
            
            if (violationCount == 0) {
                return i + 1;
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Minimum_Days solution = new Minimum_Days();

        // Example 1
        String s1 = "aabb";
        int[] p1 = {2, 1, 3, 0};
        System.out.println(solution.getMinimumDays(s1, p1)); // Expected: 2
        
        // Example 2
        String s2 = "abca";
        int[] p2 = {3, 0, 2, 1};
        System.out.println(solution.getMinimumDays(s2, p2)); // Expected: 0
    }
}
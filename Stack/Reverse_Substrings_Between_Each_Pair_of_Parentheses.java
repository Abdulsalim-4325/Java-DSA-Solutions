/*
 * LeetCode 1190. Reverse Substrings Between Each Pair of Parentheses
 * Medium
 * 
 * You are given a string s that consists of lower case English letters and brackets.
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * Your result should not contain any brackets.
 * 
 * Example 1:
 * Input: s = "(abcd)"
 * Output: "dcba"
 * 
 * Example 2:
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * 
 * Example 3:
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 * 
 * Constraints:
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 */

public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.reverseParentheses("(abcd)")); 
        // Expected: "dcba"

        System.out.println("Test Case 2: " + solver.reverseParentheses("(u(love)i)")); 
        // Expected: "iloveu"

        System.out.println("Test Case 3: " + solver.reverseParentheses("(ed(et(oc))el)")); 
        // Expected: "leetcode"
    }
}

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        
        // Primitive stack array for maximum performance
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack[++top] = i;
            } else if (s.charAt(i) == ')') {
                int j = stack[top--];
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        int direction = 1;
        
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
            i += direction;
        }
        
        return result.toString();
    }
}
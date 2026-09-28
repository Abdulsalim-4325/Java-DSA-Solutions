/*
 * LeetCode 1614. Maximum Nesting Depth of the Parentheses
 * Easy
 * 
 * Given a valid parentheses string s, return the nesting depth of s. 
 * The nesting depth is the maximum number of nested parentheses.
 * 
 * Example 1:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 * 
 * Example 2:
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * 
 * Example 3:
 * Input: s = "()(())((()()))"
 * Output: 3
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
 * It is guaranteed that parentheses expression s is a VPS (Valid Parentheses String).
 */

public class Maximum_Nesting_Depth_of_the_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.maxDepth("(1+(2*3)+((8)/4))+1")); // Expected: 3
        System.out.println("Test Case 2: " + solver.maxDepth("(1)+((2))+(((3)))")); // Expected: 3
        System.out.println("Test Case 3: " + solver.maxDepth("()(())((()()))")); // Expected: 3
        System.out.println("Test Case 4: " + solver.maxDepth("1+(2*3)/(2-1)")); // Expected: 1
    }
}

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (c == ')') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
}
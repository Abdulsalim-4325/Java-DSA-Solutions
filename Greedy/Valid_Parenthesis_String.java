/*
 * LeetCode 678. Valid Parenthesis String
 * Medium
 * 
 * Given a string s containing only three types of characters: '(', ')' and '*', 
 * return true if s is valid.
 * 
 * The following rules define a valid string:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left 
 *    parenthesis '(' or an empty string "".
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 * 
 * Example 4:
 * Input: s = "("
 * Output: false
 * 
 * Constraints:
 * 1 <= s.length <= 100
 * s[i] is '(', ')' or '*'.
 */

public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.checkValidString("()"));      // Expected: true
        System.out.println("Test Case 2: " + solver.checkValidString("(*)"));     // Expected: true
        System.out.println("Test Case 3: " + solver.checkValidString("(*))"));    // Expected: true
        System.out.println("Test Case 4: " + solver.checkValidString("("));       // Expected: false
        System.out.println("Test Case 5: " + solver.checkValidString("((*)"));    // Expected: true
        System.out.println("Test Case 6: " + solver.checkValidString("*(()*))")); // Expected: true
    }
}

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; 
        int maxOpen = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { 
                minOpen--; 
                maxOpen++; 
            }
            
            if (maxOpen < 0) {
                return false;
            }
            
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        return minOpen == 0;
    }
}
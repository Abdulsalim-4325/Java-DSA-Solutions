/*
 * LeetCode 921. Minimum Add to Make Parentheses Valid
 * Medium
 * 
 * A parentheses string is valid if and only if:
 * - It is the empty string,
 * - It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * - It can be written as (A), where A is a valid string.
 * 
 * You are given a parentheses string s. In one move, you can insert a parenthesis 
 * at any position of the string.
 * 
 * Return the minimum number of moves required to make s valid.
 * 
 * Example 1:
 * Input: s = "())"
 * Output: 1
 * 
 * Example 2:
 * Input: s = "((("
 * Output: 3
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] is either '(' or ')'.
 */

public class Minimum_Add_to_Make_Parentheses_Valid {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.minAddToMakeValid("())"));     
        // Expected: 1 (Add one '(' at the beginning)

        System.out.println("Test Case 2: " + solver.minAddToMakeValid("((("));     
        // Expected: 3 (Add three ')' at the end)

        System.out.println("Test Case 3: " + solver.minAddToMakeValid("()"));      
        // Expected: 0 (Already valid)
        
        System.out.println("Test Case 4: " + solver.minAddToMakeValid("()))(("));  
        // Expected: 4 (Add two '(' for the middle, and two ')' for the end)
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0; 
        int minAdds = 0;   
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else {
                    minAdds++;
                }
            }
        }
        
        return minAdds + openCount;
    }
}
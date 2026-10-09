/*
 * LeetCode 1541. Minimum Insertions to Balance a Parentheses String
 * Medium
 * 
 * Given a parentheses string s containing only the characters '(' and ')'. 
 * A parentheses string is balanced if:
 * - Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * - Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * 
 * You can insert the characters '(' and ')' at any position of the string to 
 * balance it if needed. Return the minimum number of insertions needed to make s balanced.
 * 
 * Example 1:
 * Input: s = "(()))"
 * Output: 1
 * Explanation: Add one more ')' at the end.
 * 
 * Example 2:
 * Input: s = "())"
 * Output: 0
 * Explanation: The string is already balanced.
 * 
 * Example 3:
 * Input: s = "))())("
 * Output: 3
 * Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of '(' and ')' only.
 */

public class Minimum_Insertions_to_Balance_a_Parentheses_String {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.minInsertions("(()))"));     
        // Expected: 1

        System.out.println("Test Case 2: " + solver.minInsertions("())"));       
        // Expected: 0

        System.out.println("Test Case 3: " + solver.minInsertions("))())("));    
        // Expected: 3
        
        System.out.println("Test Case 4: " + solver.minInsertions("(((((("));    
        // Expected: 12
        
        System.out.println("Test Case 5: " + solver.minInsertions(")))))))"));   
        // Expected: 5
    }
}

class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int reqRight = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (reqRight % 2 != 0) {
                    insertions++; 
                    reqRight--;
                }
                reqRight += 2;
            } else {
                reqRight--;
                if (reqRight < 0) {
                    insertions++; 
                    reqRight += 2; 
                }
            }
        }
        
        return insertions + reqRight;
    }
}
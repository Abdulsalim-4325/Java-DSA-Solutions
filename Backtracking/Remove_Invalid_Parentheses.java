/*
 * LeetCode 301. Remove Invalid Parentheses
 * Hard
 * 
 * Given a string s that contains parentheses and letters, remove the minimum 
 * number of invalid parentheses to make the input string valid.
 * 
 * Return a list of unique strings that are valid with the minimum number of removals. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * 
 * Example 2:
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * 
 * Example 3:
 * Input: s = ")("
 * Output: [""]
 * 
 * Constraints:
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Remove_Invalid_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.removeInvalidParentheses("()())()")); 
        // Expected: ["(())()", "()()()"]

        System.out.println("Test Case 2: " + solver.removeInvalidParentheses("(a)())()")); 
        // Expected: ["(a())()", "(a)()()"]

        System.out.println("Test Case 3: " + solver.removeInvalidParentheses(")(")); 
        // Expected: [""]
        
        System.out.println("Test Case 4: " + solver.removeInvalidParentheses("n")); 
        // Expected: ["n"]
    }
}

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int removeLeft = 0;
        int removeRight = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                removeLeft++;
            } else if (c == ')') {
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }
        
        Set<String> validExpressions = new HashSet<>();
        dfs(s, 0, 0, 0, removeLeft, removeRight, new StringBuilder(), validExpressions);
        
        return new ArrayList<>(validExpressions);
    }
    
    private void dfs(String s, int index, int leftCount, int rightCount, 
                     int removeLeft, int removeRight, StringBuilder path, Set<String> res) {
        
        if (index == s.length()) {
            if (removeLeft == 0 && removeRight == 0) {
                res.add(path.toString());
            }
            return;
        }
        
        char c = s.charAt(index);
        int len = path.length();
        
        if (c == '(' && removeLeft > 0) {
            dfs(s, index + 1, leftCount, rightCount, removeLeft - 1, removeRight, path, res);
        } else if (c == ')' && removeRight > 0) {
            dfs(s, index + 1, leftCount, rightCount, removeLeft, removeRight - 1, path, res);
        }
        
        path.append(c);
        
        if (c == '(') {
            dfs(s, index + 1, leftCount + 1, rightCount, removeLeft, removeRight, path, res);
        } else if (c == ')') {
            if (leftCount > rightCount) {
                dfs(s, index + 1, leftCount, rightCount + 1, removeLeft, removeRight, path, res);
            }
        } else {
            dfs(s, index + 1, leftCount, rightCount, removeLeft, removeRight, path, res);
        }
        
        path.setLength(len);
    }
}
/*

Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/*/

import java.util.Stack;

public class Smallest_Subsequence_Of_Distinct_Characters {
    
    
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (seen[c - 'a']) {
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            seen[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }

    
    public static void main(String[] args) {
        Smallest_Subsequence_Of_Distinct_Characters solver = new Smallest_Subsequence_Of_Distinct_Characters();

        // Test Case 1
        String test1 = "bcabc";
        System.out.println("Input: s = \"" + test1 + "\"");
        System.out.println("Output: \"" + solver.smallestSubsequence(test1) + "\""); // Expected: "abc"
        System.out.println();

        // Test Case 2
        String test2 = "cbacdcbc";
        System.out.println("Input: s = \"" + test2 + "\"");
        System.out.println("Output: \"" + solver.smallestSubsequence(test2) + "\""); // Expected: "acdb"
    }
}

/*
 * LeetCode 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 * Medium
 * 
 * Given a VPS seq, split it into two disjoint subsequences A and B, such that 
 * A and B are VPS's (and A.length + B.length = seq.length). 
 * 
 * Now choose any such A and B such that max(depth(A), depth(B)) is the 
 * minimum possible value. Return an answer array (of length seq.length) 
 * that encodes such a choice of A and B: answer[i] = 0 if seq[i] is part of A, 
 * else answer[i] = 1.
 * 
 * Example 1:
 * Input: seq = "(()())"
 * Output: [0,1,1,1,1,0]
 * 
 * Example 2:
 * Input: seq = "()(())()"
 * Output: [0,0,0,1,1,0,1,1]
 * 
 * Constraints:
 * 1 <= seq.length <= 10000
 */

import java.util.Arrays;

public class Maximum_Nesting_Depth_of_Two_VPS {
    public static void main(String[] args) {
        Solution solver = new Solution();

        String seq1 = "(()())";
        System.out.println("Test Case 1: " + Arrays.toString(solver.maxDepthAfterSplit(seq1))); 
        // Expected: [0, 1, 1, 1, 1, 0]

        String seq2 = "()(())()";
        System.out.println("Test Case 2: " + Arrays.toString(solver.maxDepthAfterSplit(seq2))); 
        // Expected: [0, 0, 0, 1, 1, 0, 1, 1]
    }
}

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int depth = 0;
        
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                result[i] = depth++ & 1;
            } else {
                result[i] = --depth & 1;
            }
        }
        
        return result;
    }
}
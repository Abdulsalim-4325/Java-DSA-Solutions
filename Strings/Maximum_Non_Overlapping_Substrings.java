/*
 * LeetCode 1520. Maximum Number of Non-Overlapping Substrings
 * Hard
 * 
 * Given a string s of lowercase letters, you need to find the maximum number of 
 * non-empty substrings of s that meet the following conditions:
 * - The substrings do not overlap.
 * - A substring that contains a certain character c must also contain all occurrences of c.
 * 
 * Find the maximum number of substrings that meet the above conditions. If there are 
 * multiple solutions with the same number of substrings, return the one with minimum total length.
 * 
 * Example 1:
 * Input: s = "adefaddaccc"
 * Output: ["e","f","ccc"]
 * Explanation: The optimal way is to choose ["e","f","ccc"] which gives us 3 substrings.
 * 
 * Example 2:
 * Input: s = "abbaccd"
 * Output: ["d","bb","cc"]
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s contains only lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maximum_Non_Overlapping_Substrings {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.maxNumOfSubstrings("adefaddaccc")); 
        // Expected: [e, f, ccc]

        System.out.println("Test Case 2: " + solver.maxNumOfSubstrings("abbaccd")); 
        // Expected: [bb, cc, d]

        System.out.println("Test Case 3: " + solver.maxNumOfSubstrings("ababa")); 
        // Expected: [ababa]
    }
}

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        List<String> result = new ArrayList<>();
        int right = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = checkBoundary(s, i, first, last);
                
                if (newRight != -1) {
                    if (i > right) {
                        result.add("");
                    }
                    right = newRight;
                    result.set(result.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        
        return result;
    }
    
    private int checkBoundary(String s, int i, int[] first, int[] last) {
        int right = last[s.charAt(i) - 'a'];
        
        for (int j = i; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (first[c] < i) {
                return -1;
            }
            right = Math.max(right, last[c]);
        }
        
        return right;
    }
}
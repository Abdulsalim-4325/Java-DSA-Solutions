/*
 * Longest Matching in Dictionary with Removals
 * Difficulty: Medium | Accuracy: 43.54% | Submissions: 27K+ | Points: 4
 * 
 * Given a lowercase string s and a dictionary d[] containing lowercase words, 
 * find the longest word in the dictionary that can be obtained by deleting some 
 * characters from s without changing the order of the remaining characters.
 * 
 * Note: If multiple words have the same maximum length, return the lexicographically 
 * smallest one. If no valid word exists, return an empty string.
 * 
 * Examples:
 * Input: d = ["ale", "apple", "monkey", "plea"], s = "abpcplea"
 * Output: "apple" 
 * Explanation: After deleting "b", "c", "a" s became "apple" which is present in d.
 * 
 * Input: d = ["a", "b", "c"], s = "abpcplea"
 * Output: "a"
 * 
 * Constraints:
 * 1 <= |s| <= 5 * 10^5
 * 1 <= n <= 10^4
 * 1 <= m <= 100
 * s and all words in dictionary consist only of lowercase English letters.
 */

import java.util.Arrays;
import java.util.List;

public class Longest_Matching_In_Dictionary {
    public static void main(String[] args) {
        Solution solver = new Solution();

        List<String> d1 = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println("Test Case 1: " + solver.findLongestWord("abpcplea", d1)); 
        // Expected: "apple"

        List<String> d2 = Arrays.asList("a", "b", "c");
        System.out.println("Test Case 2: " + solver.findLongestWord("abpcplea", d2)); 
        // Expected: "a"
        
        List<String> d3 = Arrays.asList("apple", "apply", "ape");
        System.out.println("Test Case 3: " + solver.findLongestWord("abppcpleya", d3)); 
        // Expected: "apple"
    }
}

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String best = "";
        
        for (String word : d) {
            if (word.length() < best.length() || 
               (word.length() == best.length() && word.compareTo(best) >= 0)) {
                continue;
            }
            
            if (isSubsequence(word, s)) {
                best = word;
            }
        }
        
        return best;
    }
    
    private boolean isSubsequence(String word, String s) {
        int i = 0; 
        int j = 0; 
        
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        
        return j == word.length();
    }
}
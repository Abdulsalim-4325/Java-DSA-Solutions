/*
 * LeetCode 1807. Evaluate the Bracket Pairs of a String
 * Medium
 * 
 * You are given a string s that contains some bracket pairs, with each pair 
 * containing a non-empty key.
 * 
 * You know the values of a wide range of keys. This is represented by a 2D 
 * string array knowledge where each knowledge[i] = [keyi, valuei].
 * 
 * You are tasked to evaluate all of the bracket pairs. When you evaluate a 
 * bracket pair that contains some key keyi, you will:
 * - Replace keyi and the bracket pair with the key's corresponding valuei.
 * - If you do not know the value of the key, you will replace keyi and the 
 *   bracket pair with a question mark "?" (without the quotation marks).
 * 
 * Each key will appear at most once in your knowledge. There will not be 
 * any nested brackets in s.
 * 
 * Example 1:
 * Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * Output: "bobistwoyearsold"
 * 
 * Example 2:
 * Input: s = "hi(name)", knowledge = [["a","b"]]
 * Output: "hi?"
 * 
 * Example 3:
 * Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * Output: "yesyesyesaaa"
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * 0 <= knowledge.length <= 10^5
 * knowledge[i].length == 2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate_the_Bracket_Pairs_of_a_String {
    public static void main(String[] args) {
        Solution solver = new Solution();

        String s1 = "(name)is(age)yearsold";
        List<List<String>> knowledge1 = Arrays.asList(
            Arrays.asList("name", "bob"),
            Arrays.asList("age", "two")
        );
        System.out.println("Test Case 1: " + solver.evaluate(s1, knowledge1)); 
        // Expected: "bobistwoyearsold"

        String s2 = "hi(name)";
        List<List<String>> knowledge2 = Arrays.asList(
            Arrays.asList("a", "b")
        );
        System.out.println("Test Case 2: " + solver.evaluate(s2, knowledge2)); 
        // Expected: "hi?"

        String s3 = "(a)(a)(a)aaa";
        List<List<String>> knowledge3 = Arrays.asList(
            Arrays.asList("a", "yes")
        );
        System.out.println("Test Case 3: " + solver.evaluate(s3, knowledge3)); 
        // Expected: "yesyesyesaaa"
    }
}

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> pair : knowledge) {
            dict.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            char c = s.charAt(i);
            
            if (c == '(') {
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                
                String key = s.substring(i + 1, j);
                result.append(dict.getOrDefault(key, "?"));
                i = j + 1;
            } else {
                result.append(c);
                i++;
            }
        }
        
        return result.toString();
    }
}
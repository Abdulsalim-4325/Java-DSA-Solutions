/*
 * LeetCode 3498. Reverse Degree of a String
 * Easy
 * 
 * Given a string s, calculate its reverse degree.
 * The reverse degree is calculated as follows:
 * For each character, multiply its position in the reversed alphabet 
 * ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
 * Sum these products for all characters in the string.
 * Return the reverse degree of s.
 * 
 * Example 1:
 * Input: s = "abc"
 * Output: 148
 * Explanation: 26*1 + 25*2 + 24*3 = 148
 * 
 * Example 2:
 * Input: s = "zaza"
 * Output: 160
 * Explanation: 1*1 + 26*2 + 1*3 + 26*4 = 160
 * 
 * Constraints:
 * 1 <= s.length <= 1000
 * s contains only lowercase English letters.
 */

public class Reverse_Degree_of_a_String {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.reverseDegree("abc"));   // Expected: 148
        System.out.println("Test Case 2: " + solver.reverseDegree("zaza"));  // Expected: 160
        System.out.println("Test Case 3: " + solver.reverseDegree("a"));     // Expected: 26
    }
}

class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int index = i + 1;
            int revVal = 26 - (s.charAt(i) - 'a');
            totalDegree += revVal * index;
        }
        
        return totalDegree;
    }
}
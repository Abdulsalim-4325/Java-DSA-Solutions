/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.*/


import java.util.Arrays;

public class Longest_Common_Prefix {
    
   
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }

    
    public static void main(String[] args) {
        Longest_Common_Prefix solver = new Longest_Common_Prefix();

        // Test Case 1
        String[] test1 = {"flower", "flow", "flight"};
        System.out.println("Input: strs = " + Arrays.toString(test1));
        System.out.println("Output: \"" + solver.longestCommonPrefix(test1) + "\""); // Expected: "fl"
        System.out.println();

        // Test Case 2
        String[] test2 = {"dog", "racecar", "car"};
        System.out.println("Input: strs = " + Arrays.toString(test2));
        System.out.println("Output: \"" + solver.longestCommonPrefix(test2) + "\""); // Expected: ""
    }
}

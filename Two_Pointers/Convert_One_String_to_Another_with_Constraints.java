/*
 * Problem: Convert One String to Another with Constraints (GeeksforGeeks - Easy)
 * 
 * Given two strings s1 and s2, consisting only of the characters 'A', 'B', and '#'. 
 * Determine whether s1 can be transformed into s2 by performing the following operations on s1:
 * - 'A' can move only towards the left. 
 * - 'B' can move only towards the right.
 * - Neither 'A' nor 'B' can cross each other.
 * - '#' represents an empty position through which 'A' and 'B' can move.
 * 
 * Moving the character at index i one step to the left means swapping it with the 
 * character at index i - 1, provided i - 1 >= 0. Similarly, moving it one step to 
 * the right means swapping it with the character at index i + 1, provided i + 1 < s1.length().
 * Return true if s1 can be transformed into s2; otherwise, return false.
 * 
 * Examples:
 * Input: s1 = "#A#B#B#", s2 = "A###B#B"
 * Output: true
 * Explanation: The character 'A' in s1 can move one position towards the left to reach 
 * its position in s2, as there are no 'B' characters blocking its movement. Similarly, 
 * each 'B' can move towards the right to reach its corresponding position in s2 without 
 * crossing any other 'A' or 'B'. Therefore, s1 can be transformed into s2, so the answer is true.
 * 
 * Input: s1 = "#A#B#", s2 = "#B#A#"
 * Output: false
 * Explanation: The character 'A' in s1 is at index 1, whereas the corresponding 'A' 
 * in s2 is at index 3. Since 'A' can move only towards the left, it cannot reach a 
 * position to the right of its current position. Therefore, s1 cannot be transformed into s2.
 * 
 * Constraints:
 * 1 <= s1.size(), s2.size() <= 10^5
 * 
 * Approach:
 * Two-pointer approach. Check if the relative order of 'A' and 'B' matches by skipping '#'.
 * Then validate that 'A' only shifts to smaller or equal indices and 'B' only shifts to 
 * larger or equal indices.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Convert_One_String_to_Another_with_Constraints {

    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int n = s1.length();
        int i = 0, j = 0;
        
        while (i < n || j < n) {
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }
            while (j < n && s2.charAt(j) == '#') {
                j++;
            }
            
            if (i == n && j == n) return true;
            if (i == n || j == n) return false;
            
            if (s1.charAt(i) != s2.charAt(j)) return false;
            
            if (s1.charAt(i) == 'A' && i < j) return false;
            if (s1.charAt(i) == 'B' && i > j) return false;
            
            i++;
            j++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Convert_One_String_to_Another_with_Constraints solution = 
                new Convert_One_String_to_Another_with_Constraints();

        System.out.println(solution.isItPossible("#A#B#B#", "A###B#B")); // Expected: true
        System.out.println(solution.isItPossible("#A#B#", "#B#A#"));     // Expected: false
    }
}
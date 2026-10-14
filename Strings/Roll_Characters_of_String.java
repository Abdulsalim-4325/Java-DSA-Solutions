/*
 * Problem: Roll Characters of String (GeeksforGeeks - Medium)
 * 
 * Given a string s consisting of lowercase English letters and an integer array roll[], 
 * perform a sequence of roll operations on the string.
 * For each value roll[i], increment each of the first roll[i] characters of the string 
 * by 1 in the English alphabet. After 'z', the character wraps around to 'a'.
 * Return the final string after applying all roll operations.
 * Note: A roll operation affects the current state of the string, including all previous modifications.
 * 
 * Examples:
 * Input: s = "bca", roll[] = [1, 2, 3]
 * Output: eeb
 * Explanation: Initially, s = "bca" 
 * roll[0] = 1: Roll the first 1 character. "bca" -> "cca" 
 * roll[1] = 2: Roll the first 2 characters. "cca"-> "dda" 
 * roll[2] = 3: Roll the first 3 characters. "dda" -> "eeb" 
 * After applying all the roll operations, the final string is "eeb".
 * 
 * Input: s = "zcza", roll[] = [1, 1, 3, 4]
 * Output: debb
 * Explanation: Initially, s = "zcza". 
 * Roll first 1 character: "zcza" -> "acza" 
 * Roll first 1 character again: "acza" -> "bcza" 
 * Roll first 3 characters: "bcza" -> "cdaa" 
 * Roll first 4 characters: "cdaa" -> "debb" 
 * Therefore, the final string is "debb".
 * 
 * Constraints:
 * 1 <= s.size(), roll.size() <= 10^5
 * 1 <= roll[i] <= s.size()
 * s consists only of lowercase English alphabets
 *
 * Approach:
 * Use a suffix sum array to count how many times each character should be rolled.
 * Time Complexity: O(N + K)
 * Space Complexity: O(N)
 */

public class Roll_Characters_of_String {

    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] rollCounts = new int[n];
        
        for (int r : roll) {
            rollCounts[r - 1]++;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            rollCounts[i] += rollCounts[i + 1];
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = rollCounts[i] % 26;
            chars[i] = (char) (((chars[i] - 'a' + shift) % 26) + 'a');
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        Roll_Characters_of_String solution = new Roll_Characters_of_String();

        String s1 = "bca";
        int[] roll1 = {1, 2, 3};
        System.out.println(solution.findRollOut(s1, roll1)); // Expected: eeb

        String s2 = "zcza";
        int[] roll2 = {1, 1, 3, 4};
        System.out.println(solution.findRollOut(s2, roll2)); // Expected: debb
    }
}
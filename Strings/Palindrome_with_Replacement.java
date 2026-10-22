/*
 * Problem: Palindrome with Replacement (GeeksforGeeks - Medium)
 * 
 * Given a string s consisting of lowercase English letters and the character '?'. 
 * - Replace every '?' with a lowercase English letter such that the resulting string is a palindrome.
 * - If it is possible to form a palindrome, return the minimum possible sum of the absolute 
 *   ASCII differences between every pair of adjacent characters.
 * - If it is not possible, return -1.
 * 
 * Examples:
 * Input: s = "a???c??c????"
 * Output: 4
 * Explanation: One optimal palindrome is "abbbccccbbba". The sum of absolute ASCII differences is 4.
 * 
 * Input: s = "a???c??c???c"
 * Output: -1
 * Explanation: The first and last characters ('a' and 'c') conflict.
 * 
 * Constraints:
 * 1 <= s.size() <= 10^5
 * 
 * Approach:
 * Fold the array and validate symmetry to reject conflicts. The optimal sum of adjacent 
 * differences between interpolated blocks is simply the absolute difference of the boundaries.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Palindrome_with_Replacement {

    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;
        
        int sum = 0;
        char prev = '?';
        
        for (int i = 0; i < m; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);
            char current = '?';
            
            if (left != '?' && right != '?') {
                if (left != right) {
                    return -1;
                }
                current = left;
            } else if (left != '?') {
                current = left;
            } else if (right != '?') {
                current = right;
            }
            
            if (current != '?') {
                if (prev != '?') {
                    sum += Math.abs(current - prev);
                }
                prev = current;
            }
        }
        
        return sum * 2;
    }

    public static void main(String[] args) {
        Palindrome_with_Replacement solution = new Palindrome_with_Replacement();

        System.out.println(solution.minimumSum("a???c??c????")); // Expected: 4
        System.out.println(solution.minimumSum("a???c??c???c")); // Expected: -1
    }
}
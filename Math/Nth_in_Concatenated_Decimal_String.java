/*
 * Problem: Nth in Concatenated Decimal String (GeeksforGeeks - Medium)
 * 
 * Consider a string s formed by concatenating the decimal representations of all 
 * positive integers in order:
 * s = "12345678910111213141516171819202122232425262728293031..."
 * Given an integer n, find the nth character (1-based indexing) in the string s.
 * 
 * Examples:
 * Input: n = 10
 * Output: '1'
 * Explanation: The 10th character in "12345678910.." is '1' (from the number 10).
 * 
 * Input: n = 11
 * Output: '0'
 * Explanation: The 11th character in "12345678910.." is '0' (from the number 10).
 * 
 * Constraints:
 * 1 <= n <= 10^9
 * 
 * Approach:
 * Group numbers mathematically by their lengths (1-digit, 2-digit, etc.). Iteratively 
 * subtract block digit weights until the precise magnitude boundary containing the 
 * target number is located. Compute the exact integer and isolate the specific digit index.
 * 
 * Time Complexity: O(log_10 N)
 * Space Complexity: O(log_10 N)
 */

public class Nth_in_Concatenated_Decimal_String {

    public char nthCharacter(int n) {
        long nLong = n;
        long len = 1;     
        long count = 9;   
        long start = 1;   

        while (nLong > len * count) {
            nLong -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        long targetNumber = start + (nLong - 1) / len;
        int digitIndex = (int)((nLong - 1) % len);

        return String.valueOf(targetNumber).charAt(digitIndex);
    }

    public static void main(String[] args) {
        Nth_in_Concatenated_Decimal_String solution = new Nth_in_Concatenated_Decimal_String();

        System.out.println(solution.nthCharacter(10)); // Expected: '1'
        System.out.println(solution.nthCharacter(11)); // Expected: '0'
        System.out.println(solution.nthCharacter(3));  // Expected: '3'
    }
}
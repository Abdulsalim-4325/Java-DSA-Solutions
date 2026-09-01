/*
Problem: Count Palindromic Strings with Constraints

Given n and k, count palindromic strings of length at most n using
the first k lowercase English letters, where no character appears
more than twice.

Approach:
For a palindrome of length len, only its first ceil(len / 2)
characters need to be selected.

All selected characters must be distinct:
- A non-middle character appears twice due to palindrome mirroring.
- If the middle character matched a paired character, it would appear
  three times, which is not allowed.

Thus, valid palindromes of length len = P(k, ceil(len / 2)).

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Count_Palindromic_Strings_with_Constraints {

    private static final long MOD = 1_000_000_007L;

    public static int palindromicStrings(int n, int k) {
        long answer = 0;
        long ways = 1; // Represents P(k, 0)

        for (int length = 1; length <= n; length++) {
            // A new character is needed only for odd palindrome lengths.
            if (length % 2 == 1) {
                int usedCharacters = (length - 1) / 2;
                ways = (ways * (k - usedCharacters)) % MOD;
            }

            answer = (answer + ways) % MOD;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(palindromicStrings(3, 2));
        // Expected Output: 6

        System.out.println(palindromicStrings(4, 3));
        // Expected Output: 18
    }
}
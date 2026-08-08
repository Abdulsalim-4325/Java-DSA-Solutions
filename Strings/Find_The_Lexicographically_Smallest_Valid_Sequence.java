
/*
3302. Find the Lexicographically Smallest Valid Sequence

You are given two strings word1 and word2.

A string x is called almost equal to y if you can change at most one
character in x to make it identical to y.

A sequence of indices seq is called valid if:

1. The indices are sorted in ascending order.
2. Concatenating the characters at these indices in word1 in the same
   order results in a string that is almost equal to word2.

Return an array of size word2.length() representing the lexicographically
smallest valid sequence of indices.

If no such sequence of indices exists, return an empty array.

Note that the answer must represent the lexicographically smallest array,
not the corresponding string formed by those indices.

Example 1:

Input:
word1 = "vbcca"
word2 = "abc"

Output:
[0, 1, 2]

Explanation:
The lexicographically smallest valid sequence is [0, 1, 2].
Change word1[0] from 'v' to 'a'.
word1[1] is 'b'.
word1[2] is 'c'.

Example 2:

Input:
word1 = "bacdc"
word2 = "abc"

Output:
[1, 2, 4]

Explanation:
word1[1] is 'a'.
Change word1[2] from 'c' to 'b'.
word1[4] is 'c'.

Example 3:

Input:
word1 = "aaaaaa"
word2 = "aaabc"

Output:
[]

Explanation:
There is no valid sequence of indices.

Example 4:

Input:
word1 = "abc"
word2 = "ab"

Output:
[0, 1]

Constraints:

1 <= word2.length < word1.length <= 3 * 10^5
word1 and word2 consist only of lowercase English letters.
*/

import java.util.Arrays;

public class Find_The_Lexicographically_Smallest_Valid_Sequence {

    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] lastMatch = new int[m + 1];
        lastMatch[m] = n;

        int w2Idx = m - 1;

        for (int i = n - 1; i >= 0 && w2Idx >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(w2Idx)) {
                lastMatch[w2Idx] = i;
                w2Idx--;
            }
        }

        while (w2Idx >= 0) {
            lastMatch[w2Idx] = -1;
            w2Idx--;
        }

        int[] result = new int[m];
        int j = 0;
        boolean modified = false;

        for (int i = 0; i < m; i++) {
            boolean found = false;

            while (j < n) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    result[i] = j;
                    j++;
                    found = true;
                    break;
                } else if (!modified && j < lastMatch[i + 1]) {
                    result[i] = j;
                    j++;
                    modified = true;
                    found = true;
                    break;
                }

                j++;
            }

            if (!found) {
                return new int[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Find_The_Lexicographically_Smallest_Valid_Sequence solver =
                new Find_The_Lexicographically_Smallest_Valid_Sequence();

        String word1_1 = "vbcca";
        String word2_1 = "abc";
        System.out.println("Test 1 Result: "
                + Arrays.toString(solver.validSequence(word1_1, word2_1)));

        String word1_2 = "bacdc";
        String word2_2 = "abc";
        System.out.println("Test 2 Result: "
                + Arrays.toString(solver.validSequence(word1_2, word2_2)));

        String word1_3 = "aaaaaa";
        String word2_3 = "aaabc";
        System.out.println("Test 3 Result: "
                + Arrays.toString(solver.validSequence(word1_3, word2_3)));

        String word1_4 = "abc";
        String word2_4 = "ab";
        System.out.println("Test 4 Result: "
                + Arrays.toString(solver.validSequence(word1_4, word2_4)));
    }
}


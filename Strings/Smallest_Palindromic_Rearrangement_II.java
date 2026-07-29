/*
3518. Smallest Palindromic Rearrangement II

You are given a palindromic string s and an integer k.

Return the k-th lexicographically smallest palindromic permutation
of s.

If there are fewer than k distinct palindromic permutations,
return an empty string.

Different rearrangements that produce the same palindrome are
counted only once.

Examples:

Input:
s = "abba"
k = 2

Output:
"baab"

Input:
s = "aa"
k = 2

Output:
""

Input:
s = "bacab"
k = 1

Output:
"abcba"

Constraints:

1 <= s.length <= 10^4
s contains only lowercase English letters.
s is guaranteed to be palindromic.
1 <= k <= 10^6
*/

import java.math.BigInteger;

public class Smallest_Palindromic_Rearrangement_II {

    public String smallestPalindrome(String s, int k) {

        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder middle = new StringBuilder();

        
        for (int i = 0; i < 26; i++) {

            if (frequency[i] % 2 == 1) {
                middle.append((char) ('a' + i));
            }

            frequency[i] /= 2;
        }

        int halfLength = s.length() / 2;

     
        BigInteger totalPermutations = factorial(halfLength);

        for (int count : frequency) {
            totalPermutations =
                    totalPermutations.divide(factorial(count));
        }

        BigInteger remainingK = BigInteger.valueOf(k);

        StringBuilder firstHalf = new StringBuilder();

        int remainingLength = halfLength;

       
        while (remainingLength > 0) {

            boolean characterSelected = false;

            for (int i = 0; i < 26; i++) {

                if (frequency[i] == 0) {
                    continue;
                }

             
                BigInteger possiblePermutations =
                        totalPermutations
                                .multiply(
                                        BigInteger.valueOf(frequency[i])
                                )
                                .divide(
                                        BigInteger.valueOf(remainingLength)
                                );

                if (remainingK.compareTo(possiblePermutations) > 0) {

                 
                    remainingK =
                            remainingK.subtract(possiblePermutations);

                } else {

                    
                    firstHalf.append((char) ('a' + i));

                    frequency[i]--;

                    totalPermutations = possiblePermutations;

                    remainingLength--;

                    characterSelected = true;

                    break;
                }
            }

            
            if (!characterSelected) {
                return "";
            }
        }

        
        StringBuilder answer = new StringBuilder();

        answer.append(firstHalf);
        answer.append(middle);
        answer.append(firstHalf.reverse());

        return answer.toString();
    }

    private BigInteger factorial(int n) {

        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) {

        Smallest_Palindromic_Rearrangement_II solver =
                new Smallest_Palindromic_Rearrangement_II();

        // Test Case 1
        String s1 = "abba";
        int k1 = 2;

        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println(
                "Output: \"" + solver.smallestPalindrome(s1, k1) + "\""
        );
        // Expected: "baab"

        System.out.println();

        // Test Case 2
        String s2 = "aa";
        int k2 = 2;

        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println(
                "Output: \"" + solver.smallestPalindrome(s2, k2) + "\""
        );
        // Expected: ""

        System.out.println();

        // Test Case 3
        String s3 = "bacab";
        int k3 = 1;

        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println(
                "Output: \"" + solver.smallestPalindrome(s3, k3) + "\""
        );
        // Expected: "abcba"

        System.out.println();

        // Test Case 4
        String s4 = "aabb";
        int k4 = 1;

        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        System.out.println(
                "Output: \"" + solver.smallestPalindrome(s4, k4) + "\""
        );
        // Expected: "abba"
    }
}
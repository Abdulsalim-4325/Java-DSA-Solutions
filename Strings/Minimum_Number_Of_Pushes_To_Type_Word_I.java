/*
3014. Minimum Number of Pushes to Type Word I

You are given a string word containing distinct lowercase
English letters.

The keys numbered 2 to 9 can be remapped to collections
of lowercase letters.

A letter placed in the first position on a key requires:
1 push

A letter placed in the second position on a key requires:
2 pushes

A letter placed in the third position on a key requires:
3 pushes

Return the minimum number of key pushes required to type
the given word.

Examples:

Input:
word = "abcde"

Output:
5

Explanation:
All 5 letters can be placed in the first position
of different keys.

Input:
word = "xycdefghij"

Output:
12

Explanation:
The first 8 letters require 1 push each.
The remaining 2 letters require 2 pushes each.

Total:
8 × 1 + 2 × 2 = 12
*/

public class Minimum_Number_Of_Pushes_To_Type_Word_I {

    public int minimumPushes(String word) {

        int length = word.length();

        /*
         * There are 8 available keys:
         * 2, 3, 4, 5, 6, 7, 8, and 9.
         */
        int fullGroups = length / 8;

        /*
         * Letters remaining after assigning complete groups
         * of 8 letters.
         */
        int remainingLetters = length % 8;

        /*
         * Each complete group of 8 letters has the same
         * number of pushes.
         *
         * Group 1:
         * 8 × 1 pushes
         *
         * Group 2:
         * 8 × 2 pushes
         *
         * Group 3:
         * 8 × 3 pushes
         *
         * Sum:
         * 8 × (1 + 2 + ... + fullGroups)
         */
        int pushesForFullGroups =
                fullGroups * 8 * (fullGroups + 1) / 2;

        /*
         * Remaining letters belong to the next group.
         */
        int pushesForRemainingLetters =
                remainingLetters * (fullGroups + 1);

        return pushesForFullGroups
                + pushesForRemainingLetters;
    }

    public static void main(String[] args) {

        Minimum_Number_Of_Pushes_To_Type_Word_I solver =
                new Minimum_Number_Of_Pushes_To_Type_Word_I();

        // Test Case 1
        String word1 = "abcde";

        System.out.println(
                "Input: word = \"" + word1 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word1)
        );
        // Expected: 5

        System.out.println();

        // Test Case 2
        String word2 = "xycdefghij";

        System.out.println(
                "Input: word = \"" + word2 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word2)
        );
        // Expected: 12

        System.out.println();

        // Test Case 3
        String word3 = "abcdefgh";

        System.out.println(
                "Input: word = \"" + word3 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word3)
        );
        // Expected: 8

        System.out.println();

        // Test Case 4
        String word4 = "abcdefghijklmnop";

        System.out.println(
                "Input: word = \"" + word4 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word4)
        );
        // Expected: 24
    }
}


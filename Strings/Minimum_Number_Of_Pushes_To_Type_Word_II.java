
/*
3016. Minimum Number of Pushes to Type Word II

You are given a string word containing lowercase English letters.

The letters can be remapped to the telephone keys numbered
2 through 9.

Each letter is assigned to exactly one key.

The number of pushes required depends on the letter's position
on its assigned key:

First position  -> 1 push
Second position -> 2 pushes
Third position  -> 3 pushes
Fourth position -> 4 pushes

Return the minimum number of pushes required to type the word.

Examples:

Input:
word = "abcde"

Output:
5

Input:
word = "xyzxyzxyzxyz"

Output:
12

Input:
word = "aabbccddeeffgghhiiiiii"

Output:
24
*/

import java.util.Arrays;

public class Minimum_Number_Of_Pushes_To_Type_Word_II {

    public int minimumPushes(String word) {

        int[] frequency = new int[26];

        // Count how many times every character appears.
        for (char ch : word.toCharArray()) {
            frequency[ch - 'a']++;
        }

        /*
         * Sort frequencies in ascending order.
         *
         * The most frequent characters will be processed
         * from the end of the array.
         */
        Arrays.sort(frequency);

        int minimumPushes = 0;

        /*
         * position represents the placement order of
         * distinct characters.
         */
        int position = 0;

        /*
         * Assign the most frequent characters to the
         * cheapest available keypad positions.
         */
        for (int i = 25; i >= 0; i--) {

            // No more characters are present.
            if (frequency[i] == 0) {
                break;
            }

            /*
             * There are 8 keys.
             *
             * Positions 0 to 7   -> 1 push
             * Positions 8 to 15  -> 2 pushes
             * Positions 16 to 23 -> 3 pushes
             * Positions 24 to 25 -> 4 pushes
             */
            int pushesRequired = (position / 8) + 1;

            minimumPushes +=
                    frequency[i] * pushesRequired;

            position++;
        }

        return minimumPushes;
    }

    public static void main(String[] args) {

        Minimum_Number_Of_Pushes_To_Type_Word_II solver =
                new Minimum_Number_Of_Pushes_To_Type_Word_II();

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
        String word2 = "xyzxyzxyzxyz";

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
        String word3 = "aabbccddeeffgghhiiiiii";

        System.out.println(
                "Input: word = \"" + word3 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word3)
        );
        // Expected: 24

        System.out.println();

        // Test Case 4
        String word4 = "aaaaaaaaaa";

        System.out.println(
                "Input: word = \"" + word4 + "\""
        );

        System.out.println(
                "Minimum pushes: "
                        + solver.minimumPushes(word4)
        );
        // Expected: 10
    }
}



/*
877. Stone Game

Alice and Bob take turns selecting an entire pile of stones
from either the beginning or the end of a row.

Alice starts first.

The number of piles is even, and the total number of stones
is odd.

Return true if Alice can win when both players play optimally.

Examples:

Input:
piles = [5, 3, 4, 5]

Output:
true


Input:
piles = [3, 7, 2, 3]

Output:
true
*/

public class Stone_Game {

    public boolean stoneGame(int[] piles) {

        /*
         * Alice always wins under the constraints.
         *
         * There are an even number of piles.
         *
         * Alice can choose to collect either:
         *
         * 1. All piles at even indices
         * OR
         * 2. All piles at odd indices
         *
         * She chooses the group with the larger total.
         *
         * Since the total number of stones is odd,
         * the two groups cannot have equal sums.
         *
         * Therefore, Alice can always guarantee a win.
         */
        return true;
    }

    public static void main(String[] args) {

        Stone_Game solver = new Stone_Game();

        // Test Case 1
        int[] piles1 = {5, 3, 4, 5};

        System.out.println(
                "Input: [5, 3, 4, 5]"
        );

        System.out.println(
                "Does Alice win? "
                        + solver.stoneGame(piles1)
        );
        // Expected: true

        System.out.println();

        // Test Case 2
        int[] piles2 = {3, 7, 2, 3};

        System.out.println(
                "Input: [3, 7, 2, 3]"
        );

        System.out.println(
                "Does Alice win? "
                        + solver.stoneGame(piles2)
        );
        // Expected: true
    }
}


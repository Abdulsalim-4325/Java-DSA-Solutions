
/*
1510. Stone Game IV

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that
player makes a move consisting of removing any non-zero square number
of stones from the pile.

If a player cannot make a move, that player loses the game.

Given a positive integer n, return true if and only if Alice wins the
game, otherwise return false, assuming both players play optimally.

Example 1:

Input:
n = 1

Output:
true

Explanation:
Alice can remove 1 stone and win because Bob has no remaining moves.

Example 2:

Input:
n = 2

Output:
false

Explanation:
Alice can only remove 1 stone. Bob then removes the remaining stone
and wins.

Example 3:

Input:
n = 4

Output:
true

Explanation:
Alice can remove 4 stones in one move and win immediately.

Constraints:

1 <= n <= 10^5
*/

public class Stone_Game_IV {

    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Stone_Game_IV solver = new Stone_Game_IV();

        int n1 = 1;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solver.winnerSquareGame(n1));
        System.out.println("Expected: true");
        System.out.println();

        int n2 = 2;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solver.winnerSquareGame(n2));
        System.out.println("Expected: false");
        System.out.println();

        int n3 = 4;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + solver.winnerSquareGame(n3));
        System.out.println("Expected: true");
    }
}


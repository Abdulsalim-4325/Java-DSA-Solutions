/*
2029. Stone Game IX

Alice and Bob continue their games with stones. There is a row of n stones,
and each stone has an associated value.

You are given an integer array stones, where stones[i] is the value of the
ith stone.

Alice and Bob take turns, with Alice starting first.

On each turn, the player may remove any stone from stones.

The player who removes a stone loses if the sum of the values of all removed
stones is divisible by 3.

Bob will win automatically if there are no remaining stones, even if it is
Alice's turn.

Assuming both players play optimally, return true if Alice wins and false
if Bob wins.

Example 1:

Input:
stones = [2, 1]

Output:
true

Explanation:
Alice can remove either stone.
Bob removes the remaining stone.
The total sum is 3, which is divisible by 3.
Therefore Bob loses and Alice wins.

Example 2:

Input:
stones = [2]

Output:
false

Explanation:
Alice removes the only stone.
The sum is 2, which is not divisible by 3.
There are no remaining stones, so Bob wins.

Example 3:

Input:
stones = [5, 1, 2, 4, 3]

Output:
false

Explanation:
Bob can play optimally and force Alice to remove a stone when the
running sum becomes divisible by 3.

Constraints:

1 <= stones.length <= 10^5
1 <= stones[i] <= 10^4
*/

import java.util.*;

public class Stone_Game_IX {

    public static boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        System.out.println(stoneGameIX(stones));

        sc.close();
    }
}
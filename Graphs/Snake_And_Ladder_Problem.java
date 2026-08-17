/*
Snake and Ladder Problem

Given an integer n such that there is an n x n Snakes and Ladders board
with cells numbered from 1 to n*n, find the minimum number of dice throws
required to reach cell n*n starting from cell 1.

Given two arrays of even lengths:

lad[], where each pair (lad[2*i], lad[2*i + 1]) represents the start
and end of a ladder.

sn[], where each pair (sn[2*i], sn[2*i + 1]) represents the start
and end of a snake.

If you land on the start cell of a snake or ladder, you must immediately
move to its corresponding end cell.

You have complete control over the outcome of each dice throw. In a
single move, you can move forward by any number of cells from 1 to 6.

If it is impossible to reach cell n*n, return -1.

Example 1:

Input:
n = 6
lad[] = [3, 22, 5, 8, 11, 35, 20, 32]
sn[] = [17, 4, 19, 7, 34, 1, 21, 9]

Output:
3

Explanation:
One optimal path is:

Throw 4 to move from 1 to 5, then take the ladder to 8.
Throw 3 to move from 8 to 11, then take the ladder to 35.
Throw 1 to move from 35 to 36.

Example 2:

Input:
n = 3
lad[] = [2, 8]
sn[] = [7, 3]

Output:
2

Explanation:
Throw 1 to move from 1 to 2, then take the ladder to 8.
Throw 1 to move from 8 to 9.

Constraints:

1 <= n <= 10^3
1 <= lad.size(), sn.size(), lad[i], sn[i] <= n^2
*/

import java.util.*;

public class Snake_And_Ladder_Problem {

    public static int minThrows(int n, int[] lad, int[] sn) {
        int total = n * n;

        int[] jump = new int[total + 1];

        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[total + 1];

        int[] queue = new int[total + 1];
        int[] distance = new int[total + 1];

        int front = 0;
        int rear = 0;

        queue[rear++] = 1;
        visited[1] = true;

        while (front < rear) {
            int current = queue[front++];

            if (current == total) {
                return distance[current];
            }

            for (int dice = 1; dice <= 6 && current + dice <= total; dice++) {
                int next = current + dice;

                if (jump[next] != 0) {
                    next = jump[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue[rear++] = next;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ladSize = sc.nextInt();
        int[] lad = new int[ladSize];

        for (int i = 0; i < ladSize; i++) {
            lad[i] = sc.nextInt();
        }

        int snSize = sc.nextInt();
        int[] sn = new int[snSize];

        for (int i = 0; i < snSize; i++) {
            sn[i] = sc.nextInt();
        }

        System.out.println(minThrows(n, lad, sn));

        sc.close();
    }
}
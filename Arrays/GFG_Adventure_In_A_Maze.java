/*Adventure in a Maze

Difficulty: **Hard**Accuracy: \*\*39.96%\*\*Submissions: \*\*19K+\*\*Points: **8**Average Time: **30m**

Given a maze represented as an **n x n** grid, **grid[][]**, using 0-based indexing. Each cell contains one of the values 1, 2, or 3, which determines the direction(s) you are allowed to move from that cell:

- 1 - you may move Right only.
- 2 - you may move Down only.
- 3 - you may move Right or Down (both directions are available).

You start at the top-left cell (0, 0) (the Entry) and must reach the bottom-right cell (n-1, n-1) (the Exit), following the movement rule of each cell you pass through. You are never allowed to move outside the boundaries of the grid.

The Adventure of a path is the sum of the values of all cells visited along that path (including both the entry and exit cells).

Find the total number of distinct valid paths from Entry to Exit, and among all such paths, the maximum possible Adventure. Return the answer as [totalPaths, maxAdventure].

**Note:** Return totalPaths **modulo** 109 + 7, maxAdventure needs no modulo, as it stays small regardless of grid size.

**Examples:**

```
Input: grid[][] = [[3, 2], [1, 3]]
Output: [2, 8]
Explanation:
There are 2 valid paths from [0, 0] to [1, 1]:
Path 1: [0, 0] -> [0, 1] -> [1, 1], values 3 + 2 + 3 = 8
Path 2: [0,0] -> [1, 0] -> [1, 1], values 3 + 1 + 3 = 7
The maximum Adventure among these is 8, so the output is [2, 8].
```

```
Input: grid[][] = [[1, 1, 3, 2, 1], [3, 2, 2, 1, 2], [1, 3, 3, 1, 3], [1, 2, 3, 1, 2], [1, 1, 1, 3, 1]]
Output: [4, 18]
Explanation: There are 4 valid paths from Entry to Exit, with total Adventures 
18, 17, 17, and 16 respectively. The maximum among these is 18, so the output is [4, 18].

```

**Constraints:**
1 ≤ n ≤ 100*/


import java.util.*;

public class GFG_Adventure_In_A_Maze {

    private static final long MOD = 1_000_000_007L;

    public static ArrayList<Integer> findWays(int[][] grid) {

        int n = grid.length;

        long[][] ways = new long[n][n];
        int[][] maxAdventure = new int[n][n];

        // Starting cell.
        ways[0][0] = 1;
        maxAdventure[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                // Starting cell is already initialized.
                if (i == 0 && j == 0) {
                    continue;
                }

                long pathCount = 0;
                int bestAdventure = -1;

                /*
                 * Come from the cell above.
                 *
                 * The above cell must allow Down movement:
                 * 2 = Down
                 * 3 = Right or Down
                 */
                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)) {

                    pathCount =
                        (pathCount + ways[i - 1][j]) % MOD;

                    if (ways[i - 1][j] > 0) {
                        bestAdventure = Math.max(
                            bestAdventure,
                            maxAdventure[i - 1][j]
                        );
                    }
                }

                /*
                 * Come from the cell on the left.
                 *
                 * The left cell must allow Right movement:
                 * 1 = Right
                 * 3 = Right or Down
                 */
                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)) {

                    pathCount =
                        (pathCount + ways[i][j - 1]) % MOD;

                    if (ways[i][j - 1] > 0) {
                        bestAdventure = Math.max(
                            bestAdventure,
                            maxAdventure[i][j - 1]
                        );
                    }
                }

                ways[i][j] = pathCount;

                if (bestAdventure != -1) {
                    maxAdventure[i][j] =
                        bestAdventure + grid[i][j];
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        result.add((int) ways[n - 1][n - 1]);
        result.add(maxAdventure[n - 1][n - 1]);

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {3, 2},
            {1, 3}
        };

        ArrayList<Integer> result = findWays(grid);

        System.out.println(result);
    }
}
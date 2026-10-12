
/*
 * Problem: Minimum Squares with Full Cuts (GFG)
 *
 * Given an n x m rectangle, find the minimum number
 * of squares required to divide the entire rectangle
 * using only full horizontal or vertical cuts.
 *
 * Approach:
 * Greedily count the largest possible squares using
 * integer division, then continue with the remainder.
 * This follows the Euclidean algorithm.
 *
 * Time Complexity: O(log(min(n, m)))
 * Space Complexity: O(1)
 */

public class Minimum_Squares_with_Full_Cuts {

    public int minSquares(int n, int m) {
        int count = 0;

        while (n > 0 && m > 0) {
            if (n < m) {
                int temp = n;
                n = m;
                m = temp;
            }

            count += n / m;
            n %= m;
        }

        return count;
    }

    public static void main(String[] args) {
        Minimum_Squares_with_Full_Cuts solution =
                new Minimum_Squares_with_Full_Cuts();

        System.out.println(solution.minSquares(4, 5));   // 5
        System.out.println(solution.minSquares(2, 4));   // 2
        System.out.println(solution.minSquares(11, 13)); // 8
        System.out.println(solution.minSquares(5, 5));   // 1
        System.out.println(solution.minSquares(1, 7));   // 7
    }
}

/*
Count Arrays With Divisible Adjacent Elements

Given two positive integers n and m, count the number of
arrays of size n such that:

1. Every element is in the range [1, m].
2. For every pair of adjacent elements:

   A[i] divides A[i + 1]

   OR

   A[i + 1] divides A[i].

Examples:

Input:
n = 3
m = 3

Output:
17


Input:
n = 1
m = 10

Output:
10


Constraints:

1 <= n <= 11
1 <= m <= 11
*/

public class Count_Arrays_With_Divisible_Adjacent_Elements {

    public int count(int n, int m) {

        /*
         * dp[length][lastValue] represents the number of
         * valid arrays having:
         *
         * - Size = length
         * - Last element = lastValue
         */
        int[][] dp = new int[n + 1][m + 1];

        /*
         * Base case:
         *
         * Every single-element array is valid because
         * there are no adjacent elements to check.
         */
        for (int value = 1; value <= m; value++) {
            dp[1][value] = 1;
        }

        /*
         * Build valid arrays of length 2 through n.
         */
        for (int length = 2; length <= n; length++) {

            /*
             * Choose the value at the current position.
             */
            for (int current = 1;
                 current <= m;
                 current++) {

                /*
                 * Try every possible value that could
                 * appear immediately before "current".
                 */
                for (int previous = 1;
                     previous <= m;
                     previous++) {

                    /*
                     * The adjacent values are valid if:
                     *
                     * previous divides current
                     *
                     * OR
                     *
                     * current divides previous
                     */
                    if (current % previous == 0
                            || previous % current == 0) {

                        /*
                         * Append "current" to every valid
                         * array of length - 1 ending with
                         * "previous".
                         */
                        dp[length][current] +=
                                dp[length - 1][previous];
                    }
                }
            }
        }

        int totalArrays = 0;

        /*
         * A valid array can end with any value from
         * 1 through m.
         */
        for (int value = 1; value <= m; value++) {
            totalArrays += dp[n][value];
        }

        return totalArrays;
    }

    public static void main(String[] args) {

        Count_Arrays_With_Divisible_Adjacent_Elements solver =
                new Count_Arrays_With_Divisible_Adjacent_Elements();

        // Test Case 1
        int n1 = 3;
        int m1 = 3;

        System.out.println(
                "Input: n = " + n1
                        + ", m = " + m1
        );

        System.out.println(
                "Number of valid arrays: "
                        + solver.count(n1, m1)
        );
        // Expected: 17

        System.out.println();

        // Test Case 2
        int n2 = 1;
        int m2 = 10;

        System.out.println(
                "Input: n = " + n2
                        + ", m = " + m2
        );

        System.out.println(
                "Number of valid arrays: "
                        + solver.count(n2, m2)
        );
        // Expected: 10

        System.out.println();

        // Test Case 3
        int n3 = 2;
        int m3 = 2;

        System.out.println(
                "Input: n = " + n3
                        + ", m = " + m3
        );

        System.out.println(
                "Number of valid arrays: "
                        + solver.count(n3, m3)
        );
        // Expected: 4
    }
}


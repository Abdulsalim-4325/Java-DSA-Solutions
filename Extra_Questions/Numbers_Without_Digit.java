/*
Numbers Without d as Digit

Given a number n, count the numbers from 1 to n that don't contain digit d
in their decimal representation.

Example 1:

Input:
n = 25
d = 3

Output:
22

Explanation:
From 1 to 25, the numbers 3, 13, and 23 contain the digit 3.
Therefore, the answer is 25 - 3 = 22.

Example 2:

Input:
n = 5
d = 3

Output:
4

Explanation:
From 1 to 5, only 3 contains the digit 3.
Therefore, the answer is 4.

Constraints:

0 <= n <= 10^9
0 <= d <= 9
*/

import java.util.*;

public class Numbers_Without_Digit {

    public static int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        long[][][] dp = new long[len + 1][2][2];

        dp[0][1][0] = 1;

        for (int pos = 0; pos < len; pos++) {
            int current = digits[pos] - '0';

            for (int tight = 0; tight <= 1; tight++) {
                for (int started = 0; started <= 1; started++) {

                    long ways = dp[pos][tight][started];

                    if (ways == 0) {
                        continue;
                    }

                    int limit = (tight == 1) ? current : 9;

                    for (int digit = 0; digit <= limit; digit++) {

                        int newTight =
                            (tight == 1 && digit == current) ? 1 : 0;

                        if (started == 0 && digit == 0) {
                            dp[pos + 1][newTight][0] += ways;
                        } else {
                            if (digit == d) {
                                continue;
                            }

                            dp[pos + 1][newTight][1] += ways;
                        }
                    }
                }
            }
        }

        long answer =
            dp[len][0][1] +
            dp[len][1][1];

        return (int) answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(countWithout(n, d));

        sc.close();
    }
}
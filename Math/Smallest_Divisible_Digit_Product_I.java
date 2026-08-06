/*
3345. Smallest Divisible Digit Product I

Easy

You are given two integers n and t.

Return the smallest number greater than or equal to n such that the product
of its digits is divisible by t.

Examples:

Example 1:
Input: n = 10, t = 2
Output: 10

Explanation:
The digit product of 10 is:
1 × 0 = 0

Since 0 is divisible by 2, 10 is the smallest valid number.

Example 2:
Input: n = 15, t = 3
Output: 16

Explanation:
The digit product of 16 is:
1 × 6 = 6

Since 6 is divisible by 3, 16 is the smallest valid number.

Constraints:

1 <= n <= 100
1 <= t <= 10
*/

public class Smallest_Divisible_Digit_Product_I {

    public static int smallestNumber(int n, int t) {

        while (true) {

            int product = 1;
            int num = n;

            while (num > 0) {
                product *= (num % 10);
                num /= 10;
            }

            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }

    public static void main(String[] args) {

        int n1 = 10;
        int t1 = 2;

        System.out.println("Input: n = " + n1 + ", t = " + t1);
        System.out.println("Output: " + smallestNumber(n1, t1));
        // Expected: 10

        System.out.println();

        int n2 = 15;
        int t2 = 3;

        System.out.println("Input: n = " + n2 + ", t = " + t2);
        System.out.println("Output: " + smallestNumber(n2, t2));
        // Expected: 16
    }
}
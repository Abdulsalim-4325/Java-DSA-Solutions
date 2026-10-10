/*
 * GFG - Balancing with Distinct Powers
 *
 * Given a target weight b and a base a, determine whether the scale
 * can be balanced using distinct powers of a:
 *
 * b + (some powers of a) = (some other powers of a)
 *
 * Each power can be used at most once.
 *
 * Approach:
 * Use a greedy base-a representation.
 *
 * Remainder 0:
 *     Divide by a.
 *
 * Remainder 1:
 *     Use the current power and subtract 1 before dividing.
 *
 * Remainder a - 1:
 *     Use the current power on the opposite pan and carry forward.
 *
 * Any other remainder makes balancing impossible.
 *
 * Time Complexity: O(log_a b)
 * Space Complexity: O(1)
 */

public class Balancing_with_Distinct_Powers {

    public static boolean balancePan(int a, int b) {

        long num = b;

        while (num > 0) {

            long remainder = num % a;

            if (remainder == 0) {

                num /= a;

            } else if (remainder == 1) {

                num = (num - 1) / a;

            } else if (remainder == a - 1L) {

                num = (num + 1) / a;

            } else {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(balancePan(4, 11)); // true
        System.out.println(balancePan(3, 5));  // true
        System.out.println(balancePan(4, 2));  // false
        System.out.println(balancePan(2, 7));  // true
    }
}
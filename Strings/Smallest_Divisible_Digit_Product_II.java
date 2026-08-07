/*
3348. Smallest Divisible Digit Product II

You are given a string num which represents a positive integer, and an integer t.

A number is called zero-free if none of its digits are 0.

Return a string representing the smallest zero-free number greater than or equal to num such that the product of its digits is divisible by t. If no such number exists, return "-1".

Example 1:
Input: num = "1234", t = 256
Output: "1488"

Explanation:
The smallest zero-free number that is greater than 1234 and has the product
of its digits divisible by 256 is 1488, with the product of its digits equal to 256.

Example 2:
Input: num = "12355", t = 50
Output: "12355"

Explanation:
12355 is already zero-free and has the product of its digits divisible by 50,
with the product of its digits equal to 150.

Example 3:
Input: num = "11111", t = 26
Output: "-1"

Explanation:
No number greater than 11111 has the product of its digits divisible by 26.

Constraints:
2 <= num.length <= 2 * 10^5
num consists only of digits in the range ['0', '9'].
num does not contain leading zeros.
1 <= t <= 10^14
*/

public class Smallest_Divisible_Digit_Product_II {

    private final int[][] digitFactors = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {2, 0, 0, 0},
        {0, 0, 1, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 1},
        {3, 0, 0, 0},
        {0, 2, 0, 0}
    };

    public String smallestNumber(String num, long t) {
        int[] target = factorize(t);

        if (target == null) {
            return "-1";
        }

        int[] minimumDigits = getDigits(target);
        int minimumLength = countDigits(minimumDigits);

        if (minimumLength > num.length()) {
            return buildNumber(minimumDigits, num.length() + 1);
        }

        int[] prefix = new int[4];

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            for (int j = 0; j < 4; j++) {
                prefix[j] += digitFactors[digit][j];
            }
        }

        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();

            if (containsAll(prefix, target)) {
                return num;
            }
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';

            for (int j = 0; j < 4; j++) {
                prefix[j] = Math.max(0, prefix[j] - digitFactors[digit][j]);
            }

            if (i > firstZero) {
                continue;
            }

            int remainingPositions = num.length() - 1 - i;

            for (int nextDigit = digit + 1; nextDigit <= 9; nextDigit++) {
                int[] remaining = new int[4];

                for (int j = 0; j < 4; j++) {
                    remaining[j] = Math.max(
                        0,
                        target[j] - prefix[j] - digitFactors[nextDigit][j]
                    );
                }

                int[] requiredDigits = getDigits(remaining);
                int requiredCount = countDigits(requiredDigits);

                if (requiredCount <= remainingPositions) {
                    StringBuilder answer = new StringBuilder();

                    answer.append(num, 0, i);
                    answer.append(nextDigit);

                    for (int j = 0; j < remainingPositions - requiredCount; j++) {
                        answer.append('1');
                    }

                    answer.append(buildNumber(requiredDigits, 0));

                    return answer.toString();
                }
            }
        }

        return buildNumber(minimumDigits, num.length() + 1);
    }

    private int[] factorize(long t) {
        int[] factors = new int[4];
        int[] primes = {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                t /= primes[i];
                factors[i]++;
            }
        }

        if (t != 1) {
            return null;
        }

        return factors;
    }

    private int[] getDigits(int[] factors) {
        int[] result = new int[10];

        int count2 = factors[0];
        int count3 = factors[1];

        result[8] = count2 / 3;
        count2 %= 3;

        result[9] = count3 / 2;
        count3 %= 2;

        result[4] = count2 / 2;
        count2 %= 2;

        int count6 = 0;

        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }

        if (count3 == 1 && result[4] == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            result[4] = 0;
        }

        result[2] = count2;
        result[3] = count3;
        result[5] = factors[2];
        result[6] = count6;
        result[7] = factors[3];

        return result;
    }

    private int countDigits(int[] digits) {
        int count = 0;

        for (int digit = 2; digit <= 9; digit++) {
            count += digits[digit];
        }

        return count;
    }

    private String buildNumber(int[] digits, int totalLength) {
        int required = countDigits(digits);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < totalLength - required; i++) {
            result.append('1');
        }

        for (int digit = 2; digit <= 9; digit++) {
            for (int count = 0; count < digits[digit]; count++) {
                result.append((char) ('0' + digit));
            }
        }

        return result.toString();
    }

    private boolean containsAll(int[] have, int[] need) {
        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Smallest_Divisible_Digit_Product_II solver =
                new Smallest_Divisible_Digit_Product_II();

        String num1 = "1234";
        long t1 = 256;
        System.out.println("Input: num = \"" + num1 + "\", t = " + t1);
        System.out.println("Output: " + solver.smallestNumber(num1, t1));
        System.out.println();

        String num2 = "12355";
        long t2 = 50;
        System.out.println("Input: num = \"" + num2 + "\", t = " + t2);
        System.out.println("Output: " + solver.smallestNumber(num2, t2));
        System.out.println();

        String num3 = "11111";
        long t3 = 26;
        System.out.println("Input: num = \"" + num3 + "\", t = " + t3);
        System.out.println("Output: " + solver.smallestNumber(num3, t3));
        System.out.println();

        String num4 = "12";
        long t4 = 1968750;
        System.out.println("Input: num = \"" + num4 + "\", t = " + t4);
        System.out.println("Output: " + solver.smallestNumber(num4, t4));
    }
}
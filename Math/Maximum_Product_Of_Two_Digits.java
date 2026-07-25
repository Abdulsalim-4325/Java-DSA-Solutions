/*
Maximum Product of Two Digits

You are given a positive integer n.

Return the maximum product of any two digits in n.

Note:
You may use the same digit twice if it appears more than once in n.

Example 1:

Input: n = 31
Output: 3

Example 2:

Input: n = 22
Output: 4

Example 3:

Input: n = 124
Output: 8

Constraints:

10 <= n <= 10^9
*/

public class Maximum_Product_Of_Two_Digits {

    public int maxProduct(int n) {

        int largest = 0;
        int secondLargest = 0;

        while (n > 0) {

            int digit = n % 10;

            if (digit >= largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }

            n /= 10;
        }

        return largest * secondLargest;
    }

    public static void main(String[] args) {

        Maximum_Product_Of_Two_Digits solver = new Maximum_Product_Of_Two_Digits();

        // Test Case 1
        int n1 = 31;
        System.out.println("Input: " + n1);
        System.out.println("Output: " + solver.maxProduct(n1)); // Expected: 3
        System.out.println();

        // Test Case 2
        int n2 = 22;
        System.out.println("Input: " + n2);
        System.out.println("Output: " + solver.maxProduct(n2)); // Expected: 4
        System.out.println();

        // Test Case 3
        int n3 = 124;
        System.out.println("Input: " + n3);
        System.out.println("Output: " + solver.maxProduct(n3)); // Expected: 8
        System.out.println();

        // Test Case 4
        int n4 = 987654321;
        System.out.println("Input: " + n4);
        System.out.println("Output: " + solver.maxProduct(n4)); // Expected: 72
    }
}
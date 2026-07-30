
/*
Maximum Subset XOR

Given an array arr[], choose any subset of elements such that
the XOR of the selected elements is maximum.

Examples:

Input:
arr = [2, 4, 5]

Output:
7

Explanation:
The subset {2, 5} gives:

2 XOR 5 = 7


Input:
arr = [9, 8, 5]

Output:
13

Explanation:
The subset {8, 5} gives:

8 XOR 5 = 13


Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^6
*/

public class Maximum_Subset_XOR {

    public int maxSubsetXOR(int[] arr) {

        /*
         * basis[bit] stores a number whose highest set bit
         * is at position "bit".
         */
        int[] basis = new int[32];

        // Build the XOR Linear Basis.
        for (int number : arr) {

            int value = number;

            /*
             * Process bits from the most significant bit
             * to the least significant bit.
             */
            for (int bit = 31; bit >= 0; bit--) {

                // Skip if the current bit is not set.
                if ((value & (1 << bit)) == 0) {
                    continue;
                }

                /*
                 * If no basis value has this highest set bit,
                 * add the current value to the basis.
                 */
                if (basis[bit] == 0) {
                    basis[bit] = value;
                    break;
                }

                /*
                 * Remove the current highest set bit using
                 * the existing basis value.
                 */
                value ^= basis[bit];
            }
        }

        int maximumXOR = 0;

        /*
         * Try to improve the answer from the highest bit
         * to the lowest bit.
         */
        for (int bit = 31; bit >= 0; bit--) {

            int possibleXOR = maximumXOR ^ basis[bit];

            if (possibleXOR > maximumXOR) {
                maximumXOR = possibleXOR;
            }
        }

        return maximumXOR;
    }

    public static void main(String[] args) {

        Maximum_Subset_XOR solver =
                new Maximum_Subset_XOR();

        // Test Case 1
        int[] arr1 = {2, 4, 5};

        System.out.println("Input: [2, 4, 5]");
        System.out.println(
                "Maximum Subset XOR: "
                        + solver.maxSubsetXOR(arr1)
        );
        // Expected: 7

        System.out.println();

        // Test Case 2
        int[] arr2 = {9, 8, 5};

        System.out.println("Input: [9, 8, 5]");
        System.out.println(
                "Maximum Subset XOR: "
                        + solver.maxSubsetXOR(arr2)
        );
        // Expected: 13

        System.out.println();

        // Test Case 3
        int[] arr3 = {1, 2, 3};

        System.out.println("Input: [1, 2, 3]");
        System.out.println(
                "Maximum Subset XOR: "
                        + solver.maxSubsetXOR(arr3)
        );
        // Expected: 3
    }
}


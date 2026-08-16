/*
Min Product Subset

Given an integer array arr[], find the minimum possible product that can be
obtained by multiplying the elements of any non-empty subset of the array.

Example 1:

Input:
arr[] = [1, 2, 3]

Output:
1

Explanation:
The possible subset products are 1, 2, 3, 2, 3, 6, and 6.
The minimum product is 1, obtained by selecting the subset [1].

Example 2:

Input:
arr[] = [4, -2, 5]

Output:
-40

Explanation:
The minimum product is -40, obtained by selecting the subset
[4, -2, 5].

Constraints:

1 <= arr.size() <= 10
-10 <= arr[i] <= 10
*/

import java.util.*;

public class Min_Product_Subset {

    public static int minProd(int[] arr) {
        int negativeCount = 0;
        int zeroCount = 0;
        int largestNegative = Integer.MIN_VALUE;
        int smallestPositive = Integer.MAX_VALUE;

        long product = 1;

        for (int num : arr) {
            if (num < 0) {
                negativeCount++;
                largestNegative = Math.max(largestNegative, num);
                product *= num;
            } else if (num == 0) {
                zeroCount++;
            } else {
                smallestPositive = Math.min(smallestPositive, num);
            }
        }

        if (negativeCount == 0) {
            if (zeroCount > 0) {
                return 0;
            }

            return smallestPositive;
        }

        if (negativeCount % 2 == 0) {
            product /= largestNegative;
        }

        if (smallestPositive != Integer.MAX_VALUE) {
            product *= smallestPositive;
        }

        return (int) product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minProd(arr));

        sc.close();
    }
}
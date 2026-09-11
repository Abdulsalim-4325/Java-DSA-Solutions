/*
 * Values with Equal Array Remainders
 * Difficulty: Easy | Accuracy: 69.84% | Submissions: 6K+ | Points: 2
 * 
 * Given an integer array arr[], count the number of positive integers k such that 
 * all elements of the array leave the same remainder when divided by k.
 * If there are infinitely many such values of k, return -1.
 * 
 * Examples:
 * 
 * Input: arr[] = [38, 6, 34]
 * Output: 3
 * Explanation: 
 * The values of k for which all elements leave the same remainder when divided by k are 1, 2, and 4.
 * 
 * Input: arr[] = [3, 2]
 * Output: 1
 * Explanation: 
 * The only positive integer for which both elements leave the same remainder is 1.
 * 
 * Input: arr[] = [5, 5, 5]
 * Output: -1
 * Explanation: 
 * All elements in the array are equal. Since there are infinitely many such values of k, the answer is -1.
 * 
 * Constraints:
 * 1 <= arr.size(), arr[i] <= 10^5
 */

public class Values_with_Equal_Array_Remainders {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {38, 6, 34};
        System.out.println("Test Case 1: " + solver.sameMod(arr1)); // Expected: 3

        int[] arr2 = {3, 2};
        System.out.println("Test Case 2: " + solver.sameMod(arr2)); // Expected: 1

        int[] arr3 = {5, 5, 5};
        System.out.println("Test Case 3: " + solver.sameMod(arr3)); // Expected: -1
    }
}

class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;
        if (n <= 1) return -1;

        int g = 0;
        for (int i = 1; i < n; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }

        if (g == 0) return -1;

        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;
                if (i != g / i) {
                    count++;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
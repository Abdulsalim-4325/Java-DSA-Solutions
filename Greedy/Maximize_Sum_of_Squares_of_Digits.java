/*
 * Problem: 3723. Maximize Sum of Squares of Digits
 * 
 * You are given two positive integers num and sum.
 * A positive integer n is good if it satisfies both of the following:
 * - The number of digits in n is exactly num.
 * - The sum of digits in n is exactly sum.
 * 
 * The score of a good integer n is the sum of the squares of digits in n.
 * Return a string denoting the good integer n that achieves the maximum score. 
 * If there are multiple possible integers, return the maximum one. 
 * If no such integer exists, return an empty string.
 * 
 * Example 1:
 * Input: num = 2, sum = 3
 * Output: "30"
 * Explanation:
 * There are 3 good integers: 12, 21, and 30.
 * - The score of 12 is 1^2 + 2^2 = 5.
 * - The score of 21 is 2^2 + 1^2 = 5.
 * - The score of 30 is 3^2 + 0^2 = 9.
 * The maximum score is 9, which is achieved by the good integer 30.
 * 
 * Example 2:
 * Input: num = 2, sum = 17
 * Output: "98"
 * 
 * Example 3:
 * Input: num = 1, sum = 10
 * Output: ""
 * 
 * Constraints:
 * 1 <= num <= 2 * 10^5
 * 1 <= sum <= 2 * 10^6
 * 
 * Approach:
 * Greedy construction. Maximize the number of 9s, append the remainder, and pad with 0s.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Maximize_Sum_of_Squares_of_Digits {

    public String maxSumOfSquares(int num, int sum) {
        if (sum > (long) num * 9) {
            return "";
        }
        
        int nines = sum / 9;
        int rem = sum % 9;
        int zeros = num - nines - (rem > 0 ? 1 : 0);
        
        StringBuilder sb = new StringBuilder(num);
        
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        
        if (rem > 0) {
            sb.append(rem);
        }
        
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Maximize_Sum_of_Squares_of_Digits solution = new Maximize_Sum_of_Squares_of_Digits();

        System.out.println(solution.maxSumOfSquares(2, 3));   // Expected: "30"
        System.out.println(solution.maxSumOfSquares(2, 17));  // Expected: "98"
        System.out.println(solution.maxSumOfSquares(1, 10));  // Expected: ""
    }
}
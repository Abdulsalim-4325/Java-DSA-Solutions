/*
 * Minimum Operations to Reach n
 * Difficulty: Easy | Accuracy: 60.02% | Submissions: 110K+ | Points: 2
 * 
 * Given a number n. Find the minimum number of operations required to reach n 
 * starting from 0.
 * You have two operations available:
 * - Double the number
 * - Add one to the number
 * 
 * Example 1:
 * Input: n = 8
 * Output: 4
 * Explanation: 0 + 1 = 1 --> 1 + 1 = 2 --> 2 * 2 = 4 --> 4 * 2 = 8.
 * 
 * Example 2:
 * Input: n = 7
 * Output: 5
 * Explanation: 0 + 1 = 1 --> 1 * 2 = 2 --> 2 + 1 = 3 --> 3 * 2 = 6 --> 6 + 1 = 7.
 * 
 * Constraints:
 * 1 <= n <= 10^6
 */

public class Minimum_Operations_to_Reach_n {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.minOperation(8)); 
        // Expected: 4

        System.out.println("Test Case 2: " + solver.minOperation(7)); 
        // Expected: 5

        System.out.println("Test Case 3: " + solver.minOperation(10)); 
        // Expected: 5 (10 -> 5 -> 4 -> 2 -> 1 -> 0)
        
        System.out.println("Test Case 4: " + solver.minOperation(15)); 
        // Expected: 7 (15 -> 14 -> 7 -> 6 -> 3 -> 2 -> 1 -> 0)
    }
}

class Solution {
    public int minOperation(int n) {
        int operations = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            operations++;
        }
        
        return operations;
    }
}
/*
 * LeetCode 3483. Unique 3-Digit Even Numbers
 * Easy
 * 
 * You are given an array of digits called digits. Your task is to determine the 
 * number of distinct three-digit even numbers that can be formed using these digits.
 * Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.
 * 
 * Example 1:
 * Input: digits = [1,2,3,4]
 * Output: 12
 * 
 * Example 2:
 * Input: digits = [0,2,2]
 * Output: 2
 * 
 * Example 3:
 * Input: digits = [6,6,6]
 * Output: 1
 * 
 * Example 4:
 * Input: digits = [1,3,5]
 * Output: 0
 * 
 * Constraints:
 * 3 <= digits.length <= 10
 * 0 <= digits[i] <= 9
 */

public class Unique_3_Digit_Even_Numbers {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] digits1 = {1, 2, 3, 4};
        System.out.println("Test Case 1: " + solver.totalNumbers(digits1)); // Expected: 12

        int[] digits2 = {0, 2, 2};
        System.out.println("Test Case 2: " + solver.totalNumbers(digits2)); // Expected: 2

        int[] digits3 = {6, 6, 6};
        System.out.println("Test Case 3: " + solver.totalNumbers(digits3)); // Expected: 1

        int[] digits4 = {1, 3, 5};
        System.out.println("Test Case 4: " + solver.totalNumbers(digits4)); // Expected: 0
    }
}

class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        
        int validCount = 0;
        
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;
            
            count[d1]--;
            count[d2]--;
            count[d3]--;
            
            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                validCount++;
            }
            
            count[d1]++;
            count[d2]++;
            count[d3]++;
        }
        
        return validCount;
    }
}
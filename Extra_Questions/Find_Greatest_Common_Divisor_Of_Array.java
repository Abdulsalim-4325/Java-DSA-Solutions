/*
Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

 

Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.
Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.
Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.
 

Constraints:

2 <= nums.length <= 1000
1 <= nums[i] <= 1000
*/



import java.util.Arrays;

public class Find_Greatest_Common_Divisor_Of_Array {
    
    // LeetCode core algorithm logic
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        return gcd(min, max);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main method to run and execute code locally inside VS Code
    public static void main(String[] args) {
        Find_Greatest_Common_Divisor_Of_Array solver = new Find_Greatest_Common_Divisor_Of_Array();

        // Test Case 1
        int[] test1 = {2, 5, 6, 9, 10};
        System.out.println("Input: nums = " + Arrays.toString(test1));
        System.out.println("Output: " + solver.findGCD(test1)); // Expected: 2
        System.out.println();

        // Test Case 2
        int[] test2 = {7, 5, 6, 8, 3};
        System.out.println("Input: nums = " + Arrays.toString(test2));
        System.out.println("Output: " + solver.findGCD(test2)); // Expected: 1
        System.out.println();

        // Test Case 3
        int[] test3 = {3, 3};
        System.out.println("Input: nums = " + Arrays.toString(test3));
        System.out.println("Output: " + solver.findGCD(test3)); // Expected: 3
    }
}

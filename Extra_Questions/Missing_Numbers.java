
    import java.util.Arrays;

public class Missing_Numbers {
    
    // Optimised solution using the Math Summation formula
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] test1 = {3, 0, 1};
        System.out.println("Input: " + Arrays.toString(test1));
        System.out.println("Output: " + solver.missingNumber(test1)); // Expected: 2
        System.out.println();

        // Test Case 2
        int[] test2 = {0, 1};
        System.out.println("Input: " + Arrays.toString(test2));
        System.out.println("Output: " + solver.missingNumber(test2)); // Expected: 2
        System.out.println();

        // Test Case 3
        int[] test3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Input: " + Arrays.toString(test3));
        System.out.println("Output: " + solver.missingNumber(test3)); // Expected: 8
    }
}



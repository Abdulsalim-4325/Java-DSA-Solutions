import java.util.Arrays;

public class Single_Number {
    
    
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }

   
    public static void main(String[] args) {
        Single_Number solver = new Single_Number();

        // Test Case 1: 
        int[] test1 = {2, 2, 1};
        System.out.println("Input: nums = " + Arrays.toString(test1));
        System.out.println("Output: " + solver.singleNumber(test1)); // Expected: 1
        System.out.println();

        // Test Case 2: 
        int[] test2 = {4, 1, 2, 1, 2};
        System.out.println("Input: nums = " + Arrays.toString(test2));
        System.out.println("Output: " + solver.singleNumber(test2)); // Expected: 4
        System.out.println();

        // Test Case 3: 
        int[] test3 = {1};
        System.out.println("Input: nums = " + Arrays.toString(test3));
        System.out.println("Output: " + solver.singleNumber(test3)); // Expected: 1
    }
}

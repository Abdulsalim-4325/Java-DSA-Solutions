public class Square_Root_Of_X{

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int test1 = 4;
        System.out.println("Input: x = " + test1);
        System.out.println("Output: " + solution.mySqrt(test1)); // Expected: 2
        System.out.println();

        // Test Case 2
        int test2 = 8;
        System.out.println("Input: x = " + test2);
        System.out.println("Output: " + solution.mySqrt(test2)); // Expected: 2
        System.out.println();

        // Test Case 3
        int test3 = 0;
        System.out.println("Input: x = " + test3);
        System.out.println("Output: " + solution.mySqrt(test3)); // Expected: 0
        System.out.println();

        // Test Case 4
        int test4 = 2147395599;
        System.out.println("Input: x = " + test4);
        System.out.println("Output: " + solution.mySqrt(test4)); // Expected: 46339
    }
} class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        
        int left = 2;
        int right = x / 2;
        
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            
            long num = (long) pivot * pivot; 
            
            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        
        return right;
    }
}


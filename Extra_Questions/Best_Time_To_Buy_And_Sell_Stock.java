import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock {
    
    // LeetCode core algorithm logic
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }

    // Main method to run and execute code locally inside VS Code
    public static void main(String[] args) {
        Best_Time_To_Buy_And_Sell_Stock solver = new Best_Time_To_Buy_And_Sell_Stock();

        // Test Case 1
        int[] test1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = " + Arrays.toString(test1));
        System.out.println("Output: " + solver.maxProfit(test1)); // Expected: 5
        System.out.println();

        // Test Case 2
        int[] test2 = {7, 6, 4, 3, 1};
        System.out.println("Input: prices = " + Arrays.toString(test2));
        System.out.println("Output: " + solver.maxProfit(test2)); // Expected: 0
    }
}

/*
 * Problem: Maximum Without 3 Consecutive Set Bits (GeeksforGeeks - Medium)
 * 
 * Given a non-negative integer n, you can only change a set bit (1) to an unset bit (0). 
 * Find the maximum possible value of n such that its binary representation does not 
 * contain three consecutive set bits (111) after performing zero or more allowed operations.
 * 
 * Examples:
 * Input: n = 2
 * Output: 2
 * Explanation: The binary representation of 2 is 10, which does not contain three 
 * consecutive set bits. Therefore, no change is required.
 * 
 * Input: n = 7
 * Output: 6
 * Explanation: The binary representation of 7 is 111, which contains three consecutive 
 * set bits. Changing the rightmost set bit to 0 gives: 111 -> 110. Thus, the maximum 
 * possible value is 6.
 * 
 * Constraints:
 * 0 <= n <= 10^9
 * 
 * Approach:
 * Greedy bit manipulation. Traverse from the most significant bit to the least.
 * When three consecutive 1s are encountered, flip the third one (the least significant
 * of the sequence) to 0 to minimize value loss.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class Maximum_Without_3_Consecutive_Set_Bits {

    public int maxValue(int n) {
        int res = 0;
        int consecutiveOnes = 0;
        
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                consecutiveOnes++;
                if (consecutiveOnes == 3) {
                    consecutiveOnes = 0; // Flip this bit by omitting it from 'res'
                } else {
                    res |= (1 << i); // Keep the bit
                }
            } else {
                consecutiveOnes = 0; // Reset on a 0
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Maximum_Without_3_Consecutive_Set_Bits solution = 
                new Maximum_Without_3_Consecutive_Set_Bits();

        System.out.println(solution.maxValue(2)); // Expected: 2
        System.out.println(solution.maxValue(7)); // Expected: 6
        System.out.println(solution.maxValue(15)); // Expected: 13
    }
}
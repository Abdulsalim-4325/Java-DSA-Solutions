/*
 * Problem: Maximum Weight Transformation of String (GeeksforGeeks - Medium)
 * 
 * Given a string s consisting only of the characters 'A' and 'B', you can toggle 
 * any character. A toggle changes 'A' to 'B' or 'B' to 'A'.
 * The weight of a string is calculated using the following rules:
 * - An alternating adjacent pair ("AB" or "BA") contributes 4 to the weight.
 * - Each character can belong to at most one pair, so the pairs must not overlap.
 * - Every character that does not belong to any pair contributes 1 to the weight.
 * - Each toggle performed decreases the total weight by 1.
 * 
 * Therefore, Weight = Weight of alternating adjacent pairs + Weight of characters 
 * that do not belong to any pair - Number of Toggles.
 * 
 * Find the maximum possible weight obtainable from the string by choosing pairs 
 * and toggling characters optimally.
 * 
 * Example 1:
 * Input: s = "AA"
 * Output: 3
 * Explanation: Toggle one 'A' to get "AB". Weight = 4. Cost = 1. Total = 3.
 * 
 * Example 2:
 * Input: s = "ABB"
 * Output: 5
 * Explanation: "AB" forms a pair (weight 4). 'B' remains unpaired (weight 1). 
 * No toggles needed. Total = 5.
 * 
 * Constraints:
 * 1 <= s.size() <= 10^5
 * s consists only of the characters A and B
 * 
 * Approach:
 * Constant Space 1D Dynamic Programming. Track the maximum weight achievable by 
 * dynamically deciding whether to keep the current character isolated or fuse it 
 * with its neighbor, evaluating toggle costs dynamically.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Maximum_Weight_Transformation_of_String {

    public int getMaxWeight(String s) {
        int n = s.length();
        if (n == 1) return 1;

        int prev2 = 0; 
        int prev1 = 1; 

        for (int i = 2; i <= n; i++) {
            int current = prev1 + 1; 
            
            int pairWeight = (s.charAt(i - 1) != s.charAt(i - 2)) ? 4 : 3;
            
            current = Math.max(current, prev2 + pairWeight);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Maximum_Weight_Transformation_of_String solution = new Maximum_Weight_Transformation_of_String();

        System.out.println(solution.getMaxWeight("AA")); // Expected: 3
        System.out.println(solution.getMaxWeight("ABB")); // Expected: 5
        System.out.println(solution.getMaxWeight("ABAB")); // Expected: 8
    }
}
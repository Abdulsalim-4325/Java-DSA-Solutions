/*
 * Pairs with Given GCD and LCM
 * Difficulty: Easy | Accuracy: 61.3% | Submissions: 6K+ | Points: 2
 * 
 * Given two integers x and y representing the GCD and LCM of two unknown positive 
 * integers a and b, count the number of valid pairs (a, b) satisfying these conditions. 
 * Note that (a, b) and (b, a) are counted as distinct pairs when a != b.
 * 
 * Examples:
 * 
 * Input: x = 2, y = 12
 * Output: 4
 * Explanation: The valid pairs are (2, 12), (4, 6), (6, 4), and (12, 2), 
 * since each pair has GCD = 2 and LCM = 12.
 * 
 * Input: x = 6, y = 4
 * Output: 0
 * Explanation: LCM must always be a multiple of GCD. Since y is not divisible by x, 
 * no valid pair exists.
 * 
 * Constraints:
 * 1 <= x, y <= 10^4
 */

public class Pairs_with_Given_GCD_and_LCM {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.pairCount(2, 12)); // Expected: 4
        System.out.println("Test Case 2: " + solver.pairCount(6, 4));  // Expected: 0
        System.out.println("Test Case 3: " + solver.pairCount(3, 3));  // Expected: 1
    }
}

class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }
        
        int target = y / x;
        int count = 0;
        
        for (int i = 1; i * i <= target; i++) {
            if (target % i == 0) {
                int p = i;
                int q = target / i;
                
                if (gcd(p, q) == 1) {
                    if (p == q) {
                        count += 1;
                    } else {
                        count += 2;
                    }
                }
            }
        }
        
        return count;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
/*
 * Problem: Sum of Beauty of All Substrings (GeeksforGeeks - Easy)
 * 
 * Given a string s, return the sum of the beauty of all substrings of s. 
 * The beauty of a substring is defined as the difference between the maximum 
 * and minimum frequencies of the characters present in that substring.
 * 
 * Examples:
 * Input: s = "aaac"
 * Output: 3
 * Explanation: The substrings with non-zero beauty are "aaac" and "aac". 
 * For "aaac", the frequencies are a = 3 and c = 1. Its beauty is 3 - 1 = 2. 
 * For "aac", the frequencies are a = 2 and c = 1. Its beauty is 2 - 1 = 1.
 * The remaining substrings have a beauty of 0. Therefore, the sum is 2 + 1 = 3.
 * 
 * Input: s = "aabc"
 * Output: 2
 * Explanation: The substrings with non-zero beauty are "aab" and "aabc". 
 * For "aab", a = 2 and b = 1. Beauty is 2 - 1 = 1. 
 * For "aabc", a = 2, b = 1, and c = 1. Beauty is 2 - 1 = 1.
 * Total sum is 1 + 1 = 2.
 * 
 * Constraints:
 * 1 <= s.size() <= 500
 * s consists only of lowercase English alphabets
 * 
 * Approach:
 * Generate all substrings using nested loops while maintaining character frequencies. 
 * Calculate the max and min frequency incrementally for each valid substring length.
 * 
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

public class Sum_of_Beauty_of_All_Substrings {

    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                
                totalBeauty += (maxFreq - minFreq);
            }
        }
        
        return totalBeauty;
    }

    public static void main(String[] args) {
        Sum_of_Beauty_of_All_Substrings solution = new Sum_of_Beauty_of_All_Substrings();

        System.out.println(solution.beautySum("aaac")); // Expected: 3
        System.out.println(solution.beautySum("aabc")); // Expected: 2
    }
}
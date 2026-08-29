/*
 * LeetCode 3734. Lexicographically Smallest Palindromic Permutation Greater Than Target
 * 
 * You are given two strings s and target, each of length n, consisting of lowercase English letters.
 * Return the lexicographically smallest string that is both a palindromic permutation of s and 
 * strictly greater than target. If no such permutation exists, return an empty string.
 * 
 * Example 1:
 * Input: s = "baba", target = "abba"
 * Output: "baab"
 * Explanation:
 * The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
 * The lexicographically smallest permutation that is strictly greater than target is "baab".
 * 
 * Example 2:
 * Input: s = "baba", target = "bbaa"
 * Output: ""
 * Explanation:
 * The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
 * None of them is lexicographically strictly greater than target. Therefore, the answer is "".
 * 
 * Example 3:
 * Input: s = "abc", target = "abb"
 * Output: ""
 * Explanation:
 * s has no palindromic permutations. Therefore, the answer is "".
 * 
 * Example 4:
 * Input: s = "aac", target = "abb"
 * Output: "aca"
 * Explanation:
 * The only palindromic permutation of s is "aca".
 * "aca" is strictly greater than target. Therefore, the answer is "aca".
 * 
 * Constraints:
 * 1 <= n == s.length == target.length <= 300
 * s and target consist of only lowercase English letters.
 */

public class Lexicographically_Smallest_Palindromic_Permutation_Greater_Than_Target {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.lexPalindromicPermutation("baba", "abba")); // Expected: "baab"
        System.out.println("Test Case 2: " + solver.lexPalindromicPermutation("baba", "bbaa")); // Expected: ""
        System.out.println("Test Case 3: " + solver.lexPalindromicPermutation("abc", "abb"));   // Expected: ""
        System.out.println("Test Case 4: " + solver.lexPalindromicPermutation("aac", "abb"));   // Expected: "aca"
    }
}

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int oddCount = 0;
        int midChar = -1;
        int[] pairs = new int[26];
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = i;
            }
            pairs[i] = freq[i] / 2;
        }

        if (oddCount > 1) return ""; 

        int n = s.length();
        int m = n / 2;
        String targetH = target.substring(0, m);

        if (canForm(targetH, pairs)) {
            StringBuilder sb = new StringBuilder();
            sb.append(targetH);
            if (midChar != -1) sb.append((char) (midChar + 'a'));
            sb.append(new StringBuilder(targetH).reverse());
            String pExact = sb.toString();
            if (pExact.compareTo(target) > 0) return pExact; 
        }

        int maxPrefix = 0;
        int[] tempPairs = pairs.clone();
        for (int i = 0; i < m; i++) {
            int c = targetH.charAt(i) - 'a';
            if (tempPairs[c] > 0) {
                tempPairs[c]--;
                maxPrefix++;
            } else break;
        }

        int startI = Math.min(m - 1, maxPrefix);
        for (int i = startI; i >= 0; i--) {
            int[] currAvailable = pairs.clone();
            
            for (int k = 0; k < i; k++) {
                currAvailable[targetH.charAt(k) - 'a']--;
            }

            int targetChar = targetH.charAt(i) - 'a';
            int pickedChar = -1;
            for (int c = targetChar + 1; c < 26; c++) {
                if (currAvailable[c] > 0) {
                    pickedChar = c;
                    break;
                }
            }

            if (pickedChar != -1) {
                StringBuilder h = new StringBuilder();
                h.append(targetH.substring(0, i));
                h.append((char) (pickedChar + 'a'));
                currAvailable[pickedChar]--;

                for (int c = 0; c < 26; c++) {
                    while (currAvailable[c] > 0) {
                        h.append((char) (c + 'a'));
                        currAvailable[c]--;
                    }
                }

                StringBuilder p = new StringBuilder();
                p.append(h);
                if (midChar != -1) p.append((char) (midChar + 'a'));
                p.append(new StringBuilder(h).reverse());
                
                return p.toString();
            }
        }
        return "";
    }

    private boolean canForm(String h, int[] pairs) {
        int[] temp = pairs.clone();
        for (char c : h.toCharArray()) {
            if (temp[c - 'a'] <= 0) return false;
            temp[c - 'a']--;
        }
        return true;
    }
} 
    


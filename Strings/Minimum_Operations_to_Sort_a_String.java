/*
 * Problem: 3863. Minimum Operations to Sort a String
 * 
 * You are given a string s consisting of lowercase English letters.
 * In one operation, you can select any substring of s that is not the entire 
 * string and sort it in non-descending alphabetical order.
 * 
 * Return the minimum number of operations required to make s sorted in 
 * non-descending order. If it is not possible, return -1.
 * 
 * Example 1:
 * Input: s = "dog"
 * Output: 1
 * Explanation: Sort substring "og" to "go". s = "dgo", which is sorted.
 * 
 * Example 2:
 * Input: s = "card"
 * Output: 2
 * Explanation: Sort "car" to "acr" -> "acrd". Sort "rd" to "dr" -> "acdr".
 * 
 * Example 3:
 * Input: s = "gf"
 * Output: -1
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 * 
 * Approach:
 * Use analytical deduction rather than simulating sorts. Verify if 0, 1, or 3 
 * operations are required based on the positions of the maximum and minimum 
 * characters. If none of these edge cases match, 2 operations are always sufficient.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class Minimum_Operations_to_Sort_a_String {

    public int minOperations(String s) {
        int n = s.length();
        
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        if (n <= 2) return -1;
        
        char maxPrefix = 'a';
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > maxPrefix) {
                maxPrefix = s.charAt(i);
            }
        }
        if (s.charAt(n - 1) >= maxPrefix) return 1;
        
        char minSuffix = 'z';
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < minSuffix) {
                minSuffix = s.charAt(i);
            }
        }
        if (s.charAt(0) <= minSuffix) return 1;
        
        boolean maxAt0 = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) >= s.charAt(0)) {
                maxAt0 = false;
                break;
            }
        }
        
        boolean minAtN = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) <= s.charAt(n - 1)) {
                minAtN = false;
                break;
            }
        }
        
        if (maxAt0 && minAtN) {
            return 3;
        }
        
        return 2;
    }

    public static void main(String[] args) {
        Minimum_Operations_to_Sort_a_String solution = new Minimum_Operations_to_Sort_a_String();

        System.out.println(solution.minOperations("dog"));  // Expected: 1
        System.out.println(solution.minOperations("card")); // Expected: 2
        System.out.println(solution.minOperations("gf"));   // Expected: -1
        System.out.println(solution.minOperations("cba"));  // Expected: 3
    }
}
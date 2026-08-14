/*
3090. Maximum Length Substring With Two Occurrences

Given a string s, return the maximum length of a substring such that it
contains at most two occurrences of each character.

Example 1:

Input:
s = "bcbbbcba"

Output:
4

Explanation:
A substring of length 4 can contain at most two occurrences of each
character.

Example 2:

Input:
s = "aaaa"

Output:
2

Explanation:
The longest valid substring is "aa" because each character can occur
at most twice.

Constraints:

2 <= s.length <= 100
s consists only of lowercase English letters.
*/

import java.util.*;

public class Maximum_Length_Substring_With_Two_Occurrences {

    public static int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maximumLengthSubstring(s));

        sc.close();
    }
}
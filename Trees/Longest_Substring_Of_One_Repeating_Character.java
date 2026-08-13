/*
2213. Longest Substring of One Repeating Character

You are given a 0-indexed string s.

You are also given a 0-indexed string queryCharacters of length k and a
0-indexed array of integer queryIndices of length k.

The ith query updates the character in s at index queryIndices[i] to the
character queryCharacters[i].

Return an array lengths of length k where lengths[i] is the length of the
longest substring of s consisting of only one repeating character after
the ith query is performed.

Example 1:

Input:
s = "babacc"
queryCharacters = "bcb"
queryIndices = [1,3,3]

Output:
[3,3,4]

Example 2:

Input:
s = "abyzz"
queryCharacters = "aa"
queryIndices = [2,1]

Output:
[2,3]

Constraints:

1 <= s.length <= 10^5
s consists of lowercase English letters.
k == queryCharacters.length == queryIndices.length
1 <= k <= 10^5
queryCharacters consists of lowercase English letters.
0 <= queryIndices[i] < s.length
*/

import java.util.*;

public class Longest_Substring_Of_One_Repeating_Character {

    private static int[] len;
    private static int[] prefix;
    private static int[] suffix;
    private static int[] best;
    private static char[] leftChar;
    private static char[] rightChar;

    private static void build(int node, int left, int right, char[] str) {
        len[node] = right - left + 1;

        if (left == right) {
            prefix[node] = 1;
            suffix[node] = 1;
            best[node] = 1;
            leftChar[node] = str[left];
            rightChar[node] = str[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, str);
        build(node * 2 + 1, mid + 1, right, str);

        merge(node);
    }

    private static void update(
            int node,
            int left,
            int right,
            int index,
            char ch) {

        if (left == right) {
            prefix[node] = 1;
            suffix[node] = 1;
            best[node] = 1;
            leftChar[node] = ch;
            rightChar[node] = ch;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        merge(node);
    }

    private static void merge(int node) {
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;

        leftChar[node] = leftChar[leftNode];
        rightChar[node] = rightChar[rightNode];

        prefix[node] = prefix[leftNode];

        if (prefix[leftNode] == len[leftNode]
                && rightChar[leftNode] == leftChar[rightNode]) {
            prefix[node] += prefix[rightNode];
        }

        suffix[node] = suffix[rightNode];

        if (suffix[rightNode] == len[rightNode]
                && rightChar[leftNode] == leftChar[rightNode]) {
            suffix[node] += suffix[leftNode];
        }

        best[node] = Math.max(best[leftNode], best[rightNode]);

        if (rightChar[leftNode] == leftChar[rightNode]) {
            best[node] = Math.max(
                best[node],
                suffix[leftNode] + prefix[rightNode]
            );
        }
    }

    private static int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        len = new int[4 * n];
        prefix = new int[4 * n];
        suffix = new int[4 * n];
        best = new int[4 * n];
        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        char[] str = s.toCharArray();

        build(1, 0, n - 1, str);

        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            answer[i] = best[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String queryCharacters = sc.nextLine();

        int k = sc.nextInt();

        int[] queryIndices = new int[k];

        for (int i = 0; i < k; i++) {
            queryIndices[i] = sc.nextInt();
        }

        int[] answer = longestRepeating(
            s,
            queryCharacters,
            queryIndices
        );

        System.out.print("[");

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);

            if (i < answer.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}
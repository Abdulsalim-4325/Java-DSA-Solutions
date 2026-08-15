/*
3702. Longest Subsequence With Non-Zero Bitwise XOR

You are given an integer array nums.

Return the length of the longest subsequence in nums whose bitwise XOR
is non-zero. If no such subsequence exists, return 0.

Example 1:

Input:
nums = [1, 2, 3]

Output:
2

Explanation:
One longest subsequence is [2, 3].
The bitwise XOR is:
2 XOR 3 = 1

Example 2:

Input:
nums = [2, 3, 4]

Output:
3

Explanation:
The longest subsequence is [2, 3, 4].
The bitwise XOR is:
2 XOR 3 XOR 4 = 5

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
*/

import java.util.*;

public class Longest_Subsequence_With_Non_Zero_Bitwise_XOR {

    public static int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        return hasNonZero ? nums.length - 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(longestSubsequence(nums));

        sc.close();
    }
}
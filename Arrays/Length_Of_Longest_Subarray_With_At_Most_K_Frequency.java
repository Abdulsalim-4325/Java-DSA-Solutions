/*
2958. Length of Longest Subarray With at Most K Frequency

You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array
is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input:
nums = [1,2,3,1,2,3,1,2], k = 2

Output:
6

Explanation:
The longest possible good subarray is [1,2,3,1,2,3] since the values
1, 2, and 3 occur at most twice in this subarray.

Example 2:
Input:
nums = [1,2,1,2,1,2,1,2], k = 1

Output:
2

Example 3:
Input:
nums = [5,5,5,5,5,5,5], k = 4

Output:
4

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length
*/

import java.util.*;

public class Length_Of_Longest_Subarray_With_At_Most_K_Frequency {

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            frequency.put(
                nums[right],
                frequency.getOrDefault(nums[right], 0) + 1
            );

            while (frequency.get(nums[right]) > k) {
                frequency.put(
                    nums[left],
                    frequency.get(nums[left]) - 1
                );
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxSubarrayLength(nums, k));

        sc.close();
    }
}
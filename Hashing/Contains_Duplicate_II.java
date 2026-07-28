/*
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there
are two distinct indices i and j such that:

nums[i] == nums[j]
abs(i - j) <= k

Otherwise, return false.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
*/

import java.util.HashMap;

public class Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]) &&
                    i - map.get(nums[i]) <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {

        Contains_Duplicate_II solver = new Contains_Duplicate_II();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: [1,2,3,1], k = 3");
        System.out.println("Output: " +
                solver.containsNearbyDuplicate(nums1, 3)); // Expected: true
        System.out.println();

        // Test Case 2
        int[] nums2 = {1, 0, 1, 1};
        System.out.println("Input: [1,0,1,1], k = 1");
        System.out.println("Output: " +
                solver.containsNearbyDuplicate(nums2, 1)); // Expected: true
        System.out.println();

        // Test Case 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println("Input: [1,2,3,1,2,3], k = 2");
        System.out.println("Output: " +
                solver.containsNearbyDuplicate(nums3, 2)); // Expected: false
        System.out.println();

        // Test Case 4
        int[] nums4 = {99, 99};
        System.out.println("Input: [99,99], k = 2");
        System.out.println("Output: " +
                solver.containsNearbyDuplicate(nums4, 2)); // Expected: true
    }
}
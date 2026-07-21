/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104*/
import java.util.Arrays;

public class Search_Insert_Position {
    
    
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }

   
    public static void main(String[] args) {
        Search_Insert_Position solver = new Search_Insert_Position();

        // Test Case 1: Target exists exactly in the array
        int[] test1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = " + Arrays.toString(test1) + ", target = " + target1);
        System.out.println("Output: " + solver.searchInsert(test1, target1)); // Expected: 2
        System.out.println();

        // Test Case 2: Target does not exist, inserts in the middle
        int[] test2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = " + Arrays.toString(test2) + ", target = " + target2);
        System.out.println("Output: " + solver.searchInsert(test2, target2)); // Expected: 1
        System.out.println();

        // Test Case 3: Target does not exist, inserts at the extreme upper boundary
        int[] test3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = " + Arrays.toString(test3) + ", target = " + target3);
        System.out.println("Output: " + solver.searchInsert(test3, target3)); // Expected: 4
    }
}

/*Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.*/



import java.util.Arrays;

public class Remove_Duplicates_From_Sorted_Array {
    
    // LeetCode core algorithm logic
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int k = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }

    
    public static void main(String[] args) {
        Remove_Duplicates_From_Sorted_Array solver = new Remove_Duplicates_From_Sorted_Array();

        // Test Case 1
        int[] test1 = {1, 1, 2};
        System.out.println("Input: nums = " + Arrays.toString(test1));
        int k1 = solver.removeDuplicates(test1);
        System.out.println("Output: k = " + k1);
        System.out.println("Modified array (first " + k1 + " elements): " + Arrays.toString(Arrays.copyOf(test1, k1)));
        System.out.println();

        // Test Case 2
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input: nums = " + Arrays.toString(test2));
        int k2 = solver.removeDuplicates(test2);
        System.out.println("Output: k = " + k2);
        System.out.println("Modified array (first " + k2 + " elements): " + Arrays.toString(Arrays.copyOf(test2, k2)));
    }
}

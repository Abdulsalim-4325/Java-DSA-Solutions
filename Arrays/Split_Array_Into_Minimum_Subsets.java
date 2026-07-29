```java
/*
Split Array into Minimum Subsets

Given an array of distinct positive numbers, split the array into
the minimum number of subsets such that every subset contains
consecutive numbers.

Examples:

Input:
arr = [100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59]

Output:
3

Explanation:
The array can be divided into:

[5, 6, 7]
[56, 57, 58, 59]
[100, 101, 102, 103]

Input:
arr = [10, 100, 105]

Output:
3

Explanation:
No two values are consecutive, so each value forms its own subset.
*/

import java.util.Arrays;

public class Split_Array_Into_Minimum_Subsets {

    public int minSubsets(int[] arr) {

        Arrays.sort(arr);

        int subsets = 1;

        for (int i = 1; i < arr.length; i++) {

            
            if (arr[i] != arr[i - 1] + 1) {
                subsets++;
            }
        }

        return subsets;
    }

    public static void main(String[] args) {

        Split_Array_Into_Minimum_Subsets solver =
                new Split_Array_Into_Minimum_Subsets();

        // Test Case 1
        int[] arr1 = {
                100, 56, 5, 6, 102,
                58, 101, 57, 7, 103, 59
        };

        System.out.println(
                "Minimum subsets: " + solver.minSubsets(arr1)
        );
        // Expected: 3

        // Test Case 2
        int[] arr2 = {10, 100, 105};

        System.out.println(
                "Minimum subsets: " + solver.minSubsets(arr2)
        );
        // Expected: 3

        // Test Case 3
        int[] arr3 = {4, 2, 3, 1, 5};

        System.out.println(
                "Minimum subsets: " + solver.minSubsets(arr3)
        );
        // Expected: 1
    }
}
```

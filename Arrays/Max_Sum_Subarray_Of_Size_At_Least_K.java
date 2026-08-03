
/*
Max Sum Subarray of Size at Least K

Given an integer array arr[] and an integer k,
find the maximum sum among all contiguous subarrays
having a length greater than or equal to k.

Examples:

Input:
arr = [1, -2, 2, -3]
k = 3

Output:
1

Explanation:
The subarray [1, -2, 2] has a sum of 1.


Input:
arr = [1, 1, 1, 1, 1, 1]
k = 2

Output:
6

Explanation:
The entire array has the maximum sum.


Input:
arr = [-4, -2, 1, -3]
k = 2

Output:
-1

Explanation:
The subarray [-2, 1] has a sum of -1.
*/

public class Max_Sum_Subarray_Of_Size_At_Least_K {

    public int maxSumWithK(int[] arr, int k) {

        int n = arr.length;

        
        int[] maxEndingHere = new int[n];

        maxEndingHere[0] = arr[0];

        
        for (int i = 1; i < n; i++) {

            
            maxEndingHere[i] = Math.max(
                    arr[i],
                    arr[i] + maxEndingHere[i - 1]
            );
        }

        
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

       
        int maximumSum = windowSum;

        
        for (int right = k; right < n; right++) {

          
            windowSum += arr[right];

            
            windowSum -= arr[right - k];

          
            int extendedSum =
                    windowSum
                    + maxEndingHere[right - k];

           
            maximumSum = Math.max(
                    maximumSum,
                    Math.max(
                            windowSum,
                            extendedSum
                    )
            );
        }

        return maximumSum;
    }

    public static void main(String[] args) {

        Max_Sum_Subarray_Of_Size_At_Least_K solver =
                new Max_Sum_Subarray_Of_Size_At_Least_K();

        // Test Case 1
        int[] arr1 = {1, -2, 2, -3};
        int k1 = 3;

        System.out.println(
                "Input: [1, -2, 2, -3], k = 3"
        );

        System.out.println(
                "Maximum sum: "
                        + solver.maxSumWithK(arr1, k1)
        );
        // Expected: 1

        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int k2 = 2;

        System.out.println(
                "Input: [1, 1, 1, 1, 1, 1], k = 2"
        );

        System.out.println(
                "Maximum sum: "
                        + solver.maxSumWithK(arr2, k2)
        );
        // Expected: 6

        System.out.println();

        // Test Case 3
        int[] arr3 = {-4, -2, 1, -3};
        int k3 = 2;

        System.out.println(
                "Input: [-4, -2, 1, -3], k = 2"
        );

        System.out.println(
                "Maximum sum: "
                        + solver.maxSumWithK(arr3, k3)
        );
        // Expected: -1
    }
}


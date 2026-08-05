
/*
Subarrays with Sum in Range

Given an integer array arr[] and two integers l and r,
find the number of contiguous subarrays whose sum lies
in the inclusive range [l, r].


Example 1:

Input:
arr = [1, 4, 6]
l = 3
r = 8

Output:
3

Valid subarrays:

[1, 4] -> Sum = 5
[4]    -> Sum = 4
[6]    -> Sum = 6


Example 2:

Input:
arr = [2, 3, 5, 8]
l = 4
r = 13

Output:
6
*/

public class Subarrays_With_Sum_In_Range {

    public static int countSubarray(
            int[] arr,
            int l,
            int r
    ) {

        int n = arr.length;

        
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {

            prefix[i + 1] =
                    prefix[i] + arr[i];
        }

        
        long totalCount = 0;

        
        for (int i = 1; i <= n; i++) {

            
            long minimumPrefix =
                    prefix[i] - r;

            long maximumPrefix =
                    prefix[i] - l;

            
            int firstValidIndex =
                    lowerBound(
                            prefix,
                            0,
                            i,
                            minimumPrefix
                    );

            
            int firstInvalidIndex =
                    upperBound(
                            prefix,
                            0,
                            i,
                            maximumPrefix
                    );

            
            totalCount +=
                    firstInvalidIndex
                            - firstValidIndex;
        }

        return (int) totalCount;
    }

    
    private static int lowerBound(
            long[] prefix,
            int from,
            int to,
            long target
    ) {

        int left = from;
        int right = to;

        while (left < right) {

            int mid =
                    left
                    + (right - left) / 2;

            if (prefix[mid] < target) {

                left = mid + 1;

            } else {

                right = mid;
            }
        }

        return left;
    }

   
    private static int upperBound(
            long[] prefix,
            int from,
            int to,
            long target
    ) {

        int left = from;
        int right = to;

        while (left < right) {

            int mid =
                    left
                    + (right - left) / 2;

            if (prefix[mid] <= target) {

                left = mid + 1;

            } else {

                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        // Test Case 1

        int[] arr1 = {1, 4, 6};

        int l1 = 3;
        int r1 = 8;

        System.out.println(
                "Input: [1, 4, 6]"
        );

        System.out.println(
                "Range: [3, 8]"
        );

        System.out.println(
                "Number of valid subarrays: "
                        + countSubarray(
                                arr1,
                                l1,
                                r1
                        )
        );

        // Expected: 3

        System.out.println();


        // Test Case 2

        int[] arr2 = {2, 3, 5, 8};

        int l2 = 4;
        int r2 = 13;

        System.out.println(
                "Input: [2, 3, 5, 8]"
        );

        System.out.println(
                "Range: [4, 13]"
        );

        System.out.println(
                "Number of valid subarrays: "
                        + countSubarray(
                                arr2,
                                l2,
                                r2
                        )
        );

        // Expected: 6
    }
}


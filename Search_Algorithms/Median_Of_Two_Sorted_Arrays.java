
/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2,
return the median of the combined sorted arrays.

The required time complexity is:

O(log(m + n))


Examples:

Input:
nums1 = [1, 3]
nums2 = [2]

Output:
2.0


Input:
nums1 = [1, 2]
nums2 = [3, 4]

Output:
2.5
*/

public class Median_Of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(
            int[] nums1,
            int[] nums2
    ) {

        
        if (nums1.length > nums2.length) {

            return findMedianSortedArrays(
                    nums2,
                    nums1
            );
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        
        int leftPartitionSize =
                (m + n + 1) / 2;

        
        while (left <= right) {

            
            int partition1 =
                    left + (right - left) / 2;

           
            int partition2 =
                    leftPartitionSize
                    - partition1;

            
            int maxLeft1 =
                    partition1 == 0
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int minRight1 =
                    partition1 == m
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int maxLeft2 =
                    partition2 == 0
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int minRight2 =
                    partition2 == n
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            
            if (maxLeft1 <= minRight2
                    && maxLeft2 <= minRight1) {

                
                if ((m + n) % 2 == 1) {

                    return Math.max(
                            maxLeft1,
                            maxLeft2
                    );
                }

                
                int leftMaximum =
                        Math.max(
                                maxLeft1,
                                maxLeft2
                        );

                int rightMinimum =
                        Math.min(
                                minRight1,
                                minRight2
                        );

                return (
                        (double) leftMaximum
                        + rightMinimum
                ) / 2;
            }

            
            else if (maxLeft1 > minRight2) {

                right = partition1 - 1;
            }

            
            else {

                left = partition1 + 1;
            }
        }

        
        return 0.0;
    }

    public static void main(String[] args) {

        Median_Of_Two_Sorted_Arrays solver =
                new Median_Of_Two_Sorted_Arrays();

        // Test Case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(
                "nums1: [1, 3]"
        );

        System.out.println(
                "nums2: [2]"
        );

        System.out.println(
                "Median: "
                        + solver.findMedianSortedArrays(
                                nums1,
                                nums2
                        )
        );
        // Expected: 2.0

        System.out.println();

        // Test Case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        System.out.println(
                "nums1: [1, 2]"
        );

        System.out.println(
                "nums2: [3, 4]"
        );

        System.out.println(
                "Median: "
                        + solver.findMedianSortedArrays(
                                nums3,
                                nums4
                        )
        );
        // Expected: 2.5
    }
}


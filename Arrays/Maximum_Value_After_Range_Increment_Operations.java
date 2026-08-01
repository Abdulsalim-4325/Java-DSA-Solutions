
/*
Maximum Value After Range Increment Operations

Given three arrays a[], b[], and k[], perform range increment
operations on an array arr[] of size n.

Initially:

arr = [0, 0, 0, ..., 0]

For every operation i:

Increment(a[i], b[i], k[i])

Add k[i] to every element from index a[i] to index b[i],
inclusive.

Return the maximum value in the array after all operations.

Examples:

Input:
n = 5

a = [0, 1, 2]
b = [1, 4, 3]
k = [100, 100, 100]

Output:
200


Input:
n = 4

a = [1, 0, 3]
b = [2, 0, 3]
k = [603, 286, 882]

Output:
882
*/

public class Maximum_Value_After_Range_Increment_Operations {

    public int findMax(
            int n,
            int[] a,
            int[] b,
            int[] k
    ) {

        
        int[] difference = new int[n + 1];

       
        for (int i = 0; i < a.length; i++) {

            
            difference[a[i]] += k[i];

            if (b[i] + 1 < n) {
                difference[b[i] + 1] -= k[i];
            }
        }

        int currentValue = 0;
        int maximumValue = 0;

        
        for (int i = 0; i < n; i++) {

            currentValue += difference[i];

            maximumValue = Math.max(
                    maximumValue,
                    currentValue
            );
        }

        return maximumValue;
    }

    public static void main(String[] args) {

        Maximum_Value_After_Range_Increment_Operations solver =
                new Maximum_Value_After_Range_Increment_Operations();

        // Test Case 1
        int n1 = 5;

        int[] a1 = {0, 1, 2};
        int[] b1 = {1, 4, 3};
        int[] k1 = {100, 100, 100};

        System.out.println("Test Case 1");

        System.out.println(
                "Maximum value: "
                        + solver.findMax(
                                n1,
                                a1,
                                b1,
                                k1
                        )
        );
        // Expected: 200

        System.out.println();

        // Test Case 2
        int n2 = 4;

        int[] a2 = {1, 0, 3};
        int[] b2 = {2, 0, 3};
        int[] k2 = {603, 286, 882};

        System.out.println("Test Case 2");

        System.out.println(
                "Maximum value: "
                        + solver.findMax(
                                n2,
                                a2,
                                b2,
                                k2
                        )
        );
        // Expected: 882
    }
}


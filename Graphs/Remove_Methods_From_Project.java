
/*
3310. Remove Methods From Project

You are maintaining a project with n methods numbered
from 0 to n - 1.

invocations[i] = [a, b] means that method a invokes
method b.

Method k contains a known bug.

Method k and every method that is directly or indirectly
invoked by method k are considered suspicious.

The suspicious methods can be removed only if no
non-suspicious method invokes a suspicious method.

If any non-suspicious method invokes a suspicious method,
none of the methods can be removed.

Return all remaining methods.


Example 1:

n = 4
k = 1

invocations = [
    [1, 2],
    [0, 1],
    [3, 2]
]

Output:
[0, 1, 2, 3]


Example 2:

n = 5
k = 0

invocations = [
    [1, 2],
    [0, 2],
    [0, 1],
    [3, 4]
]

Output:
[3, 4]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Remove_Methods_From_Project {

    public static List<Integer> remainingMethods(
            int n,
            int k,
            int[][] invocations
    ) {

        
        List<List<Integer>> graph =
                new ArrayList<>();

        for (int method = 0;
             method < n;
             method++) {

            graph.add(new ArrayList<>());
        }

        
        for (int[] invocation : invocations) {

            int caller = invocation[0];
            int calledMethod = invocation[1];

            graph.get(caller)
                    .add(calledMethod);
        }

        
        boolean[] suspicious =
                new boolean[n];

        
        Queue<Integer> queue =
                new ArrayDeque<>();

        suspicious[k] = true;
        queue.offer(k);

        while (!queue.isEmpty()) {

            int currentMethod =
                    queue.poll();

            
            for (int invokedMethod
                    : graph.get(currentMethod)) {

                if (!suspicious[invokedMethod]) {

                    suspicious[invokedMethod] =
                            true;

                    queue.offer(
                            invokedMethod
                    );
                }
            }
        }

        
        for (int[] invocation : invocations) {

            int caller = invocation[0];

            int calledMethod =
                    invocation[1];

            if (!suspicious[caller]
                    && suspicious[calledMethod]) {

                
                List<Integer> allMethods =
                        new ArrayList<>();

                for (int method = 0;
                     method < n;
                     method++) {

                    allMethods.add(method);
                }

                return allMethods;
            }
        }

       
        List<Integer> remainingMethods =
                new ArrayList<>();

        for (int method = 0;
             method < n;
             method++) {

            if (!suspicious[method]) {

                remainingMethods.add(
                        method
                );
            }
        }

        return remainingMethods;
    }

    public static void main(String[] args) {

        /*
         * Test Case 1
         */
        int n1 = 4;

        int k1 = 1;

        int[][] invocations1 = {
                {1, 2},
                {0, 1},
                {3, 2}
        };

        System.out.println(
                "Test Case 1:"
        );

        System.out.println(
                remainingMethods(
                        n1,
                        k1,
                        invocations1
                )
        );

        // Expected: [0, 1, 2, 3]

        System.out.println();


        /*
         * Test Case 2
         */
        int n2 = 5;

        int k2 = 0;

        int[][] invocations2 = {
                {1, 2},
                {0, 2},
                {0, 1},
                {3, 4}
        };

        System.out.println(
                "Test Case 2:"
        );

        System.out.println(
                remainingMethods(
                        n2,
                        k2,
                        invocations2
                )
        );

        // Expected: [3, 4]

        System.out.println();


        /*
         * Test Case 3
         */
        int n3 = 3;

        int k3 = 2;

        int[][] invocations3 = {
                {1, 2},
                {0, 1},
                {2, 0}
        };

        System.out.println(
                "Test Case 3:"
        );

        System.out.println(
                remainingMethods(
                        n3,
                        k3,
                        invocations3
                )
        );

        // Expected: []
    }
}


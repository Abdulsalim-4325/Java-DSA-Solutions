/*
Subset Sum on Generated Sequence

There are n children standing in a queue, each assigned a number arr[i].
The teacher writes s on a paper and gives it to the first child.

Each child writes the sum of all numbers already on the paper and arr[i],
then passes it to the next child.

Return true if x can be formed by adding some of the numbers written on
the paper. Otherwise return false.

Example 1:

Input:
arr[] = [1, 2, 4, 2]
s = 1
x = 7

Output:
true

Explanation:
The first student gets 1 on paper and writes 2.
The second student gets [1, 2] and writes 5.
The third student gets [1, 2, 5] and writes 12.
The fourth student gets [1, 2, 5, 12] and writes 22.

The final sequence is:
1, 2, 5, 12, 22

Using 2 and 5, we can form 7.

Example 2:

Input:
arr[] = [51, 88]
s = 100
x = 500

Output:
false

Explanation:
The final sequence is:
100, 151, 339

Using these numbers we cannot form 500.

Constraints:

1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^9
1 <= s <= 10^9
0 <= x <= 10^9
*/

import java.util.*;

public class Subset_Sum_On_Generated_Sequence {

    public static boolean isPossible(int[] arr, int s, int x) {
        long[] sequence = new long[arr.length + 1];

        sequence[0] = s;

        long sum = s;

        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];

            sequence[i + 1] = next;
            sum += next;
        }

        long target = x;

        for (int i = sequence.length - 1; i >= 0; i--) {
            if (sequence[i] <= target) {
                target -= sequence[i];
            }

            if (target == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int s = sc.nextInt();
        int x = sc.nextInt();

        System.out.println(isPossible(arr, s, x));

        sc.close();
    }
}
/*Given an array arr[]. Initially, you have another array containing only 0s.
In one operation, you may either:

Choose any one element and increase its value by 1, or
Double the values of all elements in the array simultaneously.
Find the minimum number of operations required to transform the initial all-zero array into the given array arr[].

Examples:

Input: arr[] = [16, 16, 16]
Output: 7
Explanation: 
First, increase each element to make the array [1, 1, 1] (3 steps).
Then, multiply the whole array by 2 four times:
[1,1,1] -> [2,2,2] -> [4,4,4] -> [8,8,8] -> [16,16,16]
Total steps = 3 + 4 = 7.
Input: arr[] = [2, 3]
Output: 4
Explanation: 
Start from [0, 0].
Increase both elements to get [1, 1] (2 steps)
Multiply once: [2, 2] (1 step)
Increase second element once: [2, 3] (1 step)
Total steps = 2 + 1 + 1 = 4.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 109*/



public class Minimum_Increment_Or_Double_Operations_To_Convert {

    public static int countMinOperations(int[] arr) {

        int increments = 0;
        int doubles = 0;

        for (int num : arr) {

            int bits = 0;

            while (num > 0) {

                if ((num & 1) == 1) {
                    increments++;
                }

                num >>= 1;

                if (num > 0) {
                    bits++;
                }
            }

            doubles = Math.max(doubles, bits);
        }

        return increments + doubles;
    }

    public static void main(String[] args) {

        int[] arr1 = {16, 16, 16};
        System.out.println("Output: " + countMinOperations(arr1));
        // Expected: 7

        int[] arr2 = {2, 3};
        System.out.println("Output: " + countMinOperations(arr2));
        // Expected: 4
    }
}
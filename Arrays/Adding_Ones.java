/*
 * Problem: Adding Ones (GeeksforGeeks - Easy)
 *
 * Consider an array arr[] of size n, initially containing all zeros. 
 * For each value j in updates[], add 1 to every element arr[i] whose index satisfies i >= j.
 * 
 * Approach:
 * Use a difference array (prefix sum) technique. Increment the start index by 1.
 * Then, compute the prefix sum to propagate the additions to the end of the array.
 *
 * Time Complexity: O(N + K)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;

public class Adding_Ones {

    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];
        
        for (int i = 0; i < updates.length; i++) {
            arr[updates[i] - 1]++;
        }
        
        ArrayList<Integer> result = new ArrayList<>(n);
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            result.add(currentSum);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Adding_Ones solution = new Adding_Ones();

        int n1 = 3;
        int[] updates1 = {1, 1, 2, 3};
        System.out.println(solution.update(n1, updates1)); // [2, 3, 4]

        int n2 = 2;
        int[] updates2 = {1, 1, 1};
        System.out.println(solution.update(n2, updates2)); // [3, 3]
    }
}
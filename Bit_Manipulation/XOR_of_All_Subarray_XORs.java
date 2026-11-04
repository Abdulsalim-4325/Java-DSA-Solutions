/*
 * Problem: XOR of All Subarray XORs (GeeksforGeeks - Medium)
 * 
 * Given an integer array arr[], find the XOR of the XOR values of all 
 * possible non-empty subarrays of the array.
 * 
 * Examples:
 * Input: arr[] = [1, 2, 3] 
 * Output: 2
 * Explanation:
 * xor[1] = 1, xor[1, 2] = 3, xor[2, 3] = 1, xor[1, 2, 3] = 0, xor[2] = 2, xor[3] = 3
 * Result: 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2
 * 
 * Input: arr[] = [1, 2]
 * Output: 0
 * Explanation:
 * xor[1] = 1, xor[1, 2] = 3, xor[2] = 2
 * Result: 1 ^ 3 ^ 2 = 0
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 0 <= arr[i] <= 10^9
 * 
 * Approach:
 * Using combinatorics and XOR properties. The frequency of arr[i] across all subarrays 
 * is (i + 1) * (N - i). If N is even, this frequency is always even, yielding a total 
 * XOR of 0. If N is odd, this frequency is odd strictly for even indices (i = 0, 2, 4...), 
 * so we return the XOR sum of elements exclusively at those indices.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class XOR_of_All_Subarray_XORs {

    public int subarrayXor(int[] arr) {
        int n = arr.length;
        
        if (n % 2 == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res ^= arr[i];
        }
        
        return res;
    }

    public static void main(String[] args) {
        XOR_of_All_Subarray_XORs solution = new XOR_of_All_Subarray_XORs();

        // Example 1
        int[] arr1 = {1, 2, 3};
        System.out.println(solution.subarrayXor(arr1)); // Expected: 2

        // Example 2
        int[] arr2 = {1, 2};
        System.out.println(solution.subarrayXor(arr2)); // Expected: 0
        
        // Example 3
        int[] arr3 = {5, 6, 7, 8, 9};
        System.out.println(solution.subarrayXor(arr3)); // Expected: 3 (5 ^ 7 ^ 9)
    }
}
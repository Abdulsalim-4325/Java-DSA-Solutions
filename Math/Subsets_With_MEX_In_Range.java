/*
 * Problem: Subsets with MEX in Range (GeeksforGeeks - Hard)
 * 
 * Given an array arr[] of integers and a range [l, r], count the number of 
 * subsets whose Minimum Excluded (MEX) value lies within the given range, inclusive.
 * Minimum Excluded (or MEX) of a subset is the smallest non-negative integer 
 * that is not present in the subset.
 * 
 * Examples:
 * Input: arr[] = [2, 0, 1, 0], l = 1, r = 2
 * Output: 9
 * Explanation: 
 * MEX = 1: [0], [2, 0], [0, 0], [2, 0, 0] -> 6 subsets
 * MEX = 2: [0, 1], [0, 1, 0] -> 3 subsets
 * Total valid subsets = 9.
 * 
 * Constraints:
 * 2 <= arr.size() <= 10^5
 * 0 <= arr[i], r <= arr.size()
 * 0 <= l <= r
 * 
 * Approach:
 * Use combinatorial mathematics. To achieve a MEX of exactly 'x':
 * - We must include at least one instance of every number from 0 to x-1.
 * - We must exclude all instances of x.
 * - We can freely include or exclude any other remaining elements.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Subsets_With_MEX_In_Range {

    public int cntSubsets(int arr[], int l, int r) {
        int MOD = 1000000007;
        int n = arr.length;
        
        long[] power2 = new long[n + 1];
        power2[0] = 1;
        for (int i = 1; i <= n; i++) {
            power2[i] = (power2[i - 1] * 2) % MOD;
        }
        
        int[] f = new int[n + 2];
        for (int num : arr) {
            if (num <= n + 1) {
                f[num]++;
            }
        }
        
        long prefixWays = 1;
        int elementsUsed = 0;
        long totalWays = 0;
        
        for (int x = 0; x <= r; x++) {
            if (x >= l) {
                int suffixCount = n - elementsUsed - f[x];
                if (suffixCount < 0) suffixCount = 0; 
                
                long currentWays = (prefixWays * power2[suffixCount]) % MOD;
                totalWays = (totalWays + currentWays) % MOD;
            }
            
            long waysToPickX = (power2[f[x]] - 1 + MOD) % MOD;
            prefixWays = (prefixWays * waysToPickX) % MOD;
            
            if (prefixWays == 0) {
                break;
            }
            
            elementsUsed += f[x];
        }
        
        return (int) totalWays;
    }

    public static void main(String[] args) {
        Subsets_With_MEX_In_Range solution = new Subsets_With_MEX_In_Range();

        int[] arr1 = {2, 0, 1, 0};
        System.out.println(solution.cntSubsets(arr1, 1, 2)); // Expected: 9

        int[] arr2 = {2, 0, 1};
        System.out.println(solution.cntSubsets(arr2, 1, 2)); // Expected: 3
    }
}
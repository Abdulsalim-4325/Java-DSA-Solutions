/*
 * Range GCD Queries
 * Difficulty: Medium | Accuracy: 63.37% | Submissions: 11K+ | Points: 4
 * 
 * Given an integer array arr[] and a 2D array queries[][] containing q queries, 
 * where each query is one of the following two types:
 * Type 0: [0, l, r] -> Return the GCD of all elements in the range [l, r] (both inclusive).
 * Type 1: [1, index, value] -> Update arr[index] to value.
 * 
 * Return an array containing the answers to all Type 0 queries in the order they appear.
 * 
 * Examples:
 * Input: arr[] = [2, 3, 4, 6, 8, 16], queries[][] = [[0, 0, 2], [1, 3, 8], [0, 2, 5]]
 * Output: [1, 4]
 * Explanation: 
 * Query [0, 0, 2]: GCD of [2, 3, 4] is 1.
 * Query [1, 3, 8]: Update arr[3] to 8. Array becomes [2, 3, 4, 8, 8, 16].
 * Query [0, 2, 5]: GCD of [4, 8, 8, 16] is 4.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= q <= 10^5
 * 0 <= l, r, index <= arr.size()-1
 * 1 <= arr[i], value <= 10^5
 */

import java.util.ArrayList;

public class Range_GCD_Queries {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {2, 3, 4, 6, 8, 16};
        int[][] queries1 = {
            {0, 0, 2}, 
            {1, 3, 8}, 
            {0, 2, 5}
        };
        System.out.println("Test Case 1: " + solver.processQueries(arr1, queries1)); 
        // Expected: [1, 4]

        int[] arr2 = {12, 18, 24, 30, 36};
        int[][] queries2 = {
            {0, 1, 3}, 
            {1, 2, 15}, 
            {0, 0, 2}, 
            {0, 2, 4}
        };
        System.out.println("Test Case 2: " + solver.processQueries(arr2, queries2)); 
        // Expected: [6, 3, 3]
    }
}

class Solution {
    private int[] tree;

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        build(leftChild, start, mid, arr);
        build(rightChild, mid + 1, end, arr);
        
        tree[node] = gcd(tree[leftChild], tree[rightChild]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        if (idx <= mid) {
            update(leftChild, start, mid, idx, val);
        } else {
            update(rightChild, mid + 1, end, idx, val);
        }
        
        tree[node] = gcd(tree[leftChild], tree[rightChild]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            return 0; 
        }
        
        if (l <= start && end <= r) {
            return tree[node];
        }
        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        int leftGcd = query(leftChild, start, mid, l, r);
        int rightGcd = query(rightChild, mid + 1, end, l, r);
        
        return gcd(leftGcd, rightGcd);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        tree = new int[4 * n]; 
        
        build(0, 0, n - 1, arr);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            if (q[0] == 0) {
                result.add(query(0, 0, n - 1, q[1], q[2]));
            } else if (q[0] == 1) {
                update(0, 0, n - 1, q[1], q[2]);
            }
        }
        
        return result;
    }
}
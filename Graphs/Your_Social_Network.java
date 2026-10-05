/*
 * Your Social Network
 * Difficulty: Medium | Accuracy: 68.37% | Submissions: 8K+ | Points: 4
 * 
 * Geek is creating a social networking site called Geeksbook with n users 
 * numbered from 1 to n. Each user i (2 <= i <= n) has exactly one friend, 
 * and that friend must have a smaller user number than i. User 1 has no friend.
 * 
 * The relationship is one-way. A user can reach another user by repeatedly 
 * following their friend's link. For every user i from 2 to n, find all users 
 * j (1 <= j < i) that can be reached from i.
 * 
 * Create an array [i, j, k] where:
 * - i is the starting user.
 * - j is the reachable user.
 * - k is the number of links that must be followed to reach j from i.
 * 
 * Return a 2D array containing information about all reachable pairs sorted 
 * by i ascending, then by j ascending.
 * 
 * Constraints:
 * 2 <= arr.size() <= 500
 * 1 <= arr[i] <= 500
 */

import java.util.ArrayList;
import java.util.Collections;

public class Your_Social_Network {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] arr1 = {1, 2};
        System.out.println("Test Case 1: " + solver.socialNetwork(arr1)); 
        // Expected: [[2, 1, 1], [3, 1, 2], [3, 2, 1]]

        // Test Case 2
        int[] arr2 = {1, 1};
        System.out.println("Test Case 2: " + solver.socialNetwork(arr2)); 
        // Expected: [[2, 1, 1], [3, 1, 1]]
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length + 1;
        
        for (int i = 2; i <= n; i++) {
            ArrayList<int[]> reachable = new ArrayList<>();
            int curr = i;
            int dist = 0;
            
            while (curr >= 2) {
                curr = arr[curr - 2];
                dist++;
                reachable.add(new int[]{curr, dist});
            }
            
            Collections.sort(reachable, (a, b) -> Integer.compare(a[0], b[0]));
            
            for (int[] pair : reachable) {
                ArrayList<Integer> row = new ArrayList<>();
                row.add(i);
                row.add(pair[0]);
                row.add(pair[1]);
                result.add(row);
            }
        }
        
        return result;
    }
}
/*
 * Problem: Count Indices That Escape Array (GeeksforGeeks - Medium)
 * 
 * Given an array arr[], where arr[i] represents the exact number of steps to 
 * move from index i. An index is considered good if repeatedly following the 
 * jumps eventually takes you outside the array. Otherwise, if the jumps result 
 * in an infinite loop, the index is considered bad.
 * 
 * - A positive value indicates a move to the right.
 * - A negative value indicates a move to the left.
 * - A 0 value means no move and considered bad.
 * 
 * Return the number of good indices.
 * 
 * Examples:
 * Input: [2, 3, -1, 2, -2, 4, 1]
 * Output: 3
 * Explanation: Indices 3, 5, and 6 are good because their jump sequences 
 * eventually leave the array. Indices 1, 2, and 4 form a cycle, while index 0 
 * eventually enters this cycle through index 2. Hence, the total number of good 
 * indices is 3. 
 * 
 * Input: [1, 0, -3, 0, -5, 0]
 * Output: 2
 * Explanation: Indices 2 and 4 are good because their jumps take them outside 
 * the array. Indices 1, 3, and 5 are bad because their jumps are zero. Index 0 
 * is also bad because it jumps to index 1, which is a dead end. Hence, the total 
 * number of good indices is 2.  
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * -10^5 <= arr[i] <= 10^5
 * 
 * Approach:
 * Directed graph cycle detection using graph coloring (states). An iterative DFS 
 * tracks paths to prevent StackOverflow limits while caching results to achieve 
 * O(N) time complexity.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java.util.ArrayList;
import java.util.List;

public class Count_Indices_That_Escape_Array {

    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n]; 
        int goodCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                int curr = i;
                List<Integer> path = new ArrayList<>();
                boolean escapes = false;
                
                while (true) {
                    if (curr < 0 || curr >= n) {
                        escapes = true;
                        break;
                    }
                    if (state[curr] == 1) {
                        escapes = false;
                        break;
                    }
                    if (state[curr] == 2) {
                        escapes = true;
                        break;
                    }
                    if (state[curr] == 3) {
                        escapes = false;
                        break;
                    }
                    
                    state[curr] = 1;
                    path.add(curr);
                    curr = curr + arr[curr];
                }
                
                int finalState = escapes ? 2 : 3;
                for (int node : path) {
                    state[node] = finalState;
                }
            }
            
            if (state[i] == 2) {
                goodCount++;
            }
        }
        
        return goodCount;
    }

    public static void main(String[] args) {
        Count_Indices_That_Escape_Array solution = new Count_Indices_That_Escape_Array();

        System.out.println(solution.goodIndices(new int[]{2, 3, -1, 2, -2, 4, 1})); // Expected: 3
        System.out.println(solution.goodIndices(new int[]{1, 0, -3, 0, -5, 0}));    // Expected: 2
    }
}
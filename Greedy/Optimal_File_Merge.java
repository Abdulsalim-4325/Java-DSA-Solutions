/*
 * Problem: Optimal File Merge (GeeksforGeeks - Medium)
 * 
 * Given an integer array files[], where files[i] represents the size of the 
 * i-th file, merge all the files into a single file with the minimum total 
 * computation cost.
 * The cost of merging two files of sizes x and y is x + y. After merging, 
 * a new file of size x + y is created, which can be merged further.
 * 
 * Examples:
 * Input: files[] = [3, 2, 4]
 * Output: 14
 * Explanation: 
 * Merge 2 and 3 (Cost = 5). Array becomes [5, 4].
 * Merge 4 and 5 (Cost = 9). Array becomes [9].
 * Total Cost = 5 + 9 = 14.
 * 
 * Constraints:
 * 1 <= files.size() <= 10^5
 * 1 <= files[i] <= 10^3
 * 
 * Approach:
 * Greedy strategy using a Min-Heap (Priority Queue). Continuously pop the two 
 * smallest files, merge them, add their cost to the total, and push the newly 
 * merged file back into the heap until one file remains.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */

import java.util.PriorityQueue;

public class Optimal_File_Merge {

    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int file : files) {
            pq.offer(file);
        }
        
        int totalCost = 0;
        
        while (pq.size() > 1) {
            int file1 = pq.poll();
            int file2 = pq.poll();
            
            int mergedSize = file1 + file2;
            totalCost += mergedSize;
            
            pq.offer(mergedSize);
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        Optimal_File_Merge solution = new Optimal_File_Merge();

        int[] files1 = {3, 2, 4};
        System.out.println(solution.minComputation(files1)); // Expected: 14

        int[] files2 = {2, 3, 6, 5, 7, 4};
        System.out.println(solution.minComputation(files2)); // Expected: 68
    }
}
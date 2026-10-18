/*
 * Problem: Shortest Path From 1 To n (GeeksforGeeks - Easy)
 * 
 * Consider a directed graph whose vertices are numbered from 1 to n. There is an 
 * edge from a vertex i to a vertex j if and only if either j = i + 1 or j = 3 * i. 
 * The task is to find the minimum number of edges in a path from vertex 1 to vertex n.
 * 
 * Examples:
 * Input: n = 4
 * Output: 2
 * Explanation: Possible paths from 1 to 4 are, 1 -> 2 -> 3 -> 4 and 1 -> 3 -> 4. 
 * Second path of length 2 is the shortest.
 * 
 * Input: n = 9
 * Output: 2
 * Explanation: Many paths are possible from 1 to 9. Shortest one possible is, 
 * 1 -> 3 -> 9, of length 2.
 * 
 * Input: n = 15
 * Output: 4
 * Explanation: Many paths are possible from 1 to 15. Shortest one possible is, 
 * 1 -> 3 -> 4 -> 5 -> 15, of length 4.
 * 
 * Constraints:
 * 1 <= n <= 10^8
 * 
 * Approach:
 * Greedy reverse logic. Start from n and reduce to 1. If n is divisible by 3, divide 
 * by 3. Otherwise, subtract 1. Count the steps.
 * 
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */

public class Shortest_Path_From_1_To_n {

    public int minimumStep(int n) {
        int steps = 0;
        
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n -= 1;
            }
            steps++;
        }
        
        return steps;
    }

    public static void main(String[] args) {
        Shortest_Path_From_1_To_n solution = new Shortest_Path_From_1_To_n();

        System.out.println(solution.minimumStep(4));  // Expected: 2
        System.out.println(solution.minimumStep(9));  // Expected: 2
        System.out.println(solution.minimumStep(15)); // Expected: 4
    }
}
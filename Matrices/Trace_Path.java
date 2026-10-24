/*
 * Problem: Trace Path (GeeksforGeeks - Easy)
 * 
 * Given a rectangular grid with n rows and m columns, and a string s representing 
 * a sequence of movement commands. Geek can start from any cell of the grid and 
 * follows all the commands in s in the same order.
 * The string s consists only of the characters L, R, D, and U, where:
 * - L: Move one cell left, from (i, j) to (i, j - 1).
 * - R: Move one cell right, from (i, j) to (i, j + 1).
 * - D: Move one cell up, from (i, j) to (i - 1, j).
 * - U: Move one cell down, from (i, j) to (i + 1, j).
 * 
 * Determine whether there exists at least one starting cell such that Geek 
 * remains within the grid while following all the commands in s.
 * 
 * Examples:
 * Input: n = 1, m = 1, s = "R"
 * Output: false
 * Explanation: There is only one cell(1, 1). On taking right(R) Geek moves to 
 * (1, 2), which is out of grid.
 * 
 * Input: n = 2, m = 3, s = "LLRU"
 * Output: true
 * Explanation: One possible cell is (1, 3). (1, 3) -> (1, 2) -> (1, 1) -> (1, 2) -> (2, 2).
 * 
 * Constraints:
 * 1 <= n, m, s.size() <= 10^4
 * s consists only of the characters L R D and U.
 * 
 * Approach:
 * Simulate the path relative to an arbitrary origin (0,0). Maintain the minimum and 
 * maximum span in both the X and Y axes. If the total height or width of this 
 * traced bounding box ever exceeds n or m respectively, the path cannot fit.
 * 
 * Time Complexity: O(|S|)
 * Space Complexity: O(1)
 */

public class Trace_Path {

    public boolean isPossible(int n, int m, String s) {
        int x = 0, y = 0;
        int minX = 0, maxX = 0;
        int minY = 0, maxY = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                y--;
            } else if (c == 'R') {
                y++;
            } else if (c == 'D') {
                x--;
            } else if (c == 'U') {
                x++;
            }
            
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
            
            if (maxX - minX + 1 > n || maxY - minY + 1 > m) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Trace_Path solution = new Trace_Path();

        System.out.println(solution.isPossible(1, 1, "R")); // Expected: false
        System.out.println(solution.isPossible(2, 3, "LLRU")); // Expected: true
    }
}
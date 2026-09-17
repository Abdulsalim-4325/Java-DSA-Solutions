/*
 * Word in Grid - All Occurrences
 * Difficulty: Medium | Accuracy: 22.88% | Submissions: 93K+ | Points: 4
 * 
 * Given a 2D grid mat[][] of size n x m consisting of characters and a string word, 
 * find all starting positions where the word occurs in the grid.
 * The word can be formed from any cell by moving in any of the 8 directions 
 * (2 horizontal, 2 vertical, and 4 diagonal) in a straight line without changing direction.
 * Each cell can be used at most once per occurrence.
 * Return all unique starting coordinates in lexicographically smallest order.
 * 
 * Examples :
 * Input: mat[][] = {{'a','b','a','b'},{'a','b','e','b'},{'e','b','e','b'}}, word = "abe"
 * Output: {{0,0}, {0,2}, {1,0}}
 * Explanation: 
 * From (0,0) we can find "abe" in right-down diagonal. 
 * From (0,2) we can find "abe" in left-down diagonal. 
 * From (1,0) we can find "abe" in horizontally right direction.
 * 
 * Constraints:
 * 1 <= n <= m <= 50
 * 1 <= |word| <= 20
 */

import java.util.ArrayList;

public class Word_in_Grid_All_Occurrences {
    public static void main(String[] args) {
        Solution solver = new Solution();

        char[][] mat1 = {
            {'a', 'b', 'a', 'b'},
            {'a', 'b', 'e', 'b'},
            {'e', 'b', 'e', 'b'}
        };
        System.out.println("Test Case 1: " + solver.searchWord(mat1, "abe")); 
        // Expected: [[0, 0], [0, 2], [1, 0]]

        char[][] mat2 = {
            {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
            {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
            {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        };
        System.out.println("Test Case 2: " + solver.searchWord(mat2, "GEEKS")); 
        // Expected: [[0, 0], [0, 8], [1, 0]]
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean found = false;
                    
                    for (int k = 0; k < 8; k++) {
                        int r = i;
                        int c = j;
                        int step;
                        
                        for (step = 1; step < len; step++) {
                            r += dr[k];
                            c += dc[k];
                            
                            if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] != word.charAt(step)) {
                                break;
                            }
                        }
                        
                        if (step == len) {
                            found = true;
                            break;
                        }
                    }
                    
                    if (found) {
                        ArrayList<Integer> coord = new ArrayList<>();
                        coord.add(i);
                        coord.add(j);
                        result.add(coord);
                    }
                }
            }
        }
        
        return result;
    }
}
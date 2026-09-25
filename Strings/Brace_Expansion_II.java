/*
 * LeetCode 1096. Brace Expansion II
 * Hard
 * 
 * Under a specific grammar, strings can represent a set of lowercase words.
 * R(expr) denotes the set of words the expression represents:
 * 1. Single letters represent a singleton set. R("a") = {"a"}
 * 2. Comma-delimited list takes the union. R("{a,b,c}") = {"a","b","c"}
 * 3. Concatenation takes the cartesian product. R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
 * 
 * Given an expression representing a set of words under the given grammar, 
 * return the sorted list of words that the expression represents.
 * 
 * Example 1:
 * Input: expression = "{a,b}{c,{d,e}}"
 * Output: ["ac","ad","ae","bc","bd","be"]
 * 
 * Example 2:
 * Input: expression = "{{a,z},a{b,c},{ab,z}}"
 * Output: ["a","ab","ac","z"]
 * 
 * Constraints:
 * 1 <= expression.length <= 60
 * expression[i] consists of '{', '}', ',' or lowercase English letters.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Brace_Expansion_II {
    public static void main(String[] args) {
        Solution solver = new Solution();

        String expr1 = "{a,b}{c,{d,e}}";
        System.out.println("Test Case 1: " + solver.braceExpansionII(expr1)); 
        // Expected: [ac, ad, ae, bc, bd, be]

        String expr2 = "{{a,z},a{b,c},{ab,z}}";
        System.out.println("Test Case 2: " + solver.braceExpansionII(expr2)); 
        // Expected: [a, ab, ac, z]
    }
}

class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> result = new TreeSet<>();
        
        queue.offer(expression);
        visited.add(expression);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            int right = curr.indexOf('}');
            if (right == -1) {
                result.add(curr);
                continue;
            }
            
            int left = right;
            while (curr.charAt(left) != '{') {
                left--;
            }
            
            String before = curr.substring(0, left);
            String after = curr.substring(right + 1);
            String[] parts = curr.substring(left + 1, right).split(",");
            
            for (String part : parts) {
                String nextStr = before + part + after;
                if (visited.add(nextStr)) {
                    queue.offer(nextStr);
                }
            }
        }
        
        return new ArrayList<>(result);
    }
}
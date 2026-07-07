/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/


import java.util.Stack;

public class Valid_Parenthesis {
    
    // LeetCode core algorithm logic
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    // Main method to run and execute code locally inside VS Code
    public static void main(String[] args) {
        Valid_Parenthesis solver = new Valid_Parenthesis();

        // Test Case 1
        String test1 = "()";
        System.out.println("Input: s = \"" + test1 + "\"");
        System.out.println("Output: " + solver.isValid(test1)); // Expected: true
        System.out.println();

        // Test Case 2
        String test2 = "()[]{}";
        System.out.println("Input: s = \"" + test2 + "\"");
        System.out.println("Output: " + solver.isValid(test2)); // Expected: true
        System.out.println();

        // Test Case 3
        String test3 = "(]";
        System.out.println("Input: s = \"" + test3 + "\"");
        System.out.println("Output: " + solver.isValid(test3)); // Expected: false
        System.out.println();

        // Test Case 4
        String test4 = "([])";
        System.out.println("Input: s = \"" + test4 + "\"");
        System.out.println("Output: " + solver.isValid(test4)); // Expected: true
    }
}

/*Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.*/


public class Length_Of_Last_Word {
    

    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;


        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }


        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

   
    public static void main(String[] args) {
        Length_Of_Last_Word solver = new Length_Of_Last_Word();

        // Test Case 1: Standard two-word sentence
        String test1 = "Hello World";
        System.out.println("Input: s = \"" + test1 + "\"");
        System.out.println("Output: " + solver.lengthOfLastWord(test1)); // Expected: 5
        System.out.println();

        // Test Case 2: Mixed multi-spacing with trailing spaces
        String test2 = "   fly me   to   the moon  ";
        System.out.println("Input: s = \"" + test2 + "\"");
        System.out.println("Output: " + solver.lengthOfLastWord(test2)); // Expected: 4
        System.out.println();

        // Test Case 3: Sentence with no trailing spaces
        String test3 = "luffy is still joyboy";
        System.out.println("Input: s = \"" + test3 + "\"");
        System.out.println("Output: " + solver.lengthOfLastWord(test3)); // Expected: 6
    }
}

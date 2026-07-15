public class Valid_Palindrome {
    
   
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }

    
    public static void main(String[] args) {
        Valid_Palindrome solver = new Valid_Palindrome();

        // Test Case 1:
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Input: s = \"" + test1 + "\"");
        System.out.println("Output: " + solver.isPalindrome(test1)); // Expected: true
        System.out.println();

        // Test Case 2: 
        String test2 = "race a car";
        System.out.println("Input: s = \"" + test2 + "\"");
        System.out.println("Output: " + solver.isPalindrome(test2)); // Expected: false
        System.out.println();

        // Test Case 3:
        String test3 = " ";
        System.out.println("Input: s = \"" + test3 + "\"");
        System.out.println("Output: " + solver.isPalindrome(test3)); // Expected: true
    }
}

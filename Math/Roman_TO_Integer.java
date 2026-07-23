import java.util.HashMap;
import java.util.Map;

public class Roman_TO_Integer {
    
    
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int total = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int currentVal = romanMap.get(s.charAt(i));
            
            if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                total += currentVal;
            }
        }
        
        return total;
    }

   
    public static void main(String[] args) {
        Roman_TO_Integer solver = new Roman_TO_Integer();

        // Test Case 1
        String test1 = "III";
        System.out.println("Input: s = \"" + test1 + "\"");
        System.out.println("Output: " + solver.romanToInt(test1)); // Expected: 3
        System.out.println();

        // Test Case 2
        String test2 = "LVIII";
        System.out.println("Input: s = \"" + test2 + "\"");
        System.out.println("Output: " + solver.romanToInt(test2)); // Expected: 58
        System.out.println();

        // Test Case 3
        String test3 = "MCMXCIV";
        System.out.println("Input: s = \"" + test3 + "\"");
        System.out.println("Output: " + solver.romanToInt(test3)); // Expected: 1994
    }
}

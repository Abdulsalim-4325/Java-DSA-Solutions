/*
 * Problem: Generate Usernames (GeeksforGeeks - Easy)
 * 
 * Given an array of strings arr[] representing first names of users, generate a 
 * unique username for each entry in the order it appears.
 * - Initially, consider all usernames present in the input array as reserved.
 * - If a username has not already been assigned to any previous user, keep it unchanged.
 * - Otherwise, append the smallest positive integer suffix that produces a username 
 *   that has not been reserved or assigned to any previous user.
 * 
 * Examples:
 * Input: arr[] = ["aba", "ab", "aba", "aba", "ab"]
 * Output: ["aba", "ab", "aba1", "aba2", "ab1"]
 * 
 * Input: arr[] = ["a", "a", "a1", "a"]
 * Output: ["a", "a2", "a1", "a3"]
 * 
 * Constraints:
 * 1 <= |arr| <= 10^3
 * 1 <= |arr[i]| <= 10^2
 * arr consists of English alphabets and digits
 * 
 * Approach:
 * Establish a reserved HashSet to store all initial array elements. 
 * Maintain an assigned HashSet for dynamically generated names and a HashMap 
 * to store suffix pointers preventing redundant sequential checks. 
 * Form combinations checking strictly against both maps resolving valid targets securely.
 * 
 * Time Complexity: O(N * L)
 * Space Complexity: O(N * L)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Generate_Usernames {

    public ArrayList<String> generateUsernames(String[] arr) {
        HashSet<String> reserved = new HashSet<>();
        for (String s : arr) {
            reserved.add(s);
        }
        
        HashSet<String> assigned = new HashSet<>();
        HashMap<String, Integer> suffixCount = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (String base : arr) {
            if (!assigned.contains(base)) {
                assigned.add(base);
                result.add(base);
            } else {
                int count = suffixCount.getOrDefault(base, 1);
                String newName = base + count;
                
                while (reserved.contains(newName) || assigned.contains(newName)) {
                    count++;
                    newName = base + count;
                }
                
                assigned.add(newName);
                suffixCount.put(base, count + 1);
                result.add(newName);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Generate_Usernames solution = new Generate_Usernames();

        // Example 1
        String[] arr1 = {"aba", "ab", "aba", "aba", "ab"};
        System.out.println(solution.generateUsernames(arr1)); 
        // Expected: [aba, ab, aba1, aba2, ab1]

        // Example 2
        String[] arr2 = {"a", "a", "a1", "a"};
        System.out.println(solution.generateUsernames(arr2)); 
        // Expected: [a, a2, a1, a3]

        // Example 3
        String[] arr3 = {"aba1", "aba", "aba"};
        System.out.println(solution.generateUsernames(arr3)); 
        // Expected: [aba1, aba, aba2]
    }
}
/*
Problem: Unoccupied Computers

A cafe has n computers. Each customer is represented by an uppercase
letter occurring exactly twice in the event string:
- First occurrence: arrival
- Second occurrence: departure

A customer receives a computer only if one is currently available.
Return the total number of rejected customers.

Approach:
Use a status array for the 26 uppercase English letters.

status[customer]:
0 -> Not seen yet
1 -> Assigned a computer and currently active
2 -> Rejected due to no available computer

Only an assigned customer releases a computer on departure.

Time Complexity: O(|s|)
Space Complexity: O(1)
*/

public class Unoccupied_Computers {

    public static int solve(int n, String s) {
        int[] status = new int[26];
        int occupied = 0;
        int rejectedCustomers = 0;

        for (char customer : s.toCharArray()) {
            int index = customer - 'A';

            if (status[index] == 0) {
                if (occupied < n) {
                    status[index] = 1;
                    occupied++;
                } else {
                    status[index] = 2;
                    rejectedCustomers++;
                }
            } else if (status[index] == 1) {
                occupied--;
            }
        }

        return rejectedCustomers;
    }

    public static void main(String[] args) {
        System.out.println(solve(3, "GACCBDDBAGEE"));
        // Expected Output: 1

        System.out.println(solve(1, "ABCBAC"));
        // Expected Output: 2
    }
}
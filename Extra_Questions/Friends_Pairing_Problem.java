/*
Given n friends, each one can remain single or can be paired up with some other friend.
Each friend can be paired only once. Find out the total number of ways in which
friends can remain single or can be paired up.

Examples:

Input: n = 3
Output: 4
Explanation:
{1}, {2}, {3}
{1}, {2,3}
{1,2}, {3}
{1,3}, {2}

Input: n = 2
Output: 2
Explanation:
{1}, {2}
{1,2}

Input: n = 1
Output: 1

Constraints:
1 <= n <= 18
*/

public class Friends_Pairing_Problem {

    public int countFriendsPairings(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + (i - 1) * prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Friends_Pairing_Problem solver = new Friends_Pairing_Problem();

        int test1 = 3;
        System.out.println("Input: n = " + test1);
        System.out.println("Output: " + solver.countFriendsPairings(test1));
        System.out.println();

        int test2 = 2;
        System.out.println("Input: n = " + test2);
        System.out.println("Output: " + solver.countFriendsPairings(test2));
        System.out.println();

        int test3 = 1;
        System.out.println("Input: n = " + test3);
        System.out.println("Output: " + solver.countFriendsPairings(test3));
    }
}
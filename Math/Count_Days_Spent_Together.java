/*
 * Problem: 2409. Count Days Spent Together (LeetCode - Easy)
 * 
 * Alice and Bob are traveling to Rome for separate business meetings.
 * You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob. 
 * Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive), 
 * while Bob will be in the city from the dates arriveBob to leaveBob (inclusive). 
 * Each will be a 5-character string in the format "MM-DD".
 * 
 * Return the total number of days that Alice and Bob are in Rome together.
 * 
 * Example 1:
 * Input: arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * Output: 3
 * Explanation: Alice is in Rome Aug 15-18. Bob is in Rome Aug 16-19.
 * They overlap on August 16, 17, and 18 (3 days).
 * 
 * Constraints:
 * All dates are provided in the format "MM-DD".
 * The given dates are valid dates of a non-leap year.
 * 
 * Approach:
 * Map every "MM-DD" string into an integer (Day of the Year, 1 to 365).
 * Find the overlap using interval intersection: Math.max(arrive1, arrive2) 
 * to Math.min(leave1, leave2).
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class Count_Days_Spent_Together {

    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aArrive = dateToDay(arriveAlice);
        int aLeave = dateToDay(leaveAlice);
        int bArrive = dateToDay(arriveBob);
        int bLeave = dateToDay(leaveBob);
        
        int arriveTogether = Math.max(aArrive, bArrive);
        int leaveTogether = Math.min(aLeave, bLeave);
        
        if (arriveTogether <= leaveTogether) {
            return leaveTogether - arriveTogether + 1;
        }
        
        return 0;
    }
    
    private int dateToDay(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += day;
        
        return totalDays;
    }

    public static void main(String[] args) {
        Count_Days_Spent_Together solution = new Count_Days_Spent_Together();

        System.out.println(solution.countDaysTogether("08-15", "08-18", "08-16", "08-19")); // Expected: 3
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31")); // Expected: 0
    }
}
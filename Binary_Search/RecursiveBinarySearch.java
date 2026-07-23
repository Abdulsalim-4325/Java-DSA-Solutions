import java.util.Scanner;

public class RecursiveBinarySearch {
    // Time Complexity: O(log n)
    // Space Complexity: O(log n) due to the call stack
    public static int search(int[] nums, int target, int left, int right) {
        // Base case: target not found
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid; // Target found
        } else if (nums[mid] < target) {
            // Search the right half
            return search(nums, target, mid + 1, right);
        } else {
            // Search the left half
            return search(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements in SORTED order:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target element to search for: ");
        int target = scanner.nextInt();

        // Start the recursion with left = 0 and right = array length - 1
        int result = search(nums, target, 0, nums.length - 1);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }
}
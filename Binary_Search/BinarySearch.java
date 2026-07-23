import java.util.Scanner;

public class BinarySearch {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        
        System.out.println("Enter " + n + " elements in SORTED order:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the target element to search for: ");
        int target = scanner.nextInt();

      
        int result = search(nums, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }
}
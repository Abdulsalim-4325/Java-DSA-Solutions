/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/


// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Merge_Two_Sorted_Lists {
    
    // LeetCode core algorithm logic
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }

    // Main method to run and execute code locally inside VS Code
    public static void main(String[] args) {
        Merge_Two_Sorted_Lists solver = new Merge_Two_Sorted_Lists();

        // Building Test Case 1: list1 =, list2 = [1,3,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        
        System.out.print("Input List 1: ");
        printList(l1);
        System.out.print("Input List 2: ");
        printList(l2);
        
        ListNode result = solver.mergeTwoLists(l1, l2);
        System.out.print("Output: ");
        printList(result); // Expected: [1,1,2,3,4,4]
    }
}

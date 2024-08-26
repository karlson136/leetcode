/*
 * Copyright
 * Andrei Razhkou
 */

package recursion;

/*
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
    
    Example 1:
    
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
    
    Example 2:
    
    Input: head = [], val = 1
    Output: []
    
    Example 3:
    
    Input: head = [7,7,7,7], val = 7
    Output: []
    
    Constraints:
    
        The number of nodes in the list is in the range [0, 104].
        1 <= Node.val <= 50
        0 <= val <= 50
 */
public class RemoveLinkedListElements_203 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,  new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));

        ListNode head = removeElements(list1, 6);
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println();
        list1 = new ListNode(7,  new ListNode(7, new ListNode(7, new ListNode(7, null))));

        head = removeElements(list1, 7);
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        45.34MB
        Beats 62.44% of users with Java
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = head;
        while (res != null && res.val == val) {
            res = res.next;
        }
        if (res == null) {
            return res;
        }
        res.next = removeElements(res.next, val);
        return res;
    }

    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
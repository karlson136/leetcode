/*
 * Copyright
 * Andrei Razhkou
 */

package recursion;


public class SwapNodesInPairs_24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,  new ListNode(2, new ListNode(3, new ListNode(4, null))));
        head = swapPairs(head);
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
        40.97MB
        Beats 79.59% of users with Java
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        head.next = head.next.next;
        tmp.next = head;

        tmp.next.next = swapPairs(tmp.next.next);

        return tmp;
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
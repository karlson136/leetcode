/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    Given the head of a linked list, rotate the list to the right by k places.



    Example 1:

    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Example 2:

    Input: head = [0,1,2], k = 4
    Output: [2,0,1]



    Constraints:

        The number of nodes in the list is in the range [0, 500].
        -100 <= Node.val <= 100
        0 <= k <= 2 * 109
 */
public class RotateList_61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,  new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = rotateRight(head, 2);
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
        42.07MB
        Beats 93.52% of users with Java
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int lenght = 1;
        ListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
            lenght++;
        }
        k %= lenght;

        int start = lenght - k;
        tmp.next = head;
        while(start > 0) {
            tmp = tmp.next;
            start--;
        }
        head = tmp.next;
        tmp.next = null;

        return head;
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
/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    
    You should preserve the original relative order of the nodes in each of the two partitions.
    
    Example 1:
    
    Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]
    
    Example 2:
    
    Input: head = [2,1], x = 2
    Output: [1,2]
    
    Constraints:
    
        The number of nodes in the list is in the range [0, 200].
        -100 <= Node.val <= 100
        -200 <= x <= 200
 */
public class PartitionList_86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,  new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
        head = partition(head, 3);
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println();
        head = new ListNode(2,  new ListNode(1, null));
        head = partition(head, 2);
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
        41.30MB
        Beats 99.54% of users with Java
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessX = null;
        ListNode lessXHead = null;
        ListNode greaterOrEqualsX = null;
        ListNode greaterOrEqualsXHead = null;
        while(head != null) {
            if (head.val < x) {
                if (lessX == null) {
                    lessX = head;
                    lessXHead = head;
                } else {
                    lessX.next = head;
                    lessX = lessX.next;
                }
            } else {
                if (greaterOrEqualsX == null) {
                    greaterOrEqualsX = head;
                    greaterOrEqualsXHead = head;
                } else {
                    greaterOrEqualsX.next = head;
                    greaterOrEqualsX = greaterOrEqualsX.next;
                }
            }
            head = head.next;
        }
        if (greaterOrEqualsX != null) {
            greaterOrEqualsX.next = null;
        }
        if (lessX == null) {
            return greaterOrEqualsXHead;
        }

        lessX.next = greaterOrEqualsXHead;
        return lessXHead;
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
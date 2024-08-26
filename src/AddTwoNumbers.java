/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.ArrayList;
import java.util.List;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//
//        @Override
//        public String toString() {
//            return String.valueOf(val);
//        }
//    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode listNode1 = new ListNode(0);
//        ListNode listNode2 = new ListNode(0);

        ListNode sum = addTwoNumbers(listNode1, listNode2);
        System.out.println();
        while(sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
        }
        System.out.println();
    }

    // first try
    /*
        Runtime
        1ms
        Beats100.00%of users with Java
        Memory
        44.50MB
        Beats20.63%of users with Java
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result;
        int ten = 0;
        List<Integer> digits = new ArrayList<>();
        while(l1 != null || l2 != null || ten == 1) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + ten;
            if (sum > 9) {
                ten = 1;
                sum = sum % 10;
            } else {
                ten = 0;
            }

            digits.add(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        result = new ListNode(digits.get(0));
        add(result, digits, 1);
        return result;
    }

    public static void add(ListNode result, List<Integer> digits, int index) {
        if (digits.size() <= index) {
            return;
        }
        result.next = new ListNode(digits.get(index));
        index = index+1;
        add(result.next, digits, index);
    }


    // second try
    /*
        Runtime
        2ms
        Beats26.80%of users with Java
        Memory
        44.49MB
        Beats20.63%of users with Java
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int ten) {
        if (l1 == null && l2 == null && ten ==0) {
            return null;
        }

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + ten;
        if (sum > 9) {
            ten = 1;
            sum = sum % 10;
        } else {
            ten = 0;
        }

        ListNode digit = new ListNode(sum);

        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }

        ListNode nextdigit = addTwoNumbers(l1, l2, ten);
        if (nextdigit != null) {
            digit.next = nextdigit;
        }
        return digit;
    }
}
/**
 * Created by wang-zhenjun on 8/29/16.
 */

import java.util.*;

//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(0);
        ListNode head = res;

        int c = 0;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + c;
            c = x / 10;
            res.next = new ListNode(x % 10);

            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }

        while (l1 != null) {
            int x = l1.val + c;
            c = x / 10;
            res.next = new ListNode(x % 10);
            res = res.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int x = l2.val + c;
            c = x / 10;
            res.next = new ListNode(x % 10);
            res = res.next;
            l2 = l2.next;
        }

        if (c > 0) {
            res.next = new ListNode(c);
        }

        return head.next;
    }

    public static void main(String args[]) {
        AddTwoNumber s = new AddTwoNumber();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(9);
        ListNode res = s.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; ++i) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }

    public static void printList(ListNode l) {
        while (l != null && l.next != null) {
            System.out.print(l.val + " --> ");
            l = l.next;
        }

        if (l != null) {
            System.out.println(l.val);
        }
    }
}
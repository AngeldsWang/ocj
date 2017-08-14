/**
 * Created by wang-zhenjun on 8/31/16.
 */

import java.util.*;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode left_head = new ListNode(-1);
        ListNode right_head = new ListNode(-1);
        ListNode left_cur = left_head;
        ListNode right_cur = right_head;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                left_cur.next = cur;
                left_cur = left_cur.next;
            } else {
                right_cur.next = cur;
                right_cur = right_cur.next;
            }

            cur = cur.next;
        }

        left_cur.next = right_head.next;
        right_cur.next = null;

        return left_head.next;
    }

    public static void main(String args[]) {
        PartitionList s = new PartitionList();

//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(2);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(2);

        ListNode l1 = ListNode.buildList(new int[] {1, 4, 3, 2, 5, 2});
        ListNode l2 = s.partition(l1, 3);

        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }
}

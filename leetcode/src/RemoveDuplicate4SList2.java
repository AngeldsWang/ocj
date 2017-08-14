/**
 * Created by wang-zhenjun on 9/1/16.
 */

import java.util.*;

public class RemoveDuplicate4SList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pp = dummy;
        ListNode prev = head;
        ListNode cur = head.next;

        boolean flag = false;

        while (cur != null) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
                flag = true;
            } else {

                if (flag) {
                    pp.next = cur;
                    flag = false;
                } else {
                    pp = cur;
                }
                prev = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        RemoveDuplicate4SList2 s = new RemoveDuplicate4SList2();
        ListNode l1 = ListNode.buildList(new int[] {1, 1, 2, 3, 3});
        ListNode l2 = s.deleteDuplicates(l1);
        ListNode.printList(l2);
    }
}

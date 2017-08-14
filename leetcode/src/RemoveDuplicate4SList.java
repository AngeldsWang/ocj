/**
 * Created by wang-zhenjun on 9/1/16.
 */

import java.util.*;

public class RemoveDuplicate4SList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        RemoveDuplicate4SList s = new RemoveDuplicate4SList();
        ListNode l1 = ListNode.buildList(new int[] {1, 1, 2, 3, 3, 3});
        ListNode l2 = s.deleteDuplicates(l1);
        ListNode.printList(l2);
    }
}

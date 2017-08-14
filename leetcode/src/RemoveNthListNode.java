/**
 * Created by wang-zhenjun on 9/1/16.
 */

import java.util.*;

public class RemoveNthListNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;

        for(int i = 0; i < n; ++i) {
            q = q.next;
        }

        while (q != null) {
            q = q.next;
            p = p.next;
        }

        if (p.next != null) p.next = p.next.next;

        return dummy.next;
    }

    public static void main(String args[]) {
        RemoveNthListNode s = new RemoveNthListNode();
        ListNode l1 = ListNode.buildList(new int[] {1, 2, 3, 4, 5});
        ListNode l2 = s.removeNthFromEnd(l1, 2);
        ListNode.printList(l2);
    }
}

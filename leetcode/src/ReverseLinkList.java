/**
 * Created by wang-zhenjun on 8/29/16.
 */

import java.util.*;

public class ReverseLinkList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2 != null) {
            p1.next = p2.next;
            p2.next = dummy.next;
            dummy.next = p2;
            p2 = p1.next;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        ReverseLinkList s = new ReverseLinkList();
        ListNode l1 = ListNode.buildList(new int[] {2, 4, 3});
        ListNode l2 = s.reverseList(l1);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }
}
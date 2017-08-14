/**
 * Created by wang-zhenjun on 9/6/16.
 */

import java.util.*;

public class BTLevel2List {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode prev = dummy;
        TreeLinkNode cur  = root;

        while (cur != null) {
            if (cur.left != null) {
                prev.next = cur.left;
                prev = prev.next;
            }

            if (cur.right != null) {
                prev.next = cur.right;
                prev = prev.next;
            }

            cur = cur.next;
        }

        connect(dummy.next);
    }

    public static void main(String args[]) {
        BTLevel2List s = new BTLevel2List();
        TreeLinkNode root = TreeLinkNode.buildBT(new String[] {"1", "2", "3", "#", "5", "6", "7"});
        s.connect(root);
        TreeLinkNode.printLevelList(root);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }

    public static TreeLinkNode buildBT(String[] nodeValues) {
        if (nodeValues.length == 0 || nodeValues[0].equals("#")) return null;

        Queue<TreeLinkNode> queue = new LinkedList<>();

        TreeLinkNode root = new TreeLinkNode(Integer.parseInt(nodeValues[0]));

        queue.add(root);

        int count = 0;
        TreeLinkNode cur = null;
        for (int i = 1; i < nodeValues.length; ++i) {
            if (count == 0) {
                cur = queue.poll();
            }

            TreeLinkNode node = null;
            if (!nodeValues[i].equals("#")) {
                node = new TreeLinkNode(Integer.parseInt(nodeValues[i]));
                queue.add(node);
            }

            if (count == 0) {
                count++;
                cur.left = node;
            } else {
                count = 0;
                cur.right = node;
            }
        }

        return root;
    }

    public static void printLevelList(TreeLinkNode root) {
        if (root == null) return;

        while (root != null) {
            TreeLinkNode cur = root;
            while (cur.next != null) {
                System.out.print(cur.val + " ---> ");
                cur = cur.next;
            }

            if (cur != null) {
                System.out.println(cur.val);
            }

            root = root.left;
        }
    }
}
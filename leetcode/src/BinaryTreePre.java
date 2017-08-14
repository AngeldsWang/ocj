/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class BinaryTreePre {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;
    }

    public static void main(String args[]) {
        BinaryTreePre s = new BinaryTreePre();
        TreeNode root = TreeNode.buildBinaryTree(new String[] {"1", "2", "3", "#", "#", "4", "#", "#", "5"});
        List<Integer> res = s.preorderTraversal(root);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    // nodeValues = { 1, #, 2, 3 }
    //       1
    //         \
    //          2
    //         /
    //        3
    // same as: http://stackoverflow.com/a/23754368/3004217
    public static TreeNode buildBinaryTree(String[] nodeValues) {
        if (nodeValues.length == 0 || nodeValues[0].equals("#")) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));

        queue.add(root);

        int count = 0;
        TreeNode cur = null;
        for (int i = 1; i < nodeValues.length; ++i) {
            if (count == 0) {
                cur = queue.poll();
            }

            TreeNode node = null;
            if (!nodeValues[i].equals("#")) {
                node = new TreeNode(Integer.parseInt(nodeValues[i]));
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

    public static void printBinaryTree(TreeNode root) {
        if (root == null) return;

        BTLevelOrderTre btLevel = new BTLevelOrderTre();
        for (List<Integer> level: btLevel.levelOrder(root)) {
            System.out.println(level);
        }
    }
}

/**
 * Created by wang-zhenjun on 9/8/16.
 */

import java.util.*;

public class BSTLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        while (!(root.val <= max && root.val >= min)) {
            root = root.val < min ? root.right : root.left;
        }

        return root;
    }

    public static void main(String args[]) {
        BSTLowestCommonAncestor s = new BSTLowestCommonAncestor();
        TreeNode root = TreeNode.buildBinaryTree(new String[] {"3", "1", "6", "#", "2", "4", "7"});
        TreeNode res = s.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(7));
        System.out.println(res.val);
    }
}

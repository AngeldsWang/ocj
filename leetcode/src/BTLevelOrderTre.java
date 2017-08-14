/**
 * Created by wang-zhenjun on 9/3/16.
 */

import java.util.*;

public class BTLevelOrderTre {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelrunner(root, res, 0);
        return res;
    }

    public void levelrunner(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;

        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);
        levelrunner(root.left, res, level + 1);
        levelrunner(root.right, res, level + 1);
    }

    public static void main(String args[]) {
        BTLevelOrderTre s = new BTLevelOrderTre();
        TreeNode root = TreeNode.buildBinaryTree(new String[] {"3", "9", "20", "#", "#", "15", "7"});
        List<List<Integer>> res = s.levelOrder(root);
        for (List<Integer> level: res) {
            System.out.println(level);
        }
    }
}

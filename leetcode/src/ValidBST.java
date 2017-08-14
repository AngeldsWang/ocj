/**
 * Created by wang-zhenjun on 9/7/16.
 */

import java.util.*;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidSubBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidSubBST(TreeNode root, int lower, int high) {
        if (root == null) return true;

        return root.val > lower && root.val < high &&
                isValidSubBST(root.left, lower, root.val) &&
                isValidSubBST(root.right, root.val, high);
    }

    public static void main(String args[]) {

    }
}

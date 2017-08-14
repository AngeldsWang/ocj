/**
 * Created by wang-zhenjun on 9/6/16.
 */

import java.util.*;

public class SortedArrToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = buildBST(nums, 0, nums.length - 1);

        return root;
    }

    public TreeNode buildBST(int[] nums, int startIdx, int endIdx) {
        if (startIdx > endIdx) return null;

        int midIdx = (startIdx + endIdx) / 2;
        TreeNode node = new TreeNode(nums[midIdx]);
        node.left = buildBST(nums, startIdx, midIdx - 1);
        node.right = buildBST(nums, midIdx + 1, endIdx);

        return node;
    }

    public static void main(String args[]) {
        SortedArrToBST s = new SortedArrToBST();
        TreeNode root = s.sortedArrayToBST(new int[] {1, 2, 3, 4, 5, 6});
        TreeNode.printBinaryTree(root);
    }
}
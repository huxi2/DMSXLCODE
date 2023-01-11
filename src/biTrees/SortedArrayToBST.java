package biTrees;


import nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildNode(nums, low, mid - 1);
        root.right = buildNode(nums, mid + 1, high);
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        TreeNode root = new TreeNode();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> lows = new LinkedList<>();
        Queue<Integer> highs = new LinkedList<>();
        nodes.add(root);
        lows.add(0);
        highs.add(nums.length - 1);

        while (!nodes.isEmpty()) {
            TreeNode p = nodes.poll();
            int low = lows.poll();
            int high = highs.poll();
            int mid = low + (high - low) / 2;


            p.val = nums[mid];

            if (low <= mid - 1) {
                lows.add(low);
                highs.add(mid - 1);
                p.left = new TreeNode(0);
                nodes.add(p.left);
            }
            if (high >= mid + 1) {
                lows.add(mid + 1);
                highs.add(high);
                p.right = new TreeNode(0);
                nodes.add(p.right);
            }
        }

        return root;
    }
}

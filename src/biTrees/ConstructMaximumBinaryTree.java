package biTrees;


import nodes.TreeNode;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = nums[start];
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildNode(nums, start, maxIndex - 1);
        root.right = buildNode(nums, maxIndex + 1, end);
        return root;
    }

}

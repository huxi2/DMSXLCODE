package other;

import nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    // 将二叉树构造成平衡二叉树
    List<Integer> arr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        if (arr.size() <= 2) return root;
        return buildBalanceTree(0, arr.size() - 1);
    }

    //中序遍历获得二叉搜索树的节点
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);
    }

    // 构造二叉搜索树
    public TreeNode buildBalanceTree(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) >>> 1;// 二分查找的优化  start+(end-start)/2
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildBalanceTree(start, mid - 1);
        root.right = buildBalanceTree(mid + 1, end);
        return root;
    }
}

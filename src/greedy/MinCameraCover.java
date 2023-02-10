package greedy;

import nodes.TreeNode;

public class MinCameraCover {
    int ans;

    // 2是摄像头 1是被监控  0是无监控
    public int minCameraCover(TreeNode root) {
        int rootVal = putMinCamera(root, null);
        if (rootVal == 0) ans++;
        return ans;
    }

    // 如果当前节点是叶节点 不放监控
    // 如果子节点有未监控到的节点 则该节点放置监控
    public int putMinCamera(TreeNode root, TreeNode parent) {
        if (root == null) return 1; //空节点应当是有覆盖
        int left = putMinCamera(root.left, root);
        int right = putMinCamera(root.right, root);

        if (left == 0 || right == 0) {// 有未监控的子节点  放监控
            root.val = 2;
            ans++;
            if (parent != null && parent.val == 0) parent.val = 1;
            if (left == 0) root.left.val = 1;
            if (right == 0) root.right.val = 1;
        }
        return root.val;
    }

    /*
    public int putMinCamera(TreeNode root, TreeNode parent) {
        if (root == null) return 1; //空节点应当是有覆盖
        int left = putMinCamera(root.left, root);
        int right = putMinCamera(root.right, root);

        // 因为parent节点的存在  所以 只有else if 是有效的  if 和else都可省略
        if (left == 1 && right == 1){//子节点已经被监控 该节点无需放置
            root.val = 0;
        }else if (left == 0 || right == 0) {// 有未监控的子节点  放监控
            root.val = 2;
            ans++;
            if (parent != null && parent.val == 0) parent.val = 1;
            if (left == 0) root.left.val = 1;
            if (right == 0) root.right.val = 1;
        }else{//该节点处于被监控状态
            root.val = 1;
        }

        return root.val;
    }
     */

}

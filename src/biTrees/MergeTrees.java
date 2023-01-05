package biTrees;


import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }

    public TreeNode  mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root1);
        que.offer(root2);

        TreeNode p,q;
        while(!que.isEmpty()){
            p = que.poll();
            q = que.poll();

            root1.val += root2.val;
            //左子树都不为空
            if(root1.left != null && root2.left != null){
                que.offer(root1.left);
                que.offer(root2.left);
            }
            //右子树都不为空
            if(root1.right != null && root2.right != null){
                que.offer(root1.right);
                que.offer(root2.right);
            }

            //1子树为空 2不为空  此时用2子树代替1子树   反之不操作
            if(root1.left == null && root2.left != null){
                root1.left = root2.left;
            }
            if(root1.right == null && root2.right != null){
                root1.right = root2.right;
            }
        }
        return root1;
    }
}

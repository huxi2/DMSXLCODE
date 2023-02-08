package biTrees;

import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    //层次遍历
    public TreeNode invertTree2(TreeNode root) {
        if(root == null)return root;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode p,q;
        while(!que.isEmpty()){
            int n = que.size();
            while(n>0){
                p = que.poll();
                q = p.left;
                p.left = p.right;
                p.right = q;
                if(p.left!=null)que.offer(p.left);
                if(p.right!=null)que.offer(p.right);
                n--;
            }
        }
        return root;
    }
}

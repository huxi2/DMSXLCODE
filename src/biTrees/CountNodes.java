package biTrees;

import nodes.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        int ans = 0;
        TreeNode p;
        que.offer(root);
        while(!que.isEmpty()){
            int n = que.size();
            ans += n;
            while(n>0){
                p = que.poll();
                if(p.left!=null)que.offer(p.left);
                if(p.right!=null)que.offer(p.right);
                n--;
            }
        }
        return ans;
    }

    public int countNodes2(TreeNode root) {
        if(root == null)return 0;
        return countNodes2(root.left)+countNodes2(root.right)+1;
    }
}

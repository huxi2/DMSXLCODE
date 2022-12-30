package biTrees;

import nodes.TreeNode;

import java.util.*;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public void traversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traversal(root.left, ans);
        traversal(root.right, ans);
        ans.add(root.val);
    }

    //非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                ans.add(p.val);
                stack.push(p);
                p=p.right;
            }
            p=stack.pop();
            p=p.left;
        }
        Collections.reverse(ans);
        return ans;
    }
}

package biTrees;

import nodes.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildNode(postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildNode(int[] postorder, int is, int ie, int ps, int pe) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int pos = map.get(postorder[pe]);
        int leftNumber = pos - is;
        root.left = buildNode(postorder, is, pos - 1, ps, ps + leftNumber - 1);
        root.right = buildNode(postorder, pos + 1, ie, ps + leftNumber, pe - 1);
        return root;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildNode2(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildNode2(int[] preorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int pos = map.get(preorder[ps]);
        int leftNumber = pos - is;

        root.left = buildNode2(preorder, ps + 1, ps + leftNumber, is, pos - 1);
        root.right = buildNode2(preorder, ps + leftNumber + 1, pe, pos + 1, ie);
        return root;
    }

}

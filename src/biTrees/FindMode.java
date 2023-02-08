package biTrees;


import nodes.TreeNode;

import java.util.*;

public class FindMode {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.right;
        }
        List<Integer> arr = new ArrayList<>();
        int max = 0;
        for (int val : count.keySet()) {
            if (max < count.get(val)) {
                arr.clear();
                max = count.get(val);
                arr.add(val);
            } else if (max == count.get(val)) {
                arr.add(val);
            }
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }


    List<Integer> arr = new ArrayList<>();
    int max = 0, count = 0;
    TreeNode pre = null;

    public int[] findMode2(TreeNode root) {
        findMode1(root);
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public void findMode1(TreeNode root) {
        if (root == null) return;
        findMode1(root.left);

        if (pre == null || pre.val != root.val) {
            count = 1;
        }
        if (pre != null && pre.val == root.val) {
            count++;
        }

        if (count > max) {
            max = count;
            arr.clear();
            arr.add(root.val);
        } else if (count == max) {
            arr.add(root.val);
        }
        pre = root;
        findMode1(root.right);
    }


}

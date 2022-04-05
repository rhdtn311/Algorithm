package leet_code;

import java.util.*;

public class Solution102 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        dfs(root, 0);

        return result;
    }

    void dfs(TreeNode node, int depth) {
        if (node != null) {
            if (result.size() <= depth) {
                result.add(new ArrayList<>());
            }
            result.get(depth).add(node.val);
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package leet_code;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);

        return result;
    }

    void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            result.add(root.val);
            dfs(root.right);
        }
    }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
}

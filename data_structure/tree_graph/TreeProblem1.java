package tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeProblem1 {

      public static class TreeNode {
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

        public boolean isSymmetric(TreeNode root) {

            TreeNode leftRoot = root.left;
            TreeNode rightRoot = root.right;

            ArrayList<Integer> leftResult = new ArrayList<>();
                    preOrder(root.left, "left", leftResult);
            System.out.println("left = " + leftResult);
            ArrayList<Integer> rightResult = new ArrayList<>();
                    preOrder(root.right, "right", rightResult);
            System.out.println("right = " + rightResult);

            for (int i = 0; i < leftResult.size(); i++) {
                if (leftResult.get(i) != rightResult.get(i)) {
                    return false;
                }
            }

            return true;
        }

        public void preOrder(TreeNode node, String direction, ArrayList<Integer> arrayList) {

            if (direction.equals("left")) {
                if (node == null) {
                    arrayList.add(null);
                    return;
                }
                arrayList.add(node.val);
                preOrder(node.left,"left",arrayList);
                preOrder(node.right,"left",arrayList);
            } else {
                if (node == null) {
                    arrayList.add(null);
                    return;
                }
                arrayList.add(node.val);
                preOrder(node.right,"right",arrayList);
                preOrder(node.left,"right",arrayList);
            }
        }

    // 더 간결하고 효과적인 방법 (1000배)
    // O(N)
    public boolean isMirror(TreeNode root1, TreeNode root2) {
          if (root1 == null && root2 == null) {
              return true;
          }
          if (root1 == null || root2 == null) {
              return false;
          }
          return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    // 방법 2 (queue를 이용)
    // O(N)
    public boolean isMirror2(TreeNode root1, TreeNode root2) {
          Queue<TreeNode> queue = new LinkedList<>();

          queue.add(root1);
          queue.add(root2);

          while (!queue.isEmpty()) {
              TreeNode left = queue.poll();
              TreeNode right = queue.poll();

              if (left == null && right == null) {
                  continue;
              }
              if (left == null || right == null) {
                  return false;
              }
              queue.add(left.left);
              queue.add(right.right);
              queue.add(left.right);
              queue.add(right.left);

          }
          return true;
    }

    public static void main(String[] args) {
        TreeProblem1 s = new TreeProblem1();

        TreeNode node7 = new TreeNode(3,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(4,null,null);
        TreeNode node4 = new TreeNode(3,null,null);
        TreeNode node3 = new TreeNode(2,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode root = new TreeNode(1,node2,node3);

        boolean symmetric = s.isSymmetric(root);
        System.out.println(symmetric);
    }
}

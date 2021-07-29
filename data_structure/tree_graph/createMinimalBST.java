package tree_graph;

public class createMinimalBST {
      public class TreeNode {
      int value;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int value) { this.value = value; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.value = val;
          this.left = left;
          this.right = right;
      }
  }

  public TreeNode createMinimalBST(int[] arr, int start, int end) {
      if (end < start) {
          return null;
      }

      int mid = (start + end) / 2;
      TreeNode n = new TreeNode(arr[mid]);
      n.left = createMinimalBST(arr, start, mid - 1);
      n.right = createMinimalBST(arr, mid + 1, end);
      return n;
  }

  public void preOrder(TreeNode root) {
      if (root == null) {
          return;
      }

      System.out.println(root.value);
      preOrder(root.left);
      preOrder(root.right);
  }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,7,9};

        createMinimalBST s = new createMinimalBST();

        TreeNode node = s.createMinimalBST(array, 0, array.length - 1);
        System.out.println(node.value);
        System.out.println(node.left.value);
        System.out.println(node.right.value);
        System.out.println(node.left.right.value);
        System.out.println(node.right.right.value);

    }

}

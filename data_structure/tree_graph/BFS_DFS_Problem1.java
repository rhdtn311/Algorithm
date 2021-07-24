package tree_graph;

import java.util.Stack;

// leetcode easy : 104. Maximum Depth of Binary Tree (https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/)
public class BFS_DFS_Problem1 {
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

    public int maxDepth(TreeNode root) {

        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        int max = 1;

        nodes.push(root);
        depthStack.push(max);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int depth = depthStack.pop();

            if (node.left == null && node.right == null) {
                max = Math.max(depth, max);
            }

            if (node.left != null) {
                nodes.push(node.left);
                depthStack.push(depth + 1);
            }

            if (node.right != null) {
                nodes.push(node.right);
                depthStack.push(depth + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BFS_DFS_Problem1 s = new BFS_DFS_Problem1();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        int i = s.maxDepth(node1);
        System.out.println(i);
    }
}

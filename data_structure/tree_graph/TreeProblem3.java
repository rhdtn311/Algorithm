package tree_graph;

import java.util.Stack;

// leetcode easy : 100. Same Tree ( https://leetcode.com/problems/same-tree/)
class TreeProblem3 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<Integer> stack = new Stack<>();
        method(p,q,stack);
        System.out.print(stack);

        while(!stack.isEmpty()) {
            if (stack.peek() == -2) return false;

            int num1 = stack.pop();
            int num2 = stack.pop();

            if (num1 != num2) {
                return false;
            }

        }
        return true;

    }

    public void method(TreeNode p, TreeNode q, Stack<Integer> stack) {

        if (p == null && q == null) {
            stack.add(-1);
            stack.add(-1);
            return;
        }
        if (p == null || q == null) {
            stack.add(-2);
            return;
        }
        stack.add(q.val);
        method(p.left,q.left,stack);
        method(p.right,q.right,stack);
    }

    // 더 좋은 방법
    public boolean method2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return method2(p.right, q.right) && method2(p.left, p.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);

        node3.right = node4;

        TreeProblem3 s = new TreeProblem3();
        boolean sameTree = s.isSameTree(node1, node3);
        System.out.println(sameTree);


    }
}
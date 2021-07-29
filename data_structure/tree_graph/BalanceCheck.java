package tree_graph;

// 이진트리가 균형이 잡혀있는지 확인하는 함수를 작성하라. 균형 잡힌 트리란, 모든 노드에 대해서 왼쪽 부분 트리 높이와
// 오른쪽 부분 트리의 높이의 차이가 최대 하나인 트리를 의미한다.
public class BalanceCheck {
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }
    public int getHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int diff = getHeight(root.left) - getHeight(root.right);
        if (diff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) +1;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        BalanceCheck s = new BalanceCheck();
        int i = s.checkHeight(node1);
        System.out.println(i);
    }
}

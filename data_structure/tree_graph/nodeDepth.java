package tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class nodeDepth {
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

    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList linkedList = null;
        if (lists.size() == level) {
            linkedList = new LinkedList();
            lists.add(linkedList);
        } else {
            linkedList = lists.get(level);
        }
        linkedList.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        if (root != null) {
            linkedList.add(root);
        }

        while(linkedList.size() > 0) {
            arrayList.add(linkedList);
            LinkedList parents = linkedList;
            linkedList = new LinkedList<>();
            for (TreeNode parent : linkedList) {
                if (parent.left != null) {
                    linkedList.add(parent.left);
                }
                if (parent.right != null) {
                    linkedList.add(parent.right);
                }
            }
        }
        return arrayList;
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

        nodeDepth s = new nodeDepth();
//        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        ArrayList<LinkedList<TreeNode>> lists = s.createLevelLinkedList(node1);

        for (LinkedList<TreeNode> linkedList : lists) {
            for (TreeNode node : linkedList) {
                System.out.print(node.value);
            }
            System.out.println();
        }
    }
}

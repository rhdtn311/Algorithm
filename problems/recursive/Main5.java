package recursive;

public class Main5 {
    Node root;

    public void preorder(Node root) {
        if (root == null) return;

        System.out.println(root.data);
        preorder(root.lt);
        preorder(root.rt);
    }

    public void inorder(Node root) {
        if (root == null) return;

        inorder(root.lt);
        System.out.println(root.data);
        inorder(root.rt);
    }

    public void postorder(Node root) {
        if (root == null) return;

        postorder(root.lt);
        postorder(root.rt);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Main5 tree = new Main5();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.inorder(tree.root);
    }
}

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }

}
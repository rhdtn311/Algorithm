package tree_graph;

// 직접 구현한 이진 트리
public class Tree {

    Node root;

    public Node addNode(Object data) {
        return new Node(data);
    }

    // 루트 지정
    public void setRoot(Node node) {
        this.root = node;
    }

    // 전위 순회
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // 후위 순회
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // 노드
    public class Node {
        Object data;
        Node left;
        Node right;
        boolean child = false;

        public Node(Object data) {
            this.data = data;
        }

        // 노드의 왼쪽 자식 지정
        public void addLeft(Node node) {
            this.left = node;
            node.child = true;
        }

        // 노드의 오른쪽 자식 지정
        public void addRight(Node node) {
            this.right = node;
            node.child = true;
        }

        // 노드의 왼쪽 자식 삭제
        public void deleteLeft() {
            this.left.child = false;
            this.left = null;
        }

        // 노드의 오른쪽 자식 삭제
        public void deleteRight() {
            this.right.child = false;
            this.right = null;
        }
    }
}

package recursive;

import java.util.LinkedList;
import java.util.Queue;

public class Main7 {

    Node root;

    public static void main(String[] args) {
        Main7 tree = new Main7();

        tree.root = new recursive.Node(1);
        tree.root.lt = new recursive.Node(2);
        tree.root.rt = new recursive.Node(3);
        tree.root.lt.lt = new recursive.Node(4);
        tree.root.lt.rt = new recursive.Node(5);
        tree.root.rt.lt = new recursive.Node(6);
        tree.root.rt.rt = new recursive.Node(7);

        tree.bfs(tree.root);
    }

    void bfs(Node tree) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(tree);
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            System.out.print(now.data + " ");
            if (now.lt != null) queue.add(now.lt);
            if (now.rt != null) queue.add(now.rt);
        }
    }
}
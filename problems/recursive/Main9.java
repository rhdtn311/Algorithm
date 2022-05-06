package recursive;

import java.util.*;

public class Main9 {

    Node root;
    static int answer = 0;

    public static void main(String[] args) {
        Main9 tree = new Main9();

        tree.root = new recursive.Node(1);
        tree.root.lt = new recursive.Node(2);
        tree.root.rt = new recursive.Node(3);
        tree.root.lt.lt = new recursive.Node(4);
        tree.root.lt.rt = new recursive.Node(5);

        int dfs = dfs(tree.root, 0);
        System.out.println(dfs);
        int bfs = bfs(tree.root);
        System.out.println(bfs);
    }

    static int dfs(Node node, int depth) {

        if (node.lt == null && node.rt == null) {
            return depth;
        }

        return Math.min(dfs(node.lt, depth + 1), dfs(node.rt, depth + 1));

    }

    static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                if (now.lt == null && now.rt == null) return L;
                if (now.lt != null) queue.offer(node.lt);
                if (now.rt != null) queue.offer(node.rt);
            }
            L++;
        }

        return 0;
    }

}

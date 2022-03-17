package programmers_lv3;

import java.util.Stack;

public class Solution21 {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        s.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, i + 1, i - 1);
        }

        Stack<Node> removed = new Stack<>();
        Node now = nodes[k];
        for (String command : cmd) {
            String[] input = command.split(" ");

            String nowCommand = input[0];
            switch (nowCommand) {
                case "D":
                    int dNum = Integer.parseInt(input[1]);
                    while (dNum-- > 0) {
                        now = nodes[now.next];
                    }
                    break;

                case "U":
                    int uNum = Integer.parseInt(input[1]);
                    while (uNum-- > 0) {
                        now = nodes[now.prev];
                    }
                    break;

                case "C":
                    removed.push(now);
                    now.removed = true;
                    if (now.prev != -1 && now.next != n) {
                        nodes[now.prev].next = nodes[now.next].now;
                        nodes[now.next].prev = nodes[now.prev].now;
                    } else if (now.prev == -1) {
                        nodes[now.next].prev = -1;
                    } else if (now.next == n) {
                        nodes[now.prev].next = n;
                    }
                    now = now.next == n ? nodes[now.prev] : nodes[now.next];
                    break;

                case "Z":
                    Node reloadNode = removed.pop();
                    reloadNode.removed = false;
                    if (reloadNode.prev != -1) {
                        nodes[reloadNode.prev].next = reloadNode.now;
                    }
                    if (reloadNode.next != n) {
                        nodes[reloadNode.next].prev = reloadNode.now;
                    }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nodes[i].removed ? 'X' : 'O');
        }

        System.out.println(sb);
        return sb.toString();
    }

    class Node {
        int now;
        int next;
        int prev;
        boolean removed = false;

        public Node(int now, int next, int prev) {
            this.now = now;
            this.next = next;
            this.prev = prev;
        }
    }
}

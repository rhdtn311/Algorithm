package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // D = N을 두배로, 9999 보다 크다면 10000으로 나눈다.
        // S = N - 1을 저장, N이 0이라면 9999를 저장한다.
        // L = N을 왼편으로 쉬프트
        // R = N을 오른편으로 쉬프트

        int T = Integer.parseInt(br.readLine());
        Queue<Node> queue = new ArrayDeque<>();
        while (T-- > 0) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            boolean[] visited = new boolean[10000];
            visited[a] = true;

            queue = new ArrayDeque<>();

            queue.offer(new Node(a, ""));

            String answer = "";

            outer : while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node now = queue.poll();

                    if (now.value == b) {
                        answer = now.str;
                        break outer;
                    }

                    int D = D(now.value);
                    int S = S(now.value);
                    int L = L(now.value);
                    int R = R(now.value);

                    if (!visited[D]) {
                        queue.offer(new Node(D, now.str + "D"));
                        visited[D] = true;
                    }
                    if (!visited[S]) {
                        queue.offer(new Node(S, now.str + "S"));
                        visited[S] = true;
                    }
                    if (!visited[L]) {
                        queue.offer(new Node(L, now.str + "L"));
                        visited[L] = true;
                    }
                    if (!visited[R]) {
                        queue.offer(new Node(R, now.str + "R"));
                        visited[R] = true;
                    }
                }
            }

            System.out.println(answer);
        }

    }

    static class Node {
        String str;
        int value;

        public Node(int value, String str) {
            this.value = value;
            this.str = str;
        }
    }

    static int D(int n) {
        n *= 2;
        return n > 9999 ? n % 10000 : n;
    }

    static int S(int n) {
        n -= 1;
        return n == -1 ? 9999 : n;
    }

    static int R(int n) {

        int sum = 0;
        sum += n / 1000 * 100;
        n %= 1000;
        sum += n / 100 * 10;
        n %= 100;
        sum += n / 10;
        n %= 10;
        sum += n * 1000;

        return sum;
    }

    static int L(int n) {

        int sum = 0;
        sum += n / 1000;
        n %= 1000;
        sum += n / 100 * 1000;
        n %= 100;
        sum += n / 10 * 100;
        n %= 10;
        sum += n * 10;

        return sum;
    }

}

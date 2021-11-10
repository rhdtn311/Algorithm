package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer poll = queue.poll();
            if (count == K) {
                if (queue.size() >= 1){
                    sb.append(poll).append(", ");
                } else {
                    sb.append(poll);
                }
                count = 0;
            } else {
                queue.offer(poll);
            }
        }

        System.out.println(sb.append('>'));
    }
}

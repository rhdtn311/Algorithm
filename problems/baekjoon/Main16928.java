package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] board = new int[101];
        Map<Integer, Integer> ladders = new HashMap<>();
        Map<Integer, Integer> snakes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] ladder = br.readLine().split(" ");
            ladders.put(Integer.parseInt(ladder[0]), Integer.parseInt(ladder[1]));
        }

        for (int i = 0; i < m; i++) {
            String[] snake = br.readLine().split(" ");
            snakes.put(Integer.parseInt(snake[0]), Integer.parseInt(snake[1]));
        }

        int answer = 0;
        boolean[] visited = new boolean[110];

        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person(1, 0));
        while (!queue.isEmpty()) {

            Person now = queue.poll();
            visited[now.point] = true;

            if (now.point >= 100) {
                answer = now.count;
                break;
            }

            for (int j = 1; j <= 6; j++) {

                if (visited[now.point + j]) continue;

                if (snakes.containsKey(now.point + j)) {
                    queue.offer(new Person(snakes.get(now.point + j), now.count + 1));
                } else if (ladders.containsKey(now.point + j)) {
                    queue.offer(new Person(ladders.get(now.point + j), now.count + 1));
                } else {
                    queue.offer(new Person(now.point + j, now.count + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Person {
        int point;
        int count;

        public Person(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}

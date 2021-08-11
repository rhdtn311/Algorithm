package tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Problem9 {
    // 백준 1697 : 숨바꼭질 (https://www.acmicpc.net/problem/1697)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int arrived = Integer.parseInt(input[1]);

        // 현재 숫자가 들어갈 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // 현재 숫자가 몇 번 움직였는지 기록할 큐
        Queue<Integer> countQueue = new LinkedList<>();
        countQueue.add(0);

        // 현재 숫자가 이미 방문했는지 확인
        boolean[] visited = new boolean[100001];
        while (!queue.isEmpty()) {
            int nowNumber = queue.poll();
            int count = countQueue.poll();

            visited[nowNumber] = true;
            if (nowNumber == arrived) {
                System.out.println(count);
                break;
            }

            if (nowNumber < arrived) {
                int nextCount = count + 1;

                // 현재 숫자가 지정된 범위 안에서 +1, *2, -1이 가능한지 확인 후 가능하다면 세 가지 경우를 전부 계산
                    if (nowNumber + 1 <= 100000 && !visited[nowNumber + 1]) {
                        queue.add(nowNumber + 1);
                        countQueue.add(nextCount);
                    }

                    if (nowNumber * 2 <= 100000 && !visited[nowNumber * 2]) {
                        queue.add(nowNumber * 2);
                        countQueue.add(nextCount);
                    }

                    if (nowNumber - 1 >= 0 && !visited[nowNumber - 1]) {
                        queue.add(nowNumber - 1);
                        countQueue.add(nextCount);
                    }
            } else {
                if (nowNumber - 1 >= 0 && !visited[nowNumber - 1]) {
                    queue.add(nowNumber - 1);
                    int nextCount = count + 1;
                    countQueue.add(nextCount);
                }
            }
        }
    }
}

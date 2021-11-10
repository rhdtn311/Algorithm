package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Queue queue = new Queue();
        while(N --> 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push" :
                    queue.push(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;

                case "front":
                    sb.append(queue.front()).append('\n');
                    break;

                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Queue {
        LinkedList<Integer> list = new LinkedList<>();

        void push(int n) {
            list.add(n);
        }

        int pop() {
            return list.size() == 0 ? -1 : list.removeFirst();
        }

        int size() {
            return list.size();
        }

        int empty() {
            return list.size() == 0 ? 1 : 0;
        }

        int front() {
            return list.size() == 0 ? -1 : list.getFirst();
        }

        int back() {
            return list.size() == 0 ? -1 : list.getLast();
        }
    }
}

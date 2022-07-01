package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue queue = new Queue();
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                queue.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
                System.out.println(queue.pop());
            } else if (input[0].equals("size")) {
                System.out.println(queue.size());
            } else if (input[0].equals("empty")) {
                System.out.println(queue.empty());
            } else if (input[0].equals("front")) {
                System.out.println(queue.front());
            } else if (input[0].equals("back")) {
                System.out.println(queue.back());
            }
        }

    }

    static class Queue {
        List<Integer> list = new LinkedList<>();

        void push(int n) {
            list.add(n);
        }

        int pop() {
            if (!list.isEmpty()) {
                return list.remove(0);
            }
            else return -1;
        }

        int size() {
            return list.size();
        }

        int empty() {
            return list.isEmpty() ? 1 : 0;
        }

        int front() {
            return list.isEmpty() ? -1 : list.get(0);
        }

        int back() {
            return list.isEmpty() ? -1 : list.get(list.size() - 1);
        }
    }
}

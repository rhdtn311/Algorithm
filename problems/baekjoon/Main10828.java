package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            String now = input[0];
            if (now.equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            } else if (now.equals("top")) {
                System.out.println(stack.top());
            } else if (now.equals("size")) {
                System.out.println(stack.size);
            } else if (now.equals("empty")) {
                System.out.println(stack.empty());
            } else if (now.equals("pop")) {
                System.out.println(stack.pop());
            }
        }
    }

    static class Stack {
        List<Integer> list = new LinkedList<>();
        int prev;
        int size = 0;

        public void push(int val) {
            list.add(val);
            prev = val;
            ++size;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            } else {
                Integer remove = list.remove(size - 1);
                --size;
                prev = size == 0 ? 0 : list.get(size - 1);
                return remove;
            }
        }

        public int empty() {
            return list.size() == 0 ? 1 : 0;
        }

        public int top() {
            return size == 0 ? -1 : prev;
        }

    }
}

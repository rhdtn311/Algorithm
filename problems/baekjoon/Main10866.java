package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque deque = new Deque();
        while (N --> 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push_front" :
                    deque.push_front(new Node(Integer.parseInt(input[1])));
                    break;

                case "push_back":
                    deque.push_back(new Node(Integer.parseInt(input[1])));
                    break;

                case "pop_front":
                    sb.append(deque.pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(deque.pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.empty()).append('\n');
                    break;

                case "front" :
                    sb.append(deque.front()).append('\n');
                    break;

                case "back" :
                    sb.append(deque.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }

    static class Deque {
        Node first;
        Node last;
        int size = 0;

        void push_front(Node node) {
            if (first != null) {
                node.back = first;
                first.front = node;
            }

            if (last == null) {
                last = node;
            }

            first = node;
            size++;
        }

        void push_back(Node node) {
            if (last != null) {
                node.front = last;
                last.back = node;
            }

            if (first == null) {
                first = node;
            }

            last = node;
            size++;
        }

        int pop_front() {
            if (first == null) {
                return -1;
            }

            int val = first.value;

            if (size > 1) {
                Node second = first.back;
                second.front = null;
                first.back = null;
                first = second;
            } else {
                first = null;
                last = null;
            }
            size--;
            return val;
        }

        int pop_back() {
            if (last == null) {
                return -1;
            }

            int val = last.value;

            if (size > 1) {
                Node front = last.front;
                front.back = null;
                last.front = null;
                last = front;
            } else {
                first = null;
                last = null;
            }
            size--;

            return val;
        }

        int size() {
            return size;
        }

        int empty() {
            return size == 0 ? 1 : 0;
        }

        int front() {
            return size == 0 ? -1 : first.value;
        }

        int back() {
            return size == 0 ? -1 : last.value;
        }
    }

    static class Node {
        Node front;
        Node back;
        int value;

        Node(int value) {
            this.value = value;
        }
    }
}

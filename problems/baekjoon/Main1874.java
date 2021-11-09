package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int max = 0;
        int count = 0;
        while (count < N) {

            int value = Integer.parseInt(br.readLine());
            count++;

            if (max < value) {
                for (int i = max+1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                max = value;
            }

            if (stack.peek() == value) {
                stack.pop();
                sb.append('-').append('\n');

            }
        }

        System.out.println(stack);
        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            int n = input == 0 ? stack.pop() : stack.push(input);
        }

        int size = stack.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}

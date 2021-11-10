package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main17298 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < N; i++) {

            int size = stack.size();
            for (int j = 0; j < size; j++) {
                if (arr[stack.peek()] < arr[i]) {
                    arr[stack.pop()] = arr[i];
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}

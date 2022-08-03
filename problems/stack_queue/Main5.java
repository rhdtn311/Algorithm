package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(input));

        String answer = "NO";
        for (String s : br.readLine().split("")) {
            if (queue.peek().equals(s)) queue.poll();
            if (queue.isEmpty()) {
                answer = "YES";
                break;
            }
        }

        System.out.println(answer);
    }
}

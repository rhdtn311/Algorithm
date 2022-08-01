package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int box_num = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == '(') box_num++;
            else if (c == ')') box_num--;
            else {
                if (box_num == 0) sb.append(c);
            }
        }

        System.out.println(sb);
    }
}

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char now = ' ';
        int dup = 1;
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (now == ' ') {
                now = c;
                continue;
            }

            if (now == c) dup++;
            else {
                if (dup != 1) answer.append(now).append(dup);
                else answer.append(now);

                now = c;
                dup = 1;
            }
        }

        if (dup == 1) answer.append(now);
        else answer.append(now).append(dup);

        System.out.println(answer);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int iterNum = Integer.parseInt(s[0]);
            String str = s[1];
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                for (int j = 0; j < iterNum; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}

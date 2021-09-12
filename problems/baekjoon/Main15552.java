package baekjoon;

import java.io.*;

public class Main15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int i1 = Integer.parseInt(split[0]);
            int i2 = Integer.parseInt(split[1]);

            bw.write(i1 + i2 + "\n");
        }
        bw.close();
    }
}

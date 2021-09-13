package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            String[] s = str.split(" ");
            int i1 = Integer.parseInt(s[0]);
            int i2 = Integer.parseInt(s[1]);

            System.out.println(i1 + i2);
        }

    }
}

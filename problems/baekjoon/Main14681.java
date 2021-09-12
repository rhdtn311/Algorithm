package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(br.readLine());
        int i2 = Integer.parseInt(br.readLine());

        if (i1 > 0) {
            if (i2 > 0) {
                System.out.println(1);
            } else {
                System.out.println(4);
            }
        } else {
            if (i2 > 0) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}

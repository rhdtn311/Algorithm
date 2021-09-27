package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder s1 = new StringBuilder(s[0]);
        StringBuilder s2 = new StringBuilder(s[1]);

        int i1 = Integer.parseInt(s1.reverse().toString());
        int i2 = Integer.parseInt(s2.reverse().toString());

        System.out.println(Math.max(i1, i2));
    }
}

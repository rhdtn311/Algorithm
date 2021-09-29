package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        int up = A - B;
        int goal = V - A;
        if (goal % up != 0) {
            System.out.println(goal / up + 2);
        } else {
            System.out.println(goal / up + 1);
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            star.append(" ");
        }
        star.append("*");
        for (int i = 0; i < n; i++) {
            System.out.println(star);
            star.append("*");
            star.deleteCharAt(0);
        }
    }
}

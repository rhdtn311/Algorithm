package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String alpha : arr) {
            if (s.contains(alpha)) {
                s = s.replace(alpha, " ");
            }
        }

        System.out.println(s.length());
    }
}

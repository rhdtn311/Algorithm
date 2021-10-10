package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main10757version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        BigInteger i1 = new BigInteger(s[0]);
        BigInteger i2 = new BigInteger(s[1]);

        System.out.println(i1.add(i2));
    }
}

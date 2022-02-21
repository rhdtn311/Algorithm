package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();
        boolean one = arr[0] == '1';
        int oneCount = arr[0] == '1' ? 1 : 0;
        int zeroCount = arr[0] == '0' ? 1 : 0;
        for (char c : arr) {
            if (one) {
                if (c == '0') {
                    one = false;
                    zeroCount++;
                }
            } else {
                if (c == '1') {
                    one = true;
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}

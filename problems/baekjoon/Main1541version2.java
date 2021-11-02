package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;
        String[] arr = s.split("-");
        for (int i = 0; i < arr.length; i++) {
            int value = 0;
            String[] sums = arr[i].split("\\+");

            for (int j = 0; j < sums.length; j++) {
                value += Integer.parseInt(sums[j]);
            }
            if (i == 0) {
                result += value;
            } else {
                result -= value;
            }
        }
        System.out.println(result);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(br.readLine());
        int i2 = Integer.parseInt(br.readLine());
        int i3 = Integer.parseInt(br.readLine());

        int num = i1 * i2 * i3;
        String s = String.valueOf(num);
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int c = Character.getNumericValue(s.charAt(i));
            arr[c] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}

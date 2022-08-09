package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1107 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] isBreak = new boolean[10];
        String[] breakNums = new String[n];
        if (n != 0) {
            breakNums = br.readLine().split(" ");
        }

        for (String breakNum : breakNums) {
            isBreak[Integer.parseInt(breakNum)] = true;
        }

        int result = Math.abs(100 - num);
        for (int i = 0; i <= 999999; i++) {
            String now = String.valueOf(i);
            int len = now.length();

            boolean nowIsBreak = false;
            for (int j = 0; j < len; j++) {
                if (isBreak[Character.getNumericValue(now.charAt(j))]) {
                    nowIsBreak = true;
                    break;
                }
            }

            if (!nowIsBreak) {
                result = Math.min(result, len + Math.abs(i - num));
            }
        }

        System.out.println(result);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14888 {

    static int N;
    static int[] arr;
    static int[] opp = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            opp[i] = Integer.parseInt(s1[i]);
        }

        calculate(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void calculate(int num, int idx) {

        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opp[i] > 0) {
                opp[i]--;

                switch (i) {
                    case 0 : calculate(num + arr[idx], idx + 1); break;
                    case 1 : calculate(num - arr[idx], idx + 1); break;
                    case 2 : calculate(num * arr[idx], idx + 1); break;
                    case 3 : calculate(num / arr[idx], idx + 1); break;
                }

                opp[i]++;
            }
        }
    }
}


package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.*;

public class Main1062 {

    static int N;
    static int K;

    static boolean[] visited = new boolean[26];

    static String[] words;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        words = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                words[i] = s.substring(4, s.length() - 4);
            }
        }

        visited[97 - 'a'] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;
        visited['i' - 97] = true;
        visited['c' - 97] = true;

        combination(0, 0);

        System.out.println(max);

    }

    static void combination(int index, int start) {

        if (index == K - 5) {

            int count = 0;
            for (int i = 0; i < N; i++) {

                boolean isValid = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 97]) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(index + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (checkGroupWord(s)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean checkGroupWord(String word) {
        String str = "";
        char now = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (now != c) {
                if (str.contains(String.valueOf(c))) {
                    return false;
                }
            }
            now = c;
            str += c;
        }
        return true;
    }
}

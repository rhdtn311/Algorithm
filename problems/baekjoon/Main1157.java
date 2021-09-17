package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] array = new int[26];
        int max = 0;
        char ch = '?';
        for (char c : s.toCharArray()) {
            int alphabet = String.valueOf(c).toLowerCase().charAt(0)-'a';
            array[alphabet]++;
            if (array[alphabet] > max) {
                max = array[alphabet];
                ch = (char) (alphabet + 65);
            } else if (array[alphabet] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}

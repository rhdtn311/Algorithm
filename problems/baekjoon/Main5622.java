package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        int n = 3;
        int count = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char)i, n);
            count ++;
            if (i == 'R' || i == 'Y') {
                if (count == 4) {
                    n++;
                    count = 0;
                }
            } else {
                if (count >= 3) {
                    n++;
                    count = 0;
                }
            }
        }

        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += map.get(c);
        }

        System.out.println(map);
        System.out.println(sum);
    }
}

package baekjoon;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Map<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                if (map.containsKey(s[1])) {
                    map.put(s[1], map.get(s[1]) + 1);
                } else {
                    map.put(s[1], 1);
                }
            }

            int answer = 1;
            for (int value : map.values()) {
                answer *= value + 1;
            }

            System.out.println(answer - 1);
        }
    }
}

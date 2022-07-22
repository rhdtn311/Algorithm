package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}

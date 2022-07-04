package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, Integer> StringKeyPocket = new HashMap<>();
        Map<Integer, String> IntKeyPocket = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            StringKeyPocket.put(name, i);
            IntKeyPocket.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            if (Character.isDigit(input.charAt(0))) {
                System.out.println(IntKeyPocket.get(Integer.parseInt(input)));
            }  else {
                System.out.println(StringKeyPocket.get(input));
            }
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main10816version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        for (String s1 : s) {
            if (map.containsKey(s1)) {
                map.put(s1 , map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String[] finds = br.readLine().split(" ");
        for (String find : finds) {
            if (map.containsKey(find)) {
                sb.append(map.get(find)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }
}

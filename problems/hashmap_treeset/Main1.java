package hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        String[] input = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }

        String answer = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }

        System.out.println(answer);
    }
}

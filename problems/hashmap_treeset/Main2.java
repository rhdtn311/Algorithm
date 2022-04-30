package hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] arr = br.readLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        StringBuilder answer = new StringBuilder(map.size() + " ");

        int left = 0;
        int right = k;
        for (right = k; right < n; right++) {

            if (map.get(arr[left]) == 1) {
                map.remove(arr[left]);
            } else {
                map.put(arr[left], map.get(arr[left]) - 1);
            }

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            answer.append(map.size()).append(" ");
            left++;
        }

        System.out.println(answer);
    }
}

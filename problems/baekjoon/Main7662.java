package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> maxMap = new TreeMap<>(Comparator.reverseOrder());
            TreeMap<Integer, Integer> minMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                String op = input[0];
                int val = Integer.parseInt(input[1]);

                switch (op) {
                    case "I" :
                        maxMap.put(val, maxMap.getOrDefault(val, 0) + 1);
                        minMap.put(val, minMap.getOrDefault(val, 0) + 1);
                        break;
                    case "D" :
                        if (!maxMap.isEmpty() && val == 1) {
                            Integer key = maxMap.firstKey();
                            maxMap.put(key, maxMap.get(key) - 1);
                            if (maxMap.get(key) == 0) maxMap.remove(key);
                            if (minMap.containsKey(key)) {
                                minMap.put(key, minMap.get(key) - 1);
                                if (minMap.get(key) == 0) minMap.remove(key);
                            }
                        } else if (!minMap.isEmpty() && val == -1) {
                            Integer key = minMap.firstKey();
                            minMap.put(key, minMap.get(key) - 1);
                            if (minMap.get(key) == 0) minMap.remove(key);
                            if (maxMap.containsKey(key)){
                                maxMap.put(key, maxMap.get(key) - 1);
                                if (maxMap.get(key) == 0) maxMap.remove(key);
                            }
                        }
                        break;
                }
            }

            if (maxMap.isEmpty() && minMap.isEmpty()) System.out.println("EMPTY");
            else System.out.println(maxMap.firstKey() + " " + minMap.firstKey());
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Set<String> first = new HashSet<>();
        Set<String> second = new TreeSet<>();
        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();

            if (first.contains(name)) {
                second.add(name);
            } else {
                first.add(name);
            }
        }

        System.out.println(second.size());
        for (String name : second) {
            System.out.println(name);
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, (s1,s2) -> {
            if (s1.length() == s2.length()) {
                return StringSort(s1, s2);
            } else {
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static int StringSort(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char c1 = Character.toLowerCase(str1.charAt(i));
            char c2 = Character.toLowerCase(str2.charAt(i));
            if (c1 - c2 != 0) {
                return c1 - c2;
            }
        }
        return 0;
    }
}

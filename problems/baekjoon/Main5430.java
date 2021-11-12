package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        outer : while (T --> 0){

            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] strings = s.substring(1, s.length() - 1).split(",");

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(strings[i]));
            }

            boolean first = true;
            for (char c : func.toCharArray()) {
                switch (c) {
                    case 'R' :
                        first = !first;
                        break;

                    case 'D':
                        if (list.size() == 0) {
                            sb.append("error").append('\n');
                            continue outer;
                        } else {
                            if (first) {
                                list.pollFirst();
                            } else {
                                list.pollLast();
                            }
                        }
                        break;
                }
            }

            sb.append('[');
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (first) {
                    sb.append(list.pollFirst());
                } else {
                    sb.append(list.pollLast());
                }
                if (i != size - 1) {
                    sb.append(',');
                }
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }
}

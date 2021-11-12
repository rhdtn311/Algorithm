package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        int count = 0;
        String[] find = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(find[i]);
            if (arr.peekFirst() == value) {
                arr.pollFirst();
                continue;
            }

            int index = arr.indexOf(value);
            if (index > arr.size() / 2) {
                while (arr.peekFirst() != value) {
                    arr.offerFirst(arr.pollLast());
                    count++;
                }
            } else {
                while (arr.peekFirst() != value) {
                    arr.offerLast(arr.pollFirst());
                    count++;
                }
            }

            if (arr.peekFirst() == value) {
                arr.pollFirst();
                continue;
            }
        }
        System.out.println(count);
    }
}

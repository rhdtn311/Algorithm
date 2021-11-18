package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main12015 {

    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        list.add(0);

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int start = 1;
                int end = list.size() - 1;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (list.get(mid) >= arr[i]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(start, arr[i]);
            }
        }

        System.out.println(list.size()-1);

    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1700 {

    static int N;
    static int K;

    static int[] arr;

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        arr = new int[K];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int v = Integer.parseInt(input[i]);

            arr[i] = v;
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            if (list.contains(arr[i])) {
                continue;
            }
            if (list.size() < N) {
                list.add(arr[i]);
            } else {
                if (!list.contains(arr[i])) {
                    count++;

                    int idx = -1;
                    int last = -1;
                    for (int j = 0; j < list.size(); j++) {
                        boolean inArr = false;
                        for (int k = i; k < arr.length; k++) {

                            if (list.get(j) == arr[k]) {
                                inArr = true;
                                if (last < k) {
                                    last = k;
                                    idx = j;
                                }
                                break;
                            }
                        }
                        if (!inArr) {
                            idx = j;
                            break;
                        }
                    }
                    list.set(idx, arr[i]);
                }
            }
        }

        System.out.println(count);
    }
}

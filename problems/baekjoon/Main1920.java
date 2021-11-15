package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1920 {

    static int[] arr;
    static int[] find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] arrs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        find = new int[M];

        String[] finds = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(finds[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(find[i])).append('\n');
        }

        System.out.println(sb);
    }

    public static int binarySearch(int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}

package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1_1 {

    static int n;   // 원소의 갯수
    static int total;   // 원소의 총합
    static boolean flag;    // 정답을 구했을 경우

    static int[] arr;   // 원소를 담을 배열
    static String answer = "NO";    // 정답

    static void dfs(int L, int sum) {

        if (flag) return;   // 정답을 구했으면 모든 재귀에서 빠져 나옴

        if (sum > total / 2) return;    // 합이 총합의 반 이상이라면 return
        if (sum == total - sum) {   // sum * 2 = 총합이라면 정답이 YES
            flag = true;
            answer = "YES";
            return;
        }

        dfs(L + 1, sum + arr[L]);   // 인덱스 L의 원소를 더해줌
        dfs(L + 1, sum);    // 인덱스 L의 원소를 더하지 않음
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            total += arr[i];
        }

        dfs(0, 0);

        System.out.println(answer);
    }



}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] first = br.readLine().split("");
        String[] second = br.readLine().split("");

        Ant[] ants = new Ant[n + m];
        // 첫 번째 그룹의 Ant를 반대로 배열에 삽입
        for (int i = n - 1; i >= 0; i--) {
            ants[i] = new Ant(false, first[n - 1 - i]);
        }
        for (int i = n; i < n + m; i++) {
            ants[i] = new Ant(true, second[i - n]);
        }

        int t = Integer.parseInt(br.readLine());

        /*
        * Swap 조건
        * 1. 현재 탐색하는 개미의 방향과 앞에 있는 개미의 방향이 달라야한다.
        * 2. 현재 탐색하는 개미의 방향이 왼쪽 그룹 개미의 방향이어야 한다. (그렇지 않으면 개미가 역주행함)
        * */
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n + m - 1; j++) {
                if (ants[j].direction != ants[j + 1].direction && !ants[j].direction && ants[j+1].direction) {
                    Ant temp = new Ant(ants[j].direction, ants[j].s);
                    ants[j] = ants[j + 1];
                    ants[j + 1] = temp;
                    j++;  // Swap을 했다면 배열의 위치가 바뀌기 때문에 반복 스왑이 될 수 있으므로 한 칸 건너 띄워야 한다.
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Ant ant : ants) {
            answer.append(ant.s);
        }

        System.out.println(answer);
    }

    static class Ant {
        boolean direction;
        String s;

        public Ant(boolean direction, String s) {
            this.direction = direction;
            this.s = s;
        }
    }
}

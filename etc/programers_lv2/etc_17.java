package programers_lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class etc_17 {
    // 프로그래머스 lv 2 : 소수 찾기
    private static boolean[] visited = new boolean[7];
    private static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {

        String temp = "";
        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, temp, i);
        }
        System.out.println(set);

        int count = 0;
        for (int s : set) {
            if (checkPrimeNumber(s)) {
                count++;
            }
        }

        return count;
    }

    // 재귀함수를 이용하여 numbers의 원소로 조합할 수 있는 모든 경우의 수를 set에 저장
    public static void permutation(String numbers, String temp, int len) {

        if (temp.length() == len) {
            set.add(Integer.valueOf(temp));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            temp += numbers.charAt(i);

            visited[i] = true;

            permutation(numbers, temp, len);

            visited[i] = false;

            temp = temp.substring(0, temp.length()-1);
        }
    }

    // 소수 판별 메서드
    public boolean checkPrimeNumber(int num) {
        if (num == 1 || num == 0) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

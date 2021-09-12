package programers_lv1;

import java.util.Arrays;

public class etc_20 {
    // 프로그래머스 lv 1 : [1차] 비밀지도 (https://programmers.co.kr/learn/courses/30/lessons/17681)
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            array[i] = ((array[i].length() < n) ? makeBinaryString(n,array[i]) : array[i])
                    .replaceAll("0", " ").replaceAll("1", "#");
        }
        return array;
    }

    public String makeBinaryString(int n, String str) {

        for (int i = str.length(); i < n; i++) {
            str = "0" + str;
        }
        return str;
    }


    public static void main(String[] args) {
        etc_20 s = new etc_20();
        String[] solution = s.solution(6, new int[]{46,33,33,22,31,50}, new int[]{27,56,19,14,14,10});
        System.out.println(Arrays.toString(solution));
    }
}


import java.util.*;

public class etc_14 {
    // 프로그래머스 lv 1 : 실패율 (https://programmers.co.kr/learn/courses/30/lessons/42889)
    public int[] solution(int N, int[] stages) {

        double[] result = new double[N];
        for (int i = 1; i <= N; i++) {
            int passStage = 0;  // 현재 스테이지를 클리어한 사람 수
            int cantPassStage = 0;  // 현재 스테이지에서 막힌 사람 수
            for (int stage : stages) {
                if (stage >= i) {
                    passStage ++;
                }
                if (stage == i) {
                    cantPassStage ++;
                }
            }
            result[i-1] = (double) cantPassStage / passStage;
            if (passStage == 0) {
                result[i-1] = 0;
            }
        }

        List<Integer> list = new ArrayList();
        /* 최대 값을 구하고 구한 최대 값을 가진 인덱스를 -1 로 바꾸어서 큰 수대로 arraylist 에 추가하였다.
        * 이 방법 말고도 새로운 클래스를 만들어서 Comparable 을 implements 하여 compareTo 메소드를 오버라이딩
        * 하여 Collections.sort 를 이용하는 방법도 있다.
        */
        int count = 0;
        while(count < result.length) {

            int max = 0;
            for (int i = 0; i < result.length; i++) {

                if (result[max] < result[i]) {
                    max = i;
                }
            }
            result[max] = -1;
            list.add(max+1);
            count++;
        }
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

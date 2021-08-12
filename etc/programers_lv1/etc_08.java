package programers_lv1;

import java.util.*;

public class etc_08 {
    // 프로그래머스 level 1: 로또의 최고 순위와 최저 순위(https://programmers.co.kr/learn/courses/30/lessons/77484)
    public int[] solution(int[] lottos, int[] win_nums) {

        int count = 0;
        int unknown = 0;
        int[] rates = new int[2];

        for (int i : lottos) {
            if ( i == 0) {
                unknown ++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) {
                    count ++;
                }
            }
        }

        int result = count;
        for (int i = 1; i >= 0; i--) {
            if (result >= 6) {
                rates[i] = 1;
            } else if(result == 5) {
                rates[i] = 2;
            } else if(result == 4) {
                rates[i] = 3;
            } else if(result == 3) {
                rates[i] = 4;
            } else if (result == 2) {
                rates[i] = 5;
            } else {
                rates[i] = 6;
            }
            result = count + unknown;
        }

        return rates;
    }

    // 신기한 다른사람 코드
    public int[] solution2(int[] lottos, int[] win_nums) {
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for (int lotto: new int[] {44, 1, 0, 0, 31, 25}) {
            if (lotto == 0) {
                zeroCount ++;
                continue;
            }
            map.put(lotto,true);    // 0이 아닌 숫자는 map에 기록
        }

        int correctCount = 0;
        for (int winNum: win_nums) {
            if(map.containsKey(winNum)) {   // 맞은 번호가 있다면 correctCount ++
                correctCount ++;
            }
        }

        int maxRank = 7 - (correctCount + zeroCount);
        int minRank = 7 - correctCount;
        if (maxRank > 6) maxRank = 6;
        if (minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}

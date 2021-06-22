public class Greedy16 {
    // 프로그래머스 lv 1: 체육복 (https://programmers.co.kr/learn/courses/30/lessons/42862)
    public int solution(int n, int[] lost, int[] reserve) {

        int def = n - lost.length;

        for (int i = 0; i < reserve.length; i++ ) {
            for (int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    def ++;
                    System.out.println(def);
                    break;
                }
            }
        }

        for (int i = 0; i<reserve.length; i++) {
            if (reserve[i] > 0) {
                for (int j = 0; j < lost.length; j++) {
                    if (lost[j] < 0) {
                        continue;
                    } else {
                        if (reserve[i] - 1 == lost[j]) {
                            lost[j] = -1;
                            System.out.println("1");
                            def ++;
                            break;
                        } else if (reserve[i] + 1 == lost[j]) {
                            lost[j] = -1;
                            System.out.println("2");
                            def ++;
                            break;
                        }
                    }
                }
            } else {
                continue;
            }
        }
        return def;
    }
}

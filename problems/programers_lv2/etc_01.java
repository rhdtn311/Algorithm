package programers_lv2;

public class etc_01 {
    // 프로그래머스 위클리 첼린지 2주차 (https://programmers.co.kr/learn/courses/30/lessons/83201)
    public String solution(int[][] scores) {

        double[] result = new double[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int max = checkMax(scores, i);
            int min = checkMin(scores, i);


            int size = scores.length;

            int sum = 0;
            for (int j = 0; j < scores.length; j++) {
                boolean checkMaxCount = checkMaxOrMinCount(scores, i, max);
                boolean checkMinCount = checkMaxOrMinCount(scores, i, min);
                if (((scores[i][i] == min && checkMinCount) || (scores[i][i] == max && checkMaxCount))) {
                    scores[i][i] = 0;
                    size--;
                }
                sum += scores[j][i];
            }
            result[i] = (double) sum / size;
        }

        String[] answer = new String[scores.length];
        int i = 0;

        StringBuilder s = new StringBuilder();
        for (double score : result) {
            if (score >= 90) s.append("A");
            else if (score >= 80) s.append("B");
            else if (score >= 70) s.append("C");
            else if (score >= 50) s.append("D");
            else s.append("F");
            i++;
        }
        return s.toString();
    }

    public int checkMax(int[][] scores, int line) {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            max = Math.max(max, scores[i][line]);
        }

        return max;
    }

    public int checkMin(int[][] scores, int line) {
        int min = 101;
        for (int i = 0; i < scores.length; i++) {
            min = Math.min(min, scores[i][line]);
        }

        return min;
    }

    public boolean checkMaxOrMinCount(int[][] scores, int line, int compareValue) {

        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][line] == compareValue) count++;
            if (count > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        etc_01 s = new etc_01();
        String solution = s.solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}});
        System.out.println(solution);
    }
}

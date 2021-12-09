package programers_lv1;

import java.util.Arrays;

public class Solution25 {
    public int solution(String dartResult) {

        int[] result = new int[3];

        StringBuilder sb = new StringBuilder();

        int index = -1;
        for (char c : dartResult.toCharArray()) {
            if (c == '*') {
                result[index] *= 2;
                if (index > 0) {
                    result[index - 1] *= 2;
                }
            } else if (c == '#') {
                result[index] *= -1;

            } else if (c == 'S') {
                int nowNum = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                result[index] = nowNum;

            } else if (c == 'D') {
                int nowNum = Integer.parseInt(sb.toString());
                result[index] = (int) Math.pow(nowNum, 2);
                sb = new StringBuilder();

            } else if (c == 'T') {
                int nowNum = Integer.parseInt(sb.toString());
                result[index] = (int) Math.pow(nowNum, 3);
                sb = new StringBuilder();

            } else {
                if (sb.length() == 0) {
                    index++;
                }

                sb.append(c);
            }

        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += result[i];
        }
        return sum;
    }
}

package programers_lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public static String solution(int[] numbers, String hand) {

        Map<Integer, NumberPad> map = new HashMap<>();

        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(num++, new NumberPad(i, j));
            }
        }
        map.put(0, new NumberPad(3, 1));
        map.put(-1, new NumberPad(3, 0));
        map.put(-2, new NumberPad(3, 2));

        StringBuilder sb = new StringBuilder();

        NumberPad nowLeft = map.get(-1);
        NumberPad nowRight = map.get(-2);
        for (int number : numbers) {

            if (number == 1 || number == 4 || number == 7) {
                sb.append('L');
                nowLeft = map.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append('R');
                nowRight = map.get(number);
            } else {

                int leftDistance = Math.abs(nowLeft.x - map.get(number).x) + Math.abs(nowLeft.y - map.get(number).y);
                int rightDistance = Math.abs(nowRight.x - map.get(number).x) + Math.abs(nowRight.y - map.get(number).y);

                if (leftDistance < rightDistance) {
                    nowLeft = map.get(number);
                    sb.append('L');
                } else if (leftDistance > rightDistance) {
                    nowRight = map.get(number);
                    sb.append('R');
                } else {
                    if (hand.equals("left")) {
                        nowLeft = map.get(number);
                        sb.append('L');
                    } else {
                        nowRight = map.get(number);
                        sb.append('R');
                    }
                }
            }
        }

        return sb.toString();
    }

    static class NumberPad {
        int x;
        int y;

        public NumberPad(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

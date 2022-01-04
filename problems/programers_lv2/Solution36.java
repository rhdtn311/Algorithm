package programers_lv2;

import java.util.Arrays;

public class Solution36 {

    public static long[] solution(long[] numbers) {

        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));

            boolean check = false;
            outer : for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    sb.setCharAt(j, '1');
                    check = true;
                    if (j == sb.length() - 1) {
                        break;
                    }
                    for (int k = j + 1; k < sb.length(); k++) {
                        if (sb.charAt(k) == '1') {
                            sb.setCharAt(k, '0');
                            break outer;
                        }
                    }
                }
            }

            if (!check) {
                sb.insert(0, '1');
                for (int j = 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == '1') {
                        sb.setCharAt(j, '0');
                        break;
                    }
                }
            }

            long value = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    value += (long) (1 * Math.pow(2, sb.length() - 1 - j));
                }
                result[i] = value;
            }
        }

        return result;
    }

}

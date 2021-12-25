package programers_lv2;

import java.util.Arrays;

public class Solution20 {
    public String solution(int[] numbers) {

        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (s1, s2) -> {
            return - Integer.compare(Integer.parseInt(s1 + s2), Integer.parseInt(s2 + s1));
        });

        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();

    }
}

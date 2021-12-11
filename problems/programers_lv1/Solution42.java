package programers_lv1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42 {
    public long solution(long n) {

        StringBuilder sb = new StringBuilder().append(n);

        String[] split = sb.toString().split("");
        Arrays.sort(split, Comparator.reverseOrder());

        sb = new StringBuilder(String.join("", split));

        return Long.parseLong(sb.toString());
    }
}

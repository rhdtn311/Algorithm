package programers_lv1;

import java.util.Arrays;

public class etc_41 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}

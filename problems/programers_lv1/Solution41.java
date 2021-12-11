package programers_lv1;

public class Solution41 {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        String[] split = sb.reverse().toString().split("");

        int[] result = new int[split.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }

        return result;
    }
}

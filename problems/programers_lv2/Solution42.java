package programers_lv2;

public class Solution42 {

    static int count = 0;
    static int result = 0;

    public static int solution(String word) {
        String[] arr = new String[]{"A", "E", "I", "O", "U"};

        comb(new StringBuilder(), arr, word);

        return result;
    }

    public static void comb(StringBuilder sb, String[] arr, String word) {

        if (sb.length() > 5) {
            return;
        }

        if (sb.toString().equals(word)) {
            result = count;
            return;
        }

        count++;
        for (int i = 0; i < 5; i++) {
            comb(sb.append(arr[i]), arr, word);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

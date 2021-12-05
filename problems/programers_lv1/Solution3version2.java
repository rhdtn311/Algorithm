package programers_lv1;

public class Solution3version2 {
    public static int solution(String s) {
        String[] words = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(words[i], numbers[i]);
        }

        return Integer.parseInt(s);
    }
}

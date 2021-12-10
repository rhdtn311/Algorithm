package programers_lv1;

import java.util.Arrays;

public class Solution33 {
    public String solution(String[] seoul) {
        int find = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + find + "에 있다";
    }
}

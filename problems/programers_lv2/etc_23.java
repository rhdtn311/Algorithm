package programers_lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class etc_23 {
    // 프로그래머스 lv 2 : 카펫
    public static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        ArrayList<Integer> measures = getMeasures(sum);
        for (int i = 0; i < measures.size(); i++) {
            int line1 = measures.get(i);
            int line2 = sum / line1;

            if ((line1 - 2) * (line2 - 2) == yellow) {
                return new int[] {Math.max(line1, line2), Math.min(line1,line2)};
            }
        }
        return null;
    }

    public static ArrayList<Integer> getMeasures(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] solution = solution(10, 2);
        System.out.println(Arrays.toString(solution));
    }
}

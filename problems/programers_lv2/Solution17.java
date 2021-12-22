package programers_lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution17 {

    public static int[] solution(String s) {
        String[] strings = s.substring(2, s.length() - 2).split("},\\{");

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> list = new ArrayList<>();
        for (String str : strings) {

            for (String c : str.split(",")) {

                if (!list.contains(Integer.parseInt(c))) {
                    list.add(Integer.parseInt(c));
                    break;
                }
            }
        }

        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}
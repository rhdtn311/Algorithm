package programers_lv2;

import java.util.*;

public class Solution12 {

    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, Integer> maxMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {

        for (int c : course) {
            maxMap.put(c, 0);
        }

        for (String order : orders) {
            String[] split = order.split("");
            Arrays.sort(split);

            String sortOrder = String.join("", split);

            combination(sortOrder, course, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1 && maxMap.get(entry.getKey().length()) == entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        return list.toArray(new String[0]);

    }

    public static void combination(String order, int[] course, int start, StringBuilder sb) {

        for (int num : course) {
            if (num == sb.length()) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

                if (maxMap.get(sb.length()) < map.get(sb.toString())) {
                    maxMap.put(sb.length(), map.get(sb.toString()));
                }
            }
        }

        for (int i = start; i < order.length(); i++) {

            combination(order, course, i + 1, sb.append(order.charAt(i)));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

package programers_lv2;

import java.util.*;

public class etc_15 {

    // 프로그래머스 lv 2 : 튜플
    public int[] solution (String s) {

        // 문자열 가공
        String[] sArray = s.substring(2, s.length() - 2).split("},\\{");

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < sArray[i].length(); j++) {
                // 해당 단어가 ,가 아니라면 덧붙혀가며 문자열을 만듦
                if (sArray[i].charAt(j) != ',') {
                    stringBuilder.append(sArray[i].charAt(j));
                }
                // 해당 단어가 ','이거나 마지막 단어라면 map에 키 값으로 해당 단어를 넣고 + 1
                if (sArray[i].charAt(j) == ',' || sArray[i].length() - 1 == j) {
                    if (map.containsKey(stringBuilder.toString())) {
                        map.put(stringBuilder.toString(), map.get(stringBuilder.toString()) + 1);
                    } else {
                        map.put(stringBuilder.toString(), 1);
                    }
                    stringBuilder = new StringBuilder();
                }
            }
        }

        Set<String> keys = map.keySet();

        // 가장 많이 나온 단어 순서대로 배열에 넣고 반환
        int[] result = new int[keys.size()];
        int index = 0;
        for (int i = keys.size(); i > 0; i--) {
            for (String key : keys) {
                if(map.get(key) == i) {
                    result[index] = Integer.parseInt(key);
                    index++;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        etc_15 s = new etc_15();
        int[] solution = s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        System.out.println(Arrays.toString(solution));
    }
}

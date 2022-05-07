package kakao2022intern;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String solution = s.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
        System.out.println(solution);
    }

    Map<Integer, Map<String, Integer>> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        for (int i = 1; i <= 4; i++) {
            map.put(i, new HashMap<>());
        }
        init();
        System.out.println(map);
        doSurvey(survey, choices);
        System.out.println(map);

        return getResult();
    }

    String getResult() {
        StringBuilder sb = new StringBuilder();

        for (int order : map.keySet()) {
            Map<String, Integer> surveyMap = map.get(order);

            String select = "";
            for (String kind : surveyMap.keySet()) {
                if (select.equals("")) select = kind;
                else {
                    if (surveyMap.get(kind) > surveyMap.get(select)) select = kind;
                    else if (surveyMap.get(kind) == surveyMap.get(select)) {
                        select = select.compareTo(kind) < 0 ? select : kind;
                    }
                }
            }
            sb.append(select);
        }

        return sb.toString();
    }

    void doSurvey(String[] survey, int[] choices) {

        for (int i = 0; i < survey.length; i++) {
            String now = survey[i];
            int score = choices[i] < 4 ? 4 - choices[i] : choices[i] > 4 ? Math.abs(4 - choices[i]) : 0;
            System.out.println("now : " + now + " score : " + score);
            String cs = "";
            Map<String, Integer> nowMap;
            if (now.equals("RT") || now.equals("TR")) {
                nowMap = map.get(1);
            } else if (now.equals("CF") || now.equals("FC")) {
                nowMap = map.get(2);
            } else if (now.equals("JM") || now.equals("MJ")) {
                nowMap = map.get(3);
            } else {
                nowMap = map.get(4);
            }

            if (choices[i] < 4) {
                cs = now.substring(0, 1);
            } else {
                cs = now.substring(1);
            }
            nowMap.put(cs, nowMap.get(cs) + score);
        }
    }

    void init() {

        map.get(1).put("R", 0);
        map.get(1).put("T", 0);
        map.get(2).put("C", 0);
        map.get(2).put("F", 0);
        map.get(3).put("J", 0);
        map.get(3).put("M", 0);
        map.get(4).put("A", 0);
        map.get(4).put("N", 0);
    }
}

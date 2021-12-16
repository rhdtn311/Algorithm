package programers_lv2;

import java.util.*;

public class Solution2 {

    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        for (String s : record) {
            String[] input = s.split(" ");

            if (input[0].equals("Enter") || input[0].equals("Change")) {
                map.put(input[1], input[2]);
            }
        }

        System.out.println(map);
        for (String s : record) {
            String[] input = s.split(" ");

            if (input[0].equals("Enter")) {
                list.add(new String(map.get(input[1])) + "님이 들어왔습니다.");
            } else if (input[0].equals("Leave")) {
                list.add(new String(map.get(input[1])) + "님이 나갔습니다.");
            }
        }

        return list.toArray(new String[0]);

    }
}

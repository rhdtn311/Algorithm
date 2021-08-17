package programers_lv2;

import java.util.*;

public class etc_06 {
    // 프로그래머스 lv2 : 오픈채팅방 (https://programmers.co.kr/learn/courses/30/lessons/42888)
    public String[] solution(String[] record) {

        Map<String, String> memberInfo = new HashMap<>();
        Stack<String> actionStack = new Stack<>();
        Stack<String> idStack = new Stack<>();

        String id;
        String action;
        String nickname = "";

        for (int i = record.length - 1; i >= 0; i--) {
            String[] info = record[i].split(" ");

            action = info[0];
            id = info[1];

            actionStack.push(action);
            idStack.push(id);

            if (!action.equals("Leave")) {
                nickname = info[2];
                if (!memberInfo.containsKey(id)) {
                    memberInfo.put(id, nickname);
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();
        while(!actionStack.isEmpty()) {
            String nowAction = actionStack.pop();

            switch (nowAction) {
                case "Enter" : nowAction = "들어왔습니다."; break;
                case "Leave" : nowAction = "나갔습니다."; break;
                case "Change" : idStack.pop(); continue;
            }

            String nowId = idStack.pop();
            String nowNickname = memberInfo.get(nowId);

            String s = nowNickname + "님이 " + nowAction;
            result.add(s);
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

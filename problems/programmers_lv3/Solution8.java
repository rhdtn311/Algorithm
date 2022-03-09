package programmers_lv3;

import java.util.*;
import java.util.regex.Pattern;

public class Solution8 {

    ArrayList<ArrayList<String>> bannedList = new ArrayList<>();
    HashSet<HashSet<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        for (String bannedId : banned_id) {
            bannedList.add(checkBannedUser(user_id, bannedId));
        }
        dfs(new HashSet<>(), 0);

        System.out.println(resultSet);

        return 0;
    }

    ArrayList<String> checkBannedUser(String[] user_id, String bannedId) {

        ArrayList<String> list = new ArrayList<>();
        String pattern = bannedId.replace("*", ".");
        for (String userId : user_id) {
            if (Pattern.matches(pattern, userId)) {
                list.add(userId);
            }
        }

        return list;
    }

    void dfs(HashSet<String> set, int depth) {

        if (depth == bannedList.size()) {
            resultSet.add(new HashSet<>(set));
            return;
        }

        for (String id : bannedList.get(depth)) {
            if (!set.contains(id)) {
                set.add(id);
                dfs(set, depth + 1);
                set.remove(id);
            }
        }
    }


}

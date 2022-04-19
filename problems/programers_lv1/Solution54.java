package programers_lv1;

import java.util.*;

public class Solution54 {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, HashSet<String>> reportedMembers = new HashMap<>();
        Map<String, Integer> getMailMembers = new HashMap<>();

        for (String id : id_list) {
            reportedMembers.put(id, new HashSet<>());
            getMailMembers.put(id, 0);
        }

        for (String info : report) {
            String[] reporterAndReported = info.split(" ");
            String reporter = reporterAndReported[0];
            String reported = reporterAndReported[1];

            reportedMembers.get(reported).add(reporter);
        }


        for (HashSet<String> reported : reportedMembers.values()) {
            if (reported.size() >= k) {
                for (String reportedMember : reported) {
                    getMailMembers.put(reportedMember, getMailMembers.get(reportedMember) + 1);
                }
            }
        }

        int[] result = new int[id_list.length];
        int index = 0;
        for (String id : id_list) {
            result[index++] = getMailMembers.get(id);
        }

        return result;
    }
}

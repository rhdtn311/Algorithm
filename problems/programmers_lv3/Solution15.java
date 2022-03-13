package programmers_lv3;

import java.util.*;

public class Solution15 {

    static int size = 0;
    static String[] answer;

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
//        String[] solution = solution15.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
//        String[] solution = solution15.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        String[] solution = solution15.solution(new String[][]{{"ICN", "ATN"}, {"ICN", "ZXY"}, {"ZXY", "ABC"}, {"ABC", "ICN"}});
        System.out.println(Arrays.toString(solution));

    }

    public String[] solution(String[][] tickets) {
        size = tickets.length;
        answer = new String[size + 1];

        Map<String, ArrayList<Airport>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                ArrayList<Airport> list = new ArrayList<>();
                list.add(new Airport(ticket[1]));
                map.put(ticket[0], list);
            } else {
                map.get(ticket[0]).add(new Airport(ticket[1]));
            }
        }

        for (ArrayList<Airport> arrived : map.values()) {
            Collections.sort(arrived);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", 0, map, list);

        return answer;
    }

    void dfs(String airport, int depth, Map<String, ArrayList<Airport>> map, ArrayList<String> list) {

        if (depth == size && answer[0] == null) {
            answer = list.toArray(new String[0]);
            return;
        }

        if (!map.containsKey(airport)) {
            return;
        }

        for (int i = 0; i < map.get(airport).size(); i++) {
            if (!map.get(airport).get(i).visited) {
                Airport next = map.get(airport).get(i);
                next.visited = true;
                list.add(next.name);
                dfs(next.name, depth + 1, map, list);
                next.visited = false;
                list.remove(list.size() - 1);
            }
        }
    }

    class Airport implements Comparable<Airport>{
        String name;
        Boolean visited;

        public Airport(String name) {
            this.name = name;
            this.visited = false;
        }

        @Override
        public int compareTo(Airport o) {
            return this.name.compareTo(o.name);
        }
    }
}

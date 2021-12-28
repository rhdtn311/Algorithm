package programers_lv2;

import java.util.*;

class Solution26 {

    public static void main(String[] args) {
        int solution = solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
        System.out.println(solution);

    }

    static List<Integer> list = new ArrayList<>();

    static public int solution(String[][] relation) {

        int row = relation.length;
        int column = relation[0].length;


        // 모든 조합을 세트에 넣는다.
        for (int i = 1; i < (1 << column); i++) {
            Set<String> set = new HashSet<>();

            if (!check(i)) {
                continue;
            }

            for (int j = 0; j < row; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < column; k++) {
                    if ((i & (1 << k)) > 0) {
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if (set.size() == row) list.add(i);
        }

        return list.size();
    }

    static boolean check(int i) {
        for (int value : list) {
            if ((value & i) == value) {
                return false;
            }
        }

        return true;
    }
}
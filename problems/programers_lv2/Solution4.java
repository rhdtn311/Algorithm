package programers_lv2;

public class Solution4 {
    static int count;

    public static int solution(int n, String[] data) {

        count = 0;
        String[] characters = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        permutation(characters, 0, new boolean[8], new StringBuilder(), data);

        return 0;
    }

    static void permutation(String[] characters, int depth, boolean[] visited, StringBuilder sb, String[] data) {

        if (depth == 8) {

            for (String condition : data) {
                char c1 = condition.charAt(0);
                char c2 = condition.charAt(2);

                int val = Character.getNumericValue(condition.charAt(4));
                char op = condition.charAt(3);

                int distance = Math.abs(sb.indexOf(String.valueOf(c1)) - sb.indexOf(String.valueOf(c2)));
                if (op == '=') {
                    if (distance != val + 1) {

                        return;
                    }
                } else if (op == '>') {
                    if (distance <= val + 1) {
                        return;
                    }
                } else {
                    if (distance >= val + 1) {
                        return;
                    }
                }
            }

            count++;
        }


        for (int i = 0; i < characters.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(characters, depth + 1, visited, sb.append(characters[i]), data);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

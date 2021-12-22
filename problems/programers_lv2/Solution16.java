package programers_lv2;

import java.util.*;

public class Solution16 {

    static List<String> priority = new ArrayList<>();

    public long solution(String expression) {

        Set<Character> all = new HashSet<>();

        List<Character> operators = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                all.add(c);
                operators.add(c);
            }
        }

        String[] split = expression.split("[+\\-*]");
        for (int i = 0; i < split.length; i++) {
            numbers.add(Long.parseLong(split[i]));
        }

        combination(all, new boolean[all.size()], new StringBuilder());

        Long max = Long.MIN_VALUE;
        for (String prior : priority) {
            Long operate = operate(prior, new ArrayList<>(operators), new ArrayList<>(numbers));
            max = Math.max(max, Math.abs(operate));
        }

        return max;
    }

    public Long operate(String priority, List<Character> operators, List<Long> numbers) {

        for (char operator : priority.toCharArray()) {
            int index = 0;

            while (index < operators.size()) {


                if (operator == '+') {
                    if (operators.get(index) == '+') {
                        numbers.set(index, numbers.get(index) + numbers.get(index + 1));
                        numbers.remove(index + 1);
                        operators.remove(index);
                        index = 0;
                    } else {
                        index++;
                    }
                } else if (operator == '-') {
                    if (operators.get(index) == '-') {
                        numbers.set(index, numbers.get(index) - numbers.get(index + 1));
                        numbers.remove(index + 1);
                        operators.remove(index);
                        index = 0;
                    } else {
                        index++;
                    }
                } else if (operator == '*') {
                    if (operators.get(index) == '*') {
                        numbers.set(index, numbers.get(index) * numbers.get(index + 1));
                        numbers.remove(index + 1);
                        operators.remove(index);
                        index = 0;
                    } else {
                        index++;
                    }
                }
            }

        }
        return numbers.get(0);
    }

    public void combination(Set<Character> all, boolean[] visited, StringBuilder sb) {
        Character[] opers = all.toArray(new Character[0]);

        if (sb.length() == all.size()) {
            priority.add(sb.toString());
            return;
        }

        for (int i = 0; i < opers.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                combination(all, visited, sb.append(opers[i]));
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}

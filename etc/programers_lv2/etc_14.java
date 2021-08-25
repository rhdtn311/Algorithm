package programers_lv2;

import java.util.*;

public class etc_14 {
    // 프로그래머스 lv 2 : 수식 최대화 (https://programmers.co.kr/learn/courses/30/lessons/67257)

    static ArrayList<String> defaultOperators = new ArrayList<>();  // 총 나오는 연산자
    static ArrayList<String> priorities = new ArrayList<>();  // 연산자들의 총 순열 경우의 수
    static String[] numbers;    // 숫자들
    static String[] operators;  // 연산자들

    public long solution(String expression) {

        // 문자열 가공
        separation(expression);
        int n = defaultOperators.size();
        permute(defaultOperators, 0, n - 1);

        long max = 0;
        for (int i = 0; i < priorities.size(); i++) {
            // 숫자들과 연산자들을 복사
            ArrayList<String> tempNums = new ArrayList<>(Arrays.asList(numbers));
            ArrayList<String> tempOps = new ArrayList<>(Arrays.asList(operators));

            // 현재 우선순위대로 차례로 연산자를 가져옴
            for (int j = 0; j < priorities.get(0).length(); j++) {
                String operator = String.valueOf(priorities.get(i).charAt(j));

                // 현재 수식에 대한 연산자를 하나씩 확인하면서 우선순위로 비교되는 연산자와 비교하여
                // 맞다면 수식을 진행하고 리스트에서 삭제한다. 리스트에서 삭제하면 인덱스가 하나씩 앞으로 밀리므로
                // 현재 인덱스를 나타내는 k의 값을 -1 해준다.
                for (int k = 0; k < tempOps.size(); k++) {
                    if (tempOps.get(k).equals(operator)) {

                        if (operator.equals("+")) {
                            long sum = Long.parseLong(tempNums.get(k)) + Long.parseLong(tempNums.get(k + 1));
                            tempOps.remove(k);
                            tempNums.set(k,String.valueOf(sum));
                            tempNums.remove(k + 1);
                        } else if (operator.equals("-")) {
                            long minus = Long.parseLong(tempNums.get(k)) - Long.parseLong(tempNums.get(k + 1));
                            tempOps.remove(k);
                            tempNums.set(k,String.valueOf(minus));
                            tempNums.remove(k + 1);
                        } else {
                            long mul = Long.parseLong(tempNums.get(k)) * Long.parseLong(tempNums.get(k + 1));
                            tempOps.remove(k);
                            tempNums.set(k,String.valueOf(mul));
                            tempNums.remove(k + 1);
                        }
                        k--;
                    }
                }

                // 우선순위에 맞게 연산이 모두 완료 됐다면 max와 비교하여 더 큰 수를 반환
                if (tempNums.size() == 1) {
                    if (Math.abs(Long.parseLong(tempNums.get(0))) > max) {
                        max = Math.abs(Long.parseLong(tempNums.get(0)));
                    }
                }
            }
        }

        return max;
    }

    public static void separation(String expression) {
        // 숫자들만 추출
        numbers = expression.split("[-+*]");
        // 연산자들만 추출
        operators = Arrays.copyOfRange(expression.split("[0-9]{1,3}"),1,expression.split("[0-9]{1,3}").length);
        // 한 번이라도 등장한 연산자
        Set<String> set = new HashSet<>(Arrays.asList(operators));
        defaultOperators.addAll(set);

    }

    // 순열
    private static void permute(ArrayList<String> arr, int l, int r) {
        if (l == r) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                s.append(arr.get(i));
            }
            priorities.add(s.toString());
            return;
        }

        // arr = {1,2,3} l = 0, r = 2
        for (int i = l; i <= r; i++) {
            // Fix an element at index l
            swap(arr, l, i);
            // Recur for index l + 1 to r
            permute(arr, l + 1, r);
            // Back track
            swap(arr, l, i);
        }
    }

    private static void swap(ArrayList<String> arr, int x, int y) {
        String temp = arr.get(x);
        arr.set(x,arr.get(y));
        arr.set(y,temp);
    }
}
package programers_lv2;

import java.util.*;

public class etc_09 {
    // 프로그래머스 lv 2 : 메뉴 리뉴얼
    public String[] solution(String[] orders, int[] course) {

        Map<String, Integer> map = new HashMap<>();
        // 모든 주문(단어)과 원하는 단어 길이 만큼의 조합 수(course)에 해당하는 모든 조합을 만듦
        for (String order : orders) {

            char[] charArray = order.toCharArray();
            boolean[] visited = new boolean[charArray.length];

            for (int numOfComb : course) {
                combination(charArray, visited, 0, numOfComb,map);
            }
        }

        // 각 조합의 길이에 따른 최대 값을 구해서 maxSizeRep에 저장
        int[] maxSizeRep = new int[course[course.length - 1] + 1];
        Set<String> keys = map.keySet();
        ArrayList<String> array = new ArrayList<>();
        for (int num : course) {
            int max = 1;
            for (String key : keys) {
                if (key.length() != num) continue;
                if (map.get(key) > max) {
                    max = map.get(key);
                }
            }
            maxSizeRep[num] = max;
        }

        // 각 조합의 길이에 따른 최대 값과 일치하는 조합을 array에 넣음
        for (int i = 1; i < maxSizeRep.length; i++) {
            if (maxSizeRep[i] == 0) continue;
            int max = maxSizeRep[i];
            for(String key : keys) {
                if (key.length() == i && map.get(key) == max && map.get(key) > 1) {
                    array.add(key);
                }
            }
        }

        // array를 정렬하여 정답 제출
        Collections.sort(array);

        String[] answer = new String[array.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = array.get(i);
        }

        return answer;
    }

    // 조합을 구하는 메서드
 /**
  * @param array : 조합을 구할 배열
  * @param visited : 배열의 해당 단어를 현재 사용하고 있는 지 체크
  * @param start : 현재 사용하고 있는 단어를 제외하고 순서대로 사용할 단어
  * @param numOfComb : 몇 개의 단어를 조합할 것인지 (갯수) ex 3 : 1,2,3 | 1,2,4 | 1,2,5 | 2,3,4 ...
  * @param map : 결과로 나온 조합을 저장할 hashmap
  * */
    public void combination(char[] array, boolean[] visited, int start, int numOfComb,Map<String, Integer> map) {

        // 원하는 조합 갯수만큼 조합을 했다면
        if (numOfComb == 0) {
            String result = makeComb(visited, array);
            if (map.containsKey(result)) {
                map.put(result, map.get(result) + 1);
            } else {
                map.put(result, 1);
            }
        } else {
            // 순서대로 조합을 한다.
            for (int i = start; i < array.length; i++) {
                visited[i] = true;  // 현재 위치를 방문했다 표시
                combination(array, visited, i+1, numOfComb-1, map); // 해당 단어의 다음 단어부터 조합
                visited[i] = false;
            }
        }
    }

    // 조합된 단어를 만듦
    public String makeComb(boolean[] visited, char[] array) {

        Arrays.sort(array);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                s.append(array[i]);
            }
        }

        return s.toString();
    }
}

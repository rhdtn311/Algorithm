package programers_lv2;

import java.util.*;

public class etc_12 {
    // 프로그래머스 lv2 : [1차] 뉴스 클러스터링 (https://programmers.co.kr/learn/courses/30/lessons/17677)
    public int solution(String str1, String str2) {

        // 해당 문자를 집합으로 만듦
        Map<String, Integer> map1 = makeSet(str1);
        Map<String, Integer> map2 = makeSet(str2);
        if (map1.size() == 0 && map2.size() == 0) return 65536;

        // 교집합 크기
        /*
        * 한 집합의 모든 원소를 돌며 다른 집합이 해당 원소를 갖고 있는지 확인하여 더 적게 갖고 있는 집합의
        * 원소를 사용
        * */
        int intersectionSize = 0;
        Set<String> keys = map1.keySet();
        for (String key : keys) {
            if (map2.containsKey(key)) {
                intersectionSize += Math.min(map1.get(key),map2.get(key));
            }
        }

        // 합집합 크기
        /*
        * 집합 1의 원소들과 집합 2의 원소들을 한 Set에 넣고 두 집합 모두 갖고 있는 원소라면
        * 더 많이 갖고 있는 원소를 합집합에 포함. 둘 중 하나만 갖고 있다면 그 갯수를 포함
        * */
        int unionSize = 0;
        Set<String> unionSet = new HashSet<>();
        unionSet.addAll(map1.keySet());
        unionSet.addAll(map2.keySet());

        for (String key : unionSet) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                unionSize += Math.max(map1.get(key), map2.get(key));
            } else {
                if (map1.containsKey(key)) {
                    unionSize += map1.get(key);
                } else {
                    unionSize += map2.get(key);
                }

            }
        }
        return (int)((double)intersectionSize / unionSize * 65536);
    }

    // 집합들과 해당 원소가 몇 번 나왔는지 체크하는 HashMap
    public static Map<String, Integer> makeSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        // 알파벳만 확인하는 정규식
        String regExp = "^[a-zA-Z]*$";

        StringBuilder element = new StringBuilder();
        char[] literals = str.toCharArray();
        for (int i = 0; i < str.length();) {
            String literal = String.valueOf(literals[i]);

            // 해당 문자가 알파벳이라면
            if (literal.matches(regExp)) {
                // 집합의 원소로 적합하기 때문에 원소에 붙힘 (대소문자를 구분하지 않음으로 대문자로 변환)
                element.append(literal.toUpperCase());
                // 원소가 두 글자라면
                if (element.length() == 2) {
                    // 해당 원소가 이미 집합 내에 저장돼있다면
                    if (map.containsKey(element.toString())) {
                        // 해당 원소 +1
                        map.put(element.toString(), map.get(element.toString()) + 1);
                    } else {
                        // 아니라면 해당 원소의 value를 1로 삽입
                        map.put(element.toString(), 1);
                    }
                    // 원소 초기화
                    element = new StringBuilder();
                } else {
                    // 원소가 2글자가 아니면 다음 문자 확인
                    i++;
                }
            } else {
                // 문자가 알파벳이 아니라면 작업 중인 원소가 있어도 초기화하고 다음 문자로 넘어감
                element = new StringBuilder();
                i++;
            }
        }

        return map;
    }
}

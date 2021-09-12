package programers_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class etc_26 {
    // 프로그래머스 lv 1 : 문자열 내 마음대로 정렬하기 (https://programmers.co.kr/learn/courses/30/lessons/12915)
    public String[] solution(String[] strings, int n) {
        ArrayList<Element> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (String s : strings) {
            list.add(new Element(s,n));
        }
        Collections.sort(list);

        for (Element e : list) {
            result.add(e.str);
        }

        return result.toArray(new String[result.size()]);
    }

    static class Element implements Comparable<Element> {
        String str;
        int n;
        char c;

        public Element(String str, int n) {
            this.str = str;
            this.n = n;
            c = str.charAt(n);
        }

        @Override
        public int compareTo(Element o) {
            if(c < o.c) {
                return -1;
            } else if (c == o.c) {
                return str.compareTo(o.str);
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        etc_26 s = new etc_26();
        String[] solution = s.solution(new String[]{"abcd","abce","cdx" }, 2);
        System.out.println(Arrays.toString(solution));
    }
}

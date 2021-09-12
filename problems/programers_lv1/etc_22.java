package programers_lv1;

import java.util.*;

public class etc_22 {
    // 프로그래머스 lv 1 : 다트 게임
    public int solution(String dartResult) {

        List<Integer> list = new ArrayList<>();
        String[] array = dartResult.split("");

        int[] result = new int[3];
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("S") || array[i].equals("D") || array[i].equals("T")) {
                continue;
            } else if (array[i].equals("*")) {
                star(list);
            } else if (array[i].equals("#")) {
                acha(list);
            } else {
                if (array[i].equals("1") && array[i+1].equals("0")) {
                    list.add(bonus(10,array[i+2]));
                } else {
                    list.add(bonus(Integer.parseInt(array[i]), array[i+1]));
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public int bonus(int num, String bonus) {
        if (bonus.equals("S")) return num;
        else if  (bonus.equals("D")) return (int)Math.pow(num,2);
        else return (int)Math.pow(num,3);
    }

    public void star(List<Integer> list) {
        if (list.size() == 1) {
            list.set(0, list.get(0) * 2);
        } else if (list.size() == 2) {
            list.set(0, list.get(0) * 2);
            list.set(1, list.get(1) * 2);
        } else {
            list.set(1, list.get(1) * 2);
            list.set(2, list.get(2) * 2);
        }
    }

    public void acha(List<Integer> list) {
        if (list.size() == 1) {
            list.set(0, -(list.get(0)));
        } else if (list.size() == 2) {
            list.set(1, -(list.get(1)));
        } else {
            list.set(2, -(list.get(2)));
        }
    }

    public static void main(String[] args) {
        etc_22 s = new etc_22();
        int solution = s.solution("1S*2T*3S");
        System.out.println(solution);
    }
}

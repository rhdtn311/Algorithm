package programers_lv1;

import java.util.*;

public class Solution12 {
    public int[] solution(int[] answers) {

        Queue<Integer> q1 = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        Queue<Integer> q2 = new LinkedList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        Queue<Integer> q3 = new LinkedList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        Student s1 = new Student(1);
        Student s2 = new Student(2);
        Student s3 = new Student(3);
        for (int answer : answers) {

            Integer poll1 = q1.poll();
            Integer poll2 = q2.poll();
            Integer poll3 = q3.poll();

            if (poll1 == answer) {
                s1.count++;
            }
            if (poll2 == answer) {
                s2.count++;
            }
            if (poll3 == answer) {
                s3.count++;
            }

            q1.offer(poll1);
            q2.offer(poll2);
            q3.offer(poll3);
        }

        List<Student> list = new ArrayList<>(List.of(s1, s2, s3));
        Collections.sort(list);

        int[] answer;
        if (list.get(0).count == list.get(1).count) {
            if (list.get(1).count == list.get(2).count) {
                answer = new int[]{1, 2, 3};
            } else {
                answer = new int[]{list.get(0).index, list.get(1).index};
            }
        } else {
            answer = new int[]{list.get(0).index};
        }

        return answer;
    }

    static class Student implements Comparable<Student> {
        int count = 0;
        int index;

        public Student(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Student o) {
            return o.count - this.count;
        }
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] std = br.readLine().split(" ");
            arr[i] = new Student(std[0], Integer.parseInt(std[1]), Integer.parseInt(std[2]), Integer.parseInt(std[3]));
        }

        Arrays.sort(arr);

        for (Student student : arr) {
            System.out.println(student.name);
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        int lang;
        int english;
        int math;

        public Student(String name, int lang, int english, int math) {
            this.name = name;
            this.lang = lang;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o1) {
            if (this.lang == o1.lang) {
                if (this.english == o1.english) {
                    if (this.math == o1.math) {
                        return this.name.compareTo(o1.name);
                    } else {
                        return o1.math - this.math;
                    }
                } else {
                    return this.english - o1.english;
                }
            } else {
                return o1.lang - this.lang;
            }        }
    }

}

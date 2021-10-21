package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Member> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Member member = new Member(Integer.parseInt(s[0]), s[1], i);
            arr.add(member);
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Member member = arr.get(i);
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.println(sb);
    }

    public static class Member implements Comparable<Member> {
        int age;
        String name;
        int seq;

        public Member(int age, String name, int seq) {
            this.age = age;
            this.name = name;
            this.seq = seq;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.seq - o.seq;
            } else {
                return this.age - o.age;
            }
        }
    }
}

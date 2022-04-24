package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main10 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];

        StringBuilder answer = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        char[] arr = str1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (str2.charAt(0) == arr[i]) list.add(i);
        }

        for (int i = 0; i < arr.length; i++) {

            int j = Integer.MAX_VALUE;
            for (Integer index : list) {
                if (Math.abs(index - i) < j) j = Math.abs(index - i);
            }

            answer.append(j).append(" ");
        }

        System.out.println(answer);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        outer : while (true) {

            Stack<Character> stack = new Stack<>();

            char[] sentence = br.readLine().toCharArray();
//            System.out.println(sentence);
            for (int i = 0; i < sentence.length; i++) {

                if (sentence[0] == '.' && sentence.length == 1) {
                    break outer;
                }

                if (sentence[i] == '(') {
                    stack.push('(');
                } else if (sentence[i] == ')') {
                    if (stack.isEmpty() || stack.peek() == '[') {
                        System.out.println("no");
                        continue outer;
                    } else {
                        stack.pop();
                    }
                } else if (sentence[i] == '[') {
                    stack.push('[');
                } else if (sentence[i] == ']') {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        System.out.println("no");
                        continue outer;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

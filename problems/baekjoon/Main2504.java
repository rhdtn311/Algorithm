package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        outer : for (String input : br.readLine().split("")) {

            if (stack.isEmpty()) {
                if (input.equals(")") || input.equals("]")) {
                    System.out.println("0");
                    System.exit(0);
                }
                stack.push(input);

            } else {

                if (input.equals("(") || input.equals("[")) {
                    stack.push(input);
                    continue;
                }

                while (!(stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[") ||stack.peek().equals("]"))) {
                    temp.push(Integer.parseInt(stack.pop()));
                    if (stack.isEmpty()) {
                        continue outer;
                    }
                }

                int value = 0;

                String now = stack.peek();
                if (input.equals(")")) {
                    if (now.equals("(")) {
                        stack.pop();

                        while (!temp.isEmpty()) {
                            value += temp.pop();
                        }

                        stack.push(value == 0 ? "2" : String.valueOf(value * 2));
                    }
                } else if (input.equals("]")) {
                    if (now.equals("[")) {
                        stack.pop();

                        while (!temp.isEmpty()) {
                            value += temp.pop();
                        }

                        stack.push(value == 0 ? "3" : String.valueOf(value * 3));

                    }
                }
            }
        }

        int result = 0;
        try {
            while (!stack.isEmpty()) {
                result += Integer.parseInt(stack.pop());
            }
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }
}

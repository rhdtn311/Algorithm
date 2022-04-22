package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char[] arr = input.toCharArray();

        int lt = 0;
        int rt = input.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (lt < rt) {
            while (!Character.isAlphabetic(arr[lt])) lt++;
            while (!Character.isAlphabetic(arr[rt])) rt--;

            char temp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = temp;

            lt++;
            rt--;
        }
        System.out.println(String.valueOf(arr));
    }
}

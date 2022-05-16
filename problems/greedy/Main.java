package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Person(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int count = 0;
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight > max) {
                max = arr[i].weight;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
}

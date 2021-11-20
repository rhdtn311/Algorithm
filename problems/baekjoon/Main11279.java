package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main11279 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MaxHeap heap = new MaxHeap();

        int N = Integer.parseInt(br.readLine());
        while (N --> 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append(heap.delete()).append('\n');
            } else {
                heap.add(input);
            }
        }

        System.out.println(sb);


    }

    static class MaxHeap {

        List<Integer> list = new ArrayList<>(List.of(0));

        int size = 0;

        public void add(int value) {
            size++;

            list.add(value);
            int index = list.size() - 1;

            while (index > 1) {
                int parentIndex = index / 2;
                if (list.get(parentIndex) < value) {
                    int temp = list.get(parentIndex);
                    list.set(parentIndex, value);
                    list.set(index, temp);
                    index = parentIndex;
                } else {
                    break;
                }
            }

        }

        public int delete() {

            if (size < 1) {
                return 0;
            }

            size--;

            int returnValue = list.get(1);
            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int index = 1;
            while (index * 2 <= size) {
                int child = index * 2;
                int value = list.get(index * 2);

                if (index * 2 + 1 <= size && value < list.get(index * 2 + 1)) {
                    child = index * 2 + 1;
                    value = list.get(child);
                }

                if (list.get(child / 2) > value) {
                    break;
                }

                list.set(child, list.get(index));
                list.set(index, value);

                index = child;
            }

            return returnValue;
        }
    }
}

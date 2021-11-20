package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1927 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        MinHeap heap = new MinHeap();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append(heap.delete()).append("\n");
            } else {
                heap.add(input);
            }
        }

        System.out.println(sb);
    }

    static class MinHeap {
        List<Integer> list = new ArrayList<>(List.of(0));
        int size = 0;

        void add(int value) {

            list.add(value);
            size++;

            int index = size;
            while (index > 1) {
                int parentIndex = index / 2;
                int parentValue = list.get(parentIndex);

                if (parentValue >= value) {

                    list.set(parentIndex, value);
                    list.set(index, parentValue);

                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        int delete() {

            if (size < 1) {
                return 0;
            }

            int returnValue = list.get(1);

            size--;

            list.set(1, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int index = 1;
            while (index * 2 <= size) {

                int childIndex = index * 2;
                int childValue = list.get(childIndex);

                if (index * 2 + 1 <= size && list.get(index * 2 + 1) < childValue) {
                    childIndex = index * 2 + 1;
                    childValue = list.get(childIndex);
                }

                if (childValue >= list.get(index)) {
                    break;
                }

                list.set(childIndex, list.get(index));
                list.set(index, childValue);

                index = childIndex;
            }

            return returnValue;
        }
    }
}

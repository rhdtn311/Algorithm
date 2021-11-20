package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main11286 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AbsoluteHeap heap = new AbsoluteHeap();

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

    public static class AbsoluteHeap {

        List<Integer> list = new ArrayList<>(List.of(0));
        int size = 0;

        public void add(int value) {

            list.add(value);
            size++;

            int index = size;
            while (index > 1) {

                int parentIndex = index / 2;

                if (Math.abs(list.get(parentIndex)) > Math.abs(list.get(index))) {

                    list.set(index, list.get(parentIndex));
                    list.set(parentIndex, value);

                    index = parentIndex;
                } else if (Math.abs(list.get(parentIndex)) == Math.abs(list.get(index))) {
                    if (list.get(parentIndex) >= list.get(index)) {

                        list.set(index, list.get(parentIndex));
                        list.set(parentIndex, value);

                        index = parentIndex;
                    } else {
                        break;
                    }
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

                int childIndex = index * 2;
                int childValue = list.get(childIndex);

                if (index * 2 + 1 <= size) {

                    if (Math.abs(childValue) > Math.abs(list.get(index * 2 + 1))) {
                        childIndex = index * 2 + 1;
                        childValue = list.get(childIndex);
                    } else if (Math.abs(childValue) == Math.abs(list.get(index * 2 + 1))) {
                        if (childValue > list.get(index * 2 + 1)) {
                            childIndex = index * 2 + 1;
                            childValue = list.get(childIndex);
                        }
                    }
                }

                if (Math.abs(childValue) < Math.abs(list.get(index))) {

                    int temp = list.get(index);
                    list.set(index, childValue);
                    list.set(childIndex, temp);

                    index = childIndex;
                } else if (Math.abs(childValue) == Math.abs(list.get(index))) {
                    if (childValue < list.get(index)) {
                        int temp = list.get(index);
                        list.set(index, childValue);
                        list.set(childIndex, temp);

                        index = childIndex;
                    } else {
                        break;
                    }
                } else {
                    break;
                }


            }

            return returnValue;
        }

    }
}

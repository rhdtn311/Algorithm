import java.io.*;

public class SortingProblem3 {
    // 백준 2750번 : 수 정렬하기 (https://www.acmicpc.net/problem/2750)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            array[i] = value;
        }
        quickSort(0, array.length - 1, array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int start, int end, int[] array) {

        if (start >= end) return;

        int left = start + 1;
        int right = end;
        int pivot = start;

        while (left <= right) {
            while (left <= end && array[pivot] >= array[left]) left++;
            while (right > start && array[pivot] <= array[right]) right--;

            if (left > right) swap(right,pivot,array);
            else swap(left, right, array);
        }
        quickSort(start, right - 1, array);
        quickSort(right + 1, end, array);
    }

    public static void swap(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

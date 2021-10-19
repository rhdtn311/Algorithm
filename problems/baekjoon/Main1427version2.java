package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1427version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }

        quickSort(arr, 0, arr.length-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            while (left <= end && arr[pivot] <= arr[left]) {
                left ++;
            }

            while (right > start && arr[pivot] >= arr[right]) {
                right--;
            }

            if (left > right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
}

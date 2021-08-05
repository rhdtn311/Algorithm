import java.util.Arrays;

public class QuickSort {
    public void quickSort(int start, int end, int[] array) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] < array[pivot]) left ++;
            while (right > start && array[right] > array[pivot]) right --;

            if (left > right) {
                swap(pivot, right, array);
            } else {
                swap(left, right, array);
            }
        }
        quickSort(start, right - 1, array);
        quickSort(right + 1, end ,array);
    }

    public void swap(int left, int right, int[] array) {
        int leftValue = array[left];
        int rightValue = array[right];
        array[left] = rightValue;
        array[right] = leftValue;
    }
}

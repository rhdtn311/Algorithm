import java.util.Arrays;

public class MergeSort {

    static int[] sorted;

    public static void main(String[] args) {
        int[] arr = {1, 4, 60, 43, 3, 6, 31, 21, -1, -41};
        merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void merge_sort(int[] a) {

        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    static void merge_sort(int[] a, int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {

            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx++] = a[r++];
            }
        } else {
            while (l <= mid) {
                sorted[idx++] = a[l++];
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}

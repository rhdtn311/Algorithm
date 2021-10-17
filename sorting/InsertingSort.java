import java.util.Arrays;

public class InsertingSort {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 2, 4, 5, 1, 3, 7};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));    // [1, 2, 3, 4, 5, 6, 7]
    }
}
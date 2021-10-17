import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 1, 2 ,3 ,5 ,2 ,4 ,9 ,0,8, 7,6, 8,9, 6, 4, 6, 6, 4, 3, 6, 8, 6};
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}

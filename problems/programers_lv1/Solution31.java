package programers_lv1;

public class Solution31 {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        quickSort(chars, 0, s.length() - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    void quickSort(char[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start + 1;
        int right = end;
        int pivot = start;

        while (left <= right) {
            while (left <= end && arr[left] >= arr[pivot]) {
                left++;
            }

            while (right > start && arr[right] <= arr[pivot]) {
                right--;
            }

            if (left > right) {
                char temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            quickSort(arr, start, right - 1);
            quickSort(arr, right + 1, end);
        }
    }
}

package programers_lv1;

public class Solution23 {


    public  String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String str1 = fill(n, Integer.toBinaryString(arr1[i]));
            String str2 = fill(n, Integer.toBinaryString(arr2[i]));

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }

    public  String fill(int n, String binaryString) {

        int length = binaryString.length();
        for (int i = 0; i < n - length; i++) {
            binaryString = '0' + binaryString;
        }

        return binaryString;
    }
}

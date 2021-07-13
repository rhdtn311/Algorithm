package array_and_string;

// 문자열의 공백에 %20을 입력
public class URLization {

    public String method1(String str) {

        StringBuilder result = new StringBuilder();
        char[] array = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (array[i] == ' ') {
                result.append("%20");
            } else {
                result.append(array[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        URLization s = new URLization();
        String mr_john_smith = s.method1("      ");
        System.out.println(mr_john_smith);
    }
}

package array_and_string;

// 반복되는 문자의 개수를 세어 출력, 만약 압축된 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환
public class String_Compression {

    public String method1(String str) {

        char nowChar = str.charAt(0);
        int duplicationCount = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (nowChar == str.charAt(i)) {
                duplicationCount++;
            } else {
                result.append(nowChar);
                result.append(duplicationCount);
                duplicationCount = 1;
                nowChar = str.charAt(i);
            }
            if (i == str.length() - 1) {
                result.append(nowChar);
                result.append(duplicationCount);
            }
        }

        return str.length() < result.length() ? str : result.toString();
    }
}

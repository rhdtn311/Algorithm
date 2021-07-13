package array_and_string;

// 문자열 두 개가 주어졌을 때 두 문자열을 같게 하기 위한 편집 횟수가 1회 이내인지 확인
public class Minus_One {

    // 삽입 : 하나를 삽입했을 때 전체 문자열이 같아지면 true
    // 수정 : 서로 다른 문자가 딱 하나이면 true
    // O(N)
    public boolean method1(String str1, String str2) {

        if (str1.length() == str2.length()) {
            return modify(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return insert(str1, str2);
        } else if (str1.length() - 1 == str2.length()) {
            return insert(str2, str1);
        }

        return false;
    }

    public boolean modify(String str1, String str2) {

        boolean checkModify = false;

        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(checkModify) {
                    return false;
                }
                checkModify = true;
            }
        }

        return true;
    }

    // aple , ape
    public boolean insert(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < str1.length() && index2 < str2.length()) {
            if(str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2 ++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    // 삽입과, 수정을 한 번에 검사
    public boolean method2(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        String s1 = str1.length() > str2.length() ? str1 : str2;
        String s2 = str1.length() > str2.length() ? str2 : str1;

        int index1 = 0;
        int index2 = 0;
        boolean checkModify = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 == index2) {
                    if (checkModify) {
                        return false;
                    } else {
                        checkModify = true;
                    }
                    index1++;
                } else {
                    return false;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}

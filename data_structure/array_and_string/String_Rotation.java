package array_and_string;

import java.util.Arrays;

// s1이 s2의 회전문자인지 확인
public class String_Rotation {

    public boolean isSubstring(String s1, String s2) {

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        if (new String(s1Array).equals(new String(s2Array))) {
            return true;
        }

        return false;
    }
}

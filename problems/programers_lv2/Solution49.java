package programers_lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution49 {
    public static String[] solution(String[] files) {

        List<File> list = new ArrayList<>();
        for (String file : files) {
            int numberIndex = 0;
            int tailIndex = 0;
            boolean isNumber = false;

            for (int i = 0; i < file.length(); i++) {
                if (!isNumber) {
                    if (Character.isDigit(file.charAt(i))) {
                        isNumber = true;
                        numberIndex = i;
                    }
                } else {
                    if (!Character.isDigit(file.charAt(i))) {
                        tailIndex = i;
                        break;
                    }
                }
            }

            tailIndex = tailIndex == 0 ? file.length() : tailIndex;
            list.add(new File(file.substring(0, numberIndex), file.substring(numberIndex, tailIndex), tailIndex == 0 ? "" : file.substring(tailIndex)));
        }

        list.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String s1 = o1.HEAD.toLowerCase();
                String s2 = o2.HEAD.toLowerCase();
                if (!s1.equals(s2)) {
                    return s1.compareTo(s2);
                } else {
                    return Integer.parseInt(o1.NUMBER) - Integer.parseInt(o2.NUMBER);
                }
            }
        });

        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).HEAD + list.get(i).NUMBER + list.get(i).TAIL;
        }

        return result;
    }


    static class File {
        private String HEAD;
        private String NUMBER;
        private String TAIL;

        public File(String HEAD, String NUMBER, String TAIL) {
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
        }
    }
}

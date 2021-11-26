package programers_lv1;

public class Solution1 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        String solution = solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(solution);

    }

    public static String solution(String new_id) {
        return seventh(sixth(fifth(fourth(third(second(first(new_id)))))));
    }

    static String first(String id) {
        for (char alpha : id.toCharArray()) {
            sb.append(Character.toLowerCase(alpha));
        }

        return sb.toString();

    }

    static String second(String id) {
        return id.replaceAll("[^[a-z]|[0-9]|\\-|_|\\.]", "");
    }

    static String third(String id) {

        return id.replaceAll("\\.+", ".");
    }

    static String fourth(String id) {

        return id.replaceAll("^\\.|\\.$", "");
    }

    static String fifth(String id) {

        return id.length() == 0 ? "a" : id;
    }

    static String sixth(String id) {
        return fourth(id.length() >= 16 ? id.substring(0, 15) : id);
    }

    static String seventh(String id) {

        if (id.length() <= 2) {
            while (id.length() <= 2) {
                id += id.charAt(id.length() - 1);
            }
        }

        return id;
    }

}

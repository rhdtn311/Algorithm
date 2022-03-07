package programmers_lv3;

import java.util.*;

public class Solution6 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String ref = referral[i];

            map.put(name, new Person(name, ref, 0));
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int price = amount[i] * 100;

            while (true) {
                int remain = price * 10 / 100;
                int got = price - remain;

                Person person = map.get(sellerName);
                if (got < 1) {
                    person.totalPrice += got;
                    break;
                } else {
                    person.totalPrice += got;
                }

                if (person.referral.equals("-")) {
                    break;
                }

                price = remain;
                sellerName = person.referral;
            }
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = map.get(enroll[i]).totalPrice;
        }

        return result;
    }

    class Person {
        String name;
        String referral;
        int totalPrice;

        public Person(String name, String referral, int totalPrice) {
            this.name = name;
            this.referral = referral;
            this.totalPrice = totalPrice;
        }
    }
}

package programers_lv1;

import java.util.*;

public class etc_09 {
    // 프로그래머스 lv1 : 신규 아이디 추천(https://programmers.co.kr/learn/courses/30/lessons/72410)
    public String solution(String new_id) {

        String first = new_id.toLowerCase();

        char[] chars = first.toCharArray();
        ArrayList<String> second = second(chars);
        ArrayList<String> third = third(second);
        ArrayList<String> fourth = fourth(third);
        ArrayList<String> fifth = fifth(fourth);
        ArrayList<String> sixth = sixth(fifth);
        ArrayList<String> seventh = seventh(sixth);

        String result ="";
        for(String s : seventh) {
            result+=s;
        }

        return result;
    }

    public ArrayList<String> second(char[] array) {

        ArrayList<String> result = new ArrayList<>();
        for (int i= 0; i < array.length; i++) {
            if (((int) array[i] >= 97 && (int) array[i] <= 122)
                    || ((int) array[i] >= 48 && (int)array[i] <= 57)
            || (int) array[i] == 45 || (int) array[i] == 46 || (int)array[i] == 95) {
                result.add(Character.toString(array[i]));
            }
        }
        return result;
    }

    public ArrayList<String> third(ArrayList<String> array) {

        int count = 0;
        ArrayList<Integer> saveRemove = new ArrayList<>();

        for (int i =0; i<array.size(); i++) {
            if(array.get(i).equals(".")) {
                count ++;
            } else {
                count = 0;
            }

            if(count == 2) {
                saveRemove.add(i);
                count--;
            }
        }

        Collections.reverse(saveRemove);
        for (int i: saveRemove) {
            array.remove(i);
        }

        return array;
    }

    public ArrayList<String> fourth(ArrayList<String> array) {

        if (array.get(0).equals(".")) {
            array.remove(0);
        }

        if(array.size()>0) {
            if (array.get(array.size() - 1).equals(".")) {
                array.remove(array.size() - 1);
            }
        }

        return array;
    }

    public ArrayList<String> fifth(ArrayList<String> array) {
        if(array.isEmpty()) {
            array.add("a");
        }

        return array;
    }

    public ArrayList<String> sixth(ArrayList<String> array) {

        while (array.size() >= 16) {
            array.remove(15);
        }

        fourth(array);

        return array;
    }

    public ArrayList<String> seventh(ArrayList<String> array) {
        while(array.size()<=2) {
            String addId = array.get(array.size() - 1);
            array.add(addId);
        }
        return array;
    }

    // 정규식을 이용한 솔루션
    public String solution2(String new_id) {

        String makeId = new_id.toLowerCase();
        makeId = makeId.replaceAll("[^-_.a-z0-9]","");
        makeId = makeId.replaceAll("[.]{2,}",".");
        makeId = makeId.replaceAll("^[.]|[.]$","");
        if(makeId.length() == 0) { makeId ="a"; }
        if(makeId.length() >= 16) {
            makeId = makeId.substring(0,15);
            makeId = makeId.replaceAll("[.]$","");
        }
        if(makeId.length() <= 2) {
            while(makeId.length()<3) {
                makeId += makeId.charAt(makeId.length() - 1);
            }
        }

        return makeId;
    }
}

package programers_lv1;

import java.util.Scanner;

// 구름 재고없는 날(https://level.goorm.io/exam/100817/15%ED%9A%8C-e-pper-3%EB%B2%88/quiz/1)

public class etc_03 {
    public static int solution(int n, int m){
        //이 아래 필요한 변수 및 필요한 코드를 작성하세요

        int answer= 0;
        int deadline = m;
        while(n > 0) {
            ++answer;
            --n;
            --deadline;
            if (deadline == 0) {
                n+=1;
                deadline = m;
            }
        }

        if (n == 0) {
            return answer;
        }


        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m= scanner.nextInt();
        int answer=solution(n,m);

        System.out.println(answer);
    }
}

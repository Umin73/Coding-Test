package 프로그래머스._5_완전탐색;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        student[] stus = new student[3];
        stus[0] = new student(1,0,new int[]{1,2,3,4,5});
        stus[1] = new student(2,0,new int[]{2,1,2,3,2,4,2,5});
        stus[2] = new student(3,0,new int[]{3,3,1,1,2,2,4,4,5,5});

        int max = 0;
        for(student s : stus) {
            for(int i=0; i<answers.length; i++) {
                if(answers[i] == s.pattern[i % s.pattern.length]) s.correctCnt++;
            }
            if(s.correctCnt > max) max = s.correctCnt;
        }

        for(student s : stus) {
            if(s.correctCnt == max) arrayList.add(s.stuNum);
        }

        return arrayList.stream().mapToInt(i->i).toArray();
    }

    static class student {
        int stuNum;
        int correctCnt;
        int[] pattern;

        public student(int stuNum, int correctCnt, int[] pattern) {
            this.stuNum = stuNum;
            this.correctCnt = correctCnt;
            this.pattern = pattern;
        }
    }
}

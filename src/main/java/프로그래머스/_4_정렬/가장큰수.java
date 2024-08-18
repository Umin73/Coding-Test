package 프로그래머스._4_정렬;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{6,10,2}));                // answer : 6210
        System.out.println(solution(new int[]{3,30,34,5,9}));           // answer : 9534330
        System.out.println(solution(new int[]{979,97,978,81,818,817})); // answer : 9799797881881817
        System.out.println(solution(new int[]{0,0,0,0}));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] numbersStr = new String[numbers.length];
        for (int i=0; i< numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numbersStr, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));

        for(String s : numbersStr) {
            answer.append(s);
        }

        return answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }
}

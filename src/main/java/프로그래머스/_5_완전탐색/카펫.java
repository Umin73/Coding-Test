package 프로그래머스._5_완전탐색;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,2)));
        System.out.println(Arrays.toString(solution(8,1)));
        System.out.println(Arrays.toString(solution(24,24)));
        System.out.println(Arrays.toString(solution(18,6)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalSize = brown + yellow;
        int width;
        int height;

        for (int i = 1; i <= totalSize/2; i++) {
            if(totalSize % i == 0) {
                if(totalSize/i >= i) {
                    width = totalSize/i;
                    height = i;

                    if((width*2) + ((height-2)*2) == brown) {
                        answer[0] = width;
                        answer[1] = height;
                    }
                }
            }
        }

        return answer;
    }
}

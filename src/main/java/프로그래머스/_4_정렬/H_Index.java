package 프로그래머스._4_정렬;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5}));             // 3
        System.out.println(solution(new int[]{0}));                     // 0
        System.out.println(solution(new int[]{3,4}));                   // 2
        System.out.println(solution(new int[]{1,2,3,5,6,7,10,11}));     // 5
        System.out.println(solution(new int[]{3,5,11,6,1,5,3,3,1,41})); // 5
        System.out.println(solution(new int[]{1,11,111,1111}));         // 3
        System.out.println(solution(new int[]{3,3,3,4}));               // 3
    }

    public static int solution(int[] citations) {
        int h_index = 0;

        Arrays.sort(citations);

        for (int j = 1; j <= citations.length; j++) {
            int count = 0;
            int h = j;
            for (int i = 0; i < citations.length; i++) {
                if (citations[citations.length - 1 - i] >= h) count++;
            }
            if (h <= count) {
                h_index = h;
            }
        }

        return h_index;
    }
}

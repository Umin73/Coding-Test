package 프로그래머스._2_스택큐;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++) {
            int stable = 0;
            for(int j=i+1;j<prices.length;j++) {
                stable++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = stable;
        }

        return answer;
    }
}

package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _주식가격 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            int sec = 0;
            for(int j=i+1; j<prices.length; j++) {
                sec++;
                if(prices[j] < prices[i]) break;
            }
            answer[i] = sec;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(" ","")
                                    .split(",");

        int[] prices = new int[input.length];
        for(int i=0; i<input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        System.out.println(Arrays.toString(solution(prices)));

        br.close();
    }
}

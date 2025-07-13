package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _1541 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] numStrs = input.split("[+-]");
        List<Character> operators = new ArrayList<>();
        for(char c : input.toCharArray()) {
            if (c == '+' || c == '-') {
                operators.add(c);
            }
        }

        int answer = Integer.parseInt(numStrs[0]);
        int boundNum = 0;
        boolean isBound = false;
        for(int i = 1; i < numStrs.length; i++) {
            int num = Integer.parseInt(numStrs[i]);

            if(operators.get(i-1) == '-') {
                if(!isBound) { // 이전 연산자가 + 였으면
                    boundNum += num;
                    isBound = true;
                } else { // 이전 연산자가 - 였으면
                    answer -= boundNum;
                    boundNum = num;
                }
            }
            else {
                if(!isBound) { // 이전 연산자가 + 였으면
                    answer += num;
                } else { // 이전 연산자가 - 였으면
                    boundNum += num;
                }
            }
        }
        if(isBound) answer -= boundNum;

        System.out.println(answer);
        br.close();
    }
}

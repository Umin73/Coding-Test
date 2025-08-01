package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _기능개발 {

    static public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        int day = (100 - progresses[0]) / speeds[0];
        if((100 - progresses[0]) % speeds[0] > 0) day += 1;
        int last = stack.push(day);
        int cnt = 1;
        for(int i = 1; i < progresses.length; i++) {
            day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0) day += 1;
            int cur = stack.push(day);

            if(cur > last) {
                answer.add(cnt);
                last = cur;
                cnt = 1;
            }
            else cnt++;
        }
        answer.add(cnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(" ", "")
                                    .split(",");

        String[] input2 = br.readLine().replace("[","")
                .replace("]","")
                .replace(" ", "")
                .split(",");

        int[] progresses = new int[input1.length];
        int[] speeds = new int[input2.length];
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = Integer.parseInt(input1[i].trim());
            speeds[i] = Integer.parseInt(input2[i].trim());
        }

        System.out.println(Arrays.toString(solution(progresses, speeds)));

        br.close();
    }
}

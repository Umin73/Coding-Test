package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _같은숫자는싫어 {

    static public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offer(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(deque.peekLast() == arr[i]) continue;
            deque.offerLast(arr[i]);
        }

        int[] answer = new int[deque.size()];
        int answerSize = deque.size();
        for(int i=0;i<answerSize;i++) {
            answer[i] = deque.pollFirst();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().replace("[","")
                                    .replace("]","")
                                    .split(",");

        int[] arr = new int[input.length];
        for(int i=0; i<input.length; i++) {
            arr[i] = Integer.parseInt(input[i].trim());
        }

        System.out.println(solution(arr));

        br.close();
    }
}

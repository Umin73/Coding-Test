package 프로그래머스._힙;

import java.io.*;
import java.util.*;

public class _더맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) pq.add(scoville[i]);

        while(pq.size() > 1) {
            if(pq.peek() >= K) return answer;
            answer++;

            int food1 = pq.poll();
            int food2 = pq.poll();

            int newFood = food1 + (food2 * 2);
            pq.add(newFood);
        }

        if(pq.peek() >= K) return answer;
        else return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(" ","")
                                    .split(",");

        int[] scovile = new int[input.length];
        for (int i = 0; i < scovile.length; i++) {
            scovile[i] = Integer.parseInt(input[i]);
        }

        int K = Integer.parseInt(br.readLine());
        System.out.println(solution(scovile, K));

        br.close();
    }
}

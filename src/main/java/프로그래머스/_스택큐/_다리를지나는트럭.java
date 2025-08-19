package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> deque = new ArrayDeque<>(bridge_length);
        for(int i = 0; i < bridge_length; i++) deque.addLast(0);

        int answer = 0;
        int curWeight = 0;
        int truckIdx = 0;

        while(truckIdx < truck_weights.length || curWeight > 0) {
            answer++;

            curWeight -= deque.removeFirst();

            if(truckIdx < truck_weights.length) {
                int next = truck_weights[truckIdx];
                if(curWeight + next <= weight) {
                    deque.addLast(next);
                    curWeight += next;
                    truckIdx++;
                } else {
                    deque.addLast(0);
                }
            } else {
                deque.addLast(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bridge_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());

        String[] truck_strs = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(" ","")
                                    .split(",");
        int[] truck_weights = new int[truck_strs.length];
        for(int i=0; i<truck_strs.length; i++){
            truck_weights[i] = Integer.parseInt(truck_strs[i]);
        }

        System.out.println(solution(bridge_length, weight, truck_weights));

        br.close();
    }
}

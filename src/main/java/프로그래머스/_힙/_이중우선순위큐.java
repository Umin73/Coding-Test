package 프로그래머스._힙;

import java.io.*;
import java.util.*;

public class _이중우선순위큐 {

    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String operation : operations) {
            String[] cur = operation.split(" ");

            if(cur[0].equals("I")) {
                pq.offer(Integer.parseInt(cur[1]));
            } else if(!pq.isEmpty()){
                if(cur[1].equals("-1")) pq.poll();
                else {
                    int maxValue = Collections.max(pq);
                    pq.remove(maxValue);
                }
            }
        }
        if(pq.isEmpty()) return new int[]{0,0};
        else return new int[]{Collections.max(pq), pq.peek()};
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] operations = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace(", ",",")
                                    .replace("\"","")
                                    .split(",");

        System.out.println(Arrays.toString(solution(operations)));

        br.close();
    }
}

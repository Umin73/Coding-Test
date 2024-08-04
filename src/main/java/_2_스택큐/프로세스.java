package _2_스택큐;

import java.util.*;

public class 프로세스 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));

    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for(int n : priorities) {
            pq.offer(n);
        }

        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;

                    if(i == location) return answer;
                }
            }
        }

        return answer;
    }

}

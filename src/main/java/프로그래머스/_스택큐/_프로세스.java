package 프로그래머스._스택큐;

import java.io.*;
import java.util.*;

public class _프로세스 {

    static class Process {
        char process;
        int priority;

        public Process(char process, int priority) {
            this.process = process;
            this.priority = priority;
        }
    }

    static public int solution(int[] priorities, int location) {
        Deque<Process> deque = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.offerLast(new Process((char) ('A'+i), priorities[i]));
        }

        int idx = priorities.length - 1;
        Arrays.sort(priorities);

        int order = 1;
        while(!deque.isEmpty()) {
            if(deque.peekFirst().priority != priorities[idx]) {
                deque.offerLast(deque.pollFirst());
            } else {
                Process p = deque.pollFirst();
                if(p.process - 'A' == location) return order;

                idx--;
                order++;
            }
        }

        return order;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().replace("[","")
                .replace("]","")
                .replace(" ","")
                .split(",");
        int location = Integer.parseInt(br.readLine());

        int[] priorities = new int[input.length];
        for (int i = 0; i < priorities.length; i++) {
            priorities[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(priorities, location));

        br.close();
    }
}

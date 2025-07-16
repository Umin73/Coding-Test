package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.offer(input);
        }

        if(pq.size() == 1) {
            System.out.println(0);
            br.close();
            return;
        }

        int sum = 0;
        while(pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.isEmpty() ? 0 : pq.poll();

            sum += n1 + n2;
            pq.offer(n1 + n2);
        }

        System.out.println(sum);
        br.close();
    }
}

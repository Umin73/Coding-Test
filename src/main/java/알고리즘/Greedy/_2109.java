package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _2109 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> { return b[0] - a[0]; }
        );
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            pq.offer(new int[]{p, d});
        }

        int sum = 0;
        int[] bookingArr = new int[10001];
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pay = cur[0];
            int day = cur[1];

            if(bookingArr[day] == 0) {
                bookingArr[day] = pay;
                sum += pay;
            } else {
                for(int i=day-1; i>=1; i--) {
                    if(bookingArr[i] == 0) {
                        bookingArr[i] = pay;
                        sum += pay;
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}

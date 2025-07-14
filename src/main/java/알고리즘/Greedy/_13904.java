package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _13904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b[1], a[1])
        );
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);

            pq.offer(new int[]{d, w});
        }

        int score = 0;
        int[] arr = new int[1001];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int w = cur[1];
            if(arr[d] == 0) {
                arr[d] = w;
                score += w;
            }
            else for(int otherDay = d-1; otherDay >=1; otherDay--) {
                if(arr[otherDay] == 0) {
                    arr[otherDay] = w;
                    score += w;
                    break;
                }
            }
        }

        System.out.println(score);
        br.close();
    }
}

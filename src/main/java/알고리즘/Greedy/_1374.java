package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _1374 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }

        list.sort((o1, o2) -> (o1[0] == o2[0]
                ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0])));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int[] cur = list.get(i);

            if(!pq.isEmpty() && cur[0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(cur[1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}

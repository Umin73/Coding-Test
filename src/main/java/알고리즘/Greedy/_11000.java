package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _11000 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> times = new ArrayList<>();

        String[] input;
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            times.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
        Collections.sort(times, (o1, o2)-> o1[0]==o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int[] time = times.get(i);
            if(!pq.isEmpty() && time[0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(time[1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}

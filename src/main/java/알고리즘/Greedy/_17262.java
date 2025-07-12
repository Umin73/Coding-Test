package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _17262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int minEnd = Integer.MIN_VALUE;
        int maxStart = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int time1 = Integer.parseInt(input[0]);
            int time2 = Integer.parseInt(input[1]);

            if(time1 > minEnd) minEnd = time1;
            if(time2 < maxStart) maxStart = time2;
        }

        if(minEnd - maxStart < 0) System.out.println(0);
        else System.out.println(minEnd - maxStart);
        br.close();
    }
}

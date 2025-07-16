package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            weight[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(weight);

        int sum = 0;
        int answer = -1;
        for(int i=0; i<N; i++) {
            if(weight[i] <= sum + 1) sum += weight[i];
            else answer = sum + 1;
        }
        if(answer == -1) answer = sum + 1;

        System.out.println(answer);
        br.close();
    }
}

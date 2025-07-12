package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = arr[N-1];
        for(int i=1; i<N; i++) {
            if(arr[N-1-i]*(i+1) > answer) answer = arr[N-1-i] * (i+1);
        }

        System.out.println(answer);
        br.close();
    }
}

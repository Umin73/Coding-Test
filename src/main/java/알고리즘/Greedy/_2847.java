package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _2847 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[N-1-i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=1; i<N; i++) {
            if(arr[i] >= arr[i-1]) {
                answer += arr[i] - arr[i-1] + 1;
                arr[i] = arr[i-1]-1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}

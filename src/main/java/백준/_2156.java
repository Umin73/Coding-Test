package 백준;

import java.io.*;

public class _2156 {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if(N == 1) {
            System.out.println(dp[0]);
            return;
        }

        dp[1] = arr[0] + arr[1];
        if(N == 2) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = Math.max(arr[0],arr[1]) + arr[2];
        if(dp[2]<dp[1]) dp[2] = dp[1];
        if(N==3) {
            System.out.println(dp[2]);
            return;
        }

        for(int i=3; i<N; i++) {
            dp[i] = Math.max(dp[i-2]+arr[i], arr[i]+arr[i-1]+dp[i-3]);
            if(dp[i] < dp[i-1]) dp[i] = dp[i-1];
        }

        System.out.println(dp[N-1]);

        br.close();
    }
}

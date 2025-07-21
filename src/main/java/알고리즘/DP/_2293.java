package 알고리즘.DP;

import java.io.*;

public class _2293 {

    static int N, K;
    static int[] moneyArr;
    static int[][] dp;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        dp = new int[K+1][101];
        moneyArr = new int[N];
        for(int i=0; i<N; i++) {
            moneyArr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<=K; i++) {
            if(i % moneyArr[0] == 0) dp[i][0] = 1;
        }
        for(int i=1; i<N; i++) {
            dp[0][i] = dp[0][0];
        }

        for(int i=1; i<N; i++) {
            for(int j=1; j<=K; j++) {
                if(j < moneyArr[i]) dp[j][i] = dp[j][i-1];
                else dp[j][i] = dp[j][i-1] + dp[j - moneyArr[i]][i];
            }
        }
        System.out.println(dp[K][N-1]);

        br.close();
    }
}

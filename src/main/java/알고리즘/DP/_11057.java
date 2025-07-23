package 알고리즘.DP;

import java.io.*;

public class _11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][0];
            for(int j=1; j<10; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
            }
        }

        int answer = 0;
        for(int i=0; i<10; i++) answer += dp[N][i];

        System.out.println(answer % 10007);

        br.close();
    }
}

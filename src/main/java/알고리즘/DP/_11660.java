package 알고리즘.DP;

import java.io.*;

public class _11660 {

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + Integer.parseInt(input[j-1]) - dp[i-1][j-1];
            }
        }

        while(M-- > 0) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int answer = dp[x2][y2] - (dp[x1-1][y2] + dp[x2][y1-1] - dp[x1-1][y1-1]);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

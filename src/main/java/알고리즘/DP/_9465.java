package 알고리즘.DP;

import java.io.*;

public class _9465 {

    static int T, N;
    static int[][] arr, dp;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N+1];
            dp = new int[2][N+1];

            for(int i=0; i<2; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=1; j<=N; j++) {
                    arr[i][j] = Integer.parseInt(input[j-1]);
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }

        br.close();
    }
}

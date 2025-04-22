package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2193 {
    static int N;
    static long answer;
    static long[] dp;
//
//    static long solution(int curIdx) {
//      if(curIdx == 1 || curIdx == 2) return 1;
//      if(dp[curIdx] != 0) return dp[curIdx];
//      dp[curIdx] = solution(curIdx-1) + solution(curIdx-2);
//      return dp[curIdx];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

//        answer = solution(N);

        dp[1] = 1;
        if(N>=2) dp[2] = 1;

        for(int i=3;i<=N;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
        br.close();
    }
}

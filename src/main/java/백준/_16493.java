package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;

public class _16493 {
    static int N, M;
    static int[][] info;
    static int[] dp; // dp[i]: i일 동안 최대로 읽을 수 있는 페이지 수

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 반납까지 남은 기간
        M = Integer.parseInt(input[1]); // 챕터의 수

        dp = new int[N+1];
        info = new int[M][2];
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(input[0]); // 챕터 읽는데 소요되는 일 수
            info[i][1] = Integer.parseInt(input[1]); // 챕터의 페이지 수
        }

        for(int i=0; i<M; i++) {

            for(int j=N; j>= info[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j-info[i][0]]+info[i][1]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}

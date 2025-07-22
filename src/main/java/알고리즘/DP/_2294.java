package 알고리즘.DP;

import java.io.*;
import java.util.*;

public class _2294 {

    static int N, K;
    static int[] coinArr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        coinArr = new int[N];
        for(int i=0; i<N; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[K+1]; // dp[i] = i원을 만들기 위한 최소 동전 개수
        Arrays.fill(dp, Integer.MAX_VALUE); // 일단 최대값들로 초기화
        dp[0] = 0; // 0원을 만들기 위해 동전 0개 필요

        for(int i=0; i<N; i++) {
            for(int j=coinArr[i]; j<=K; j++) {
                if(dp[j - coinArr[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coinArr[i]] + 1);
                }
            }
        }

        if(dp[K] != Integer.MAX_VALUE && dp[K] >= 0) System.out.println(dp[K]);
        else System.out.println("-1");

        br.close();
    }
}

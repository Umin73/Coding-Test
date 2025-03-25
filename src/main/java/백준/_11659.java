package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11659 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        arr = new int[N+1];
        arr[0] = 0;
        for(int i=1; i<=N; i++) {
            int curNum = Integer.parseInt(input[i-1]);
            arr[i] = arr[i-1]+curNum;
        }

        int startIdx, endIdx;
        while(M-- > 0) {
            input = br.readLine().split(" ");
            startIdx = Integer.parseInt(input[0]);
            endIdx = Integer.parseInt(input[1]);

            sb.append(arr[endIdx] - arr[startIdx-1]).append("\n");

        }
        System.out.println(sb);

        br.close();
    }
}

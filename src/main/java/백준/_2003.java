package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2003 {
    static int N, M;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(input[i]);
        }

        int p1 = 0, p2 = 0;
        int tempSum = 0;
        while (p1 < N) { // 슬라이딩 윈도우(연속된 부분 배열)를 조절하는 방식!
            // p2를 증가시키면서 tempSum이 M 이상이 될때까지 값을 더함
            while (p2 < N && tempSum < M) { // tempSum >= M이 되거나 p2 == M이 될 때까지 p2가 이동
                tempSum += arr[p2++];
            }
            if (tempSum == M) answer++;
            tempSum -= arr[p1++]; // p1을 증가시키면서 슬라이딩 윈도우의 시작점을 조절

            // p1이 증가하면서 tempSum을 줄이기 때문에 p2를 줄일 필요가 없음

        }
        System.out.println(answer);
        br.close();
    }
}

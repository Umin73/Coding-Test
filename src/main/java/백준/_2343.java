package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2343 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 강의 수
        M = Integer.parseInt(input[1]); // 블루레이 수

        int right = 0, left = 1;
        int answer = Integer.MAX_VALUE;
        input = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            right += arr[i];
        }

        while(left <= right) {
            int mid = (left+right)/2;
            int temp = 0;
            int cnt = 0;
            int tempMax = 0;
            boolean flag = false;
            for(int i=0; i<N; i++) {
                temp += arr[i];
                if(temp >= mid) {
                    cnt++;
                    tempMax = Math.max(tempMax, temp);
                    temp = 0;
                    flag = true;
                }

                if(i == N-1 && temp<mid) {
                    flag = false;
                }
            }
            if(cnt >= M && flag) {
                answer = Math.min(answer, tempMax);
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        System.out.println(answer);

        br.close();
    }
}

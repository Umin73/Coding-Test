package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1253 {
    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++) { // 인덱스가 i인 값이 target(합이 되는 값)
            int target = arr[i];
            int p1 = 0, p2 = N-1;

            while(p1 < p2) {
                if(p1 == i) {
                    p1++;
                    continue;
                }
                if(p2 == i) {
                    p2--;
                    continue;
                }

                int tempSum = arr[p1] + arr[p2];
                if(tempSum == target) {
                    answer++;
                    break;
                } else if(tempSum > target) {
                    p2--;
                    // tempSum이 target보다 크니까 tempSum을 줄여야 함
                    // -> p2를 줄여서 다음 tempSum의 값을 줄임
                } else {
                    p1++;
                    // tempSum이 target보다 작으니까 tempSum을 키워야 함
                    // -> p1을 올려서 다음 tempSum의 값을 키움
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
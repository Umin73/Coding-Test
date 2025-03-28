package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1806 {
    static int N, S;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N+1];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i+1] = arr[i] + Integer.parseInt(input[i]);
            /*
            * 05 01 03 05 10 04 09 02 08
            * 05 06 09 14 24 28 37 39 47
            * i~j의 합은 arr[j] - arr[i-1]
            * */
        }

        int p1 = 0, p2 = 1;
        int tempSum;
        while (p2 <= N) {
            tempSum = arr[p2] - arr[p1];
            if(tempSum >= S){
                answer = Math.min(answer, (p2-p1));
                if(answer == 1) break;
                p1++;
            } else if(tempSum < S) {
                p2++;
            }
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
        br.close();
    }
}

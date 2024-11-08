package SWEA.D2;

import java.util.Scanner;

public class SWEA_1859 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }

            long answer = 0;
            long butCost = 0;
            int buyCnt = 0;
            long maxNum = 0;
            for(int i=n-1; i>=0; i--) {
                if(arr[i] > maxNum) {
                    answer += ((long) maxNum *buyCnt) - butCost;
                    maxNum = arr[i];
                    butCost = 0;
                    buyCnt = 0;
                } else {
                    butCost += arr[i];
                    buyCnt++;
                }
            }
            answer += ((long) maxNum *buyCnt) - butCost;

            System.out.println("#" + test_case + " " + answer);
        }
    }
}

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

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long max = Long.MIN_VALUE;
            int buyCnt = 0;
            long buyCost = 0;
            long result = 0;
            for (int i = n-1; i >= 0; i--) {
                if(arr[i] > max) {
                    result += (max*buyCnt) - buyCost;
                    max = arr[i];
                    buyCnt = 0;
                    buyCost = 0;
                }
                else {
                    buyCost += arr[i];
                    buyCnt++;
                }
            }
            result += (max*buyCnt) - buyCost;
            System.out.println("#" + test_case + " " + result);
        }
    }
}

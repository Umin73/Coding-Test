package SWEA.D3;

import java.util.Scanner;

public class SWEA_1206 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
/*        int T;
        T=sc.nextInt();*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            int result = 0;
            int[] buildings = new int[n];

            for(int i = 0; i < n; i++) {
                int input = sc.nextInt();
                buildings[i] = input;
            }

            for(int i = 2; i<n-2; i++) {
                int left = (buildings[i] - Math.max(buildings[i-1], buildings[i-2]));
                int right = (buildings[i] - Math.max(buildings[i+1], buildings[i+2]));

                if (left < 0 || right < 0) continue;
                result += Math.min(left, right);
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
}

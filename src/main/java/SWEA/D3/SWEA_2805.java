package SWEA.D3;

import java.util.Scanner;

public class SWEA_2805 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            sc.nextLine();

            for(int i = 0; i < n; i++) {
                String input = sc.next();
                String[] inputArr = input.split("");
                int inputIdx = 0;
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputArr[inputIdx++]);
                }
            }

            int answer = 0;
            int middle = n - (n/2)-1;
            int range = 0;
            for(int i=0; i<n; i++) {
                answer += arr[i][middle];
                for(int j=1; j<=range; j++) {
//                    System.out.println("middle-j: " + (middle-j));
//                    System.out.println("middle+j"+(middle+j));
                    answer += arr[i][middle-j];
                    answer += arr[i][middle+j];
                }
                if(i >= middle) range--;
                else range++;
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}

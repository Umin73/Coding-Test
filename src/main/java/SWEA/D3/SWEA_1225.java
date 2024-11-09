package SWEA.D3;

import java.util.Scanner;

public class SWEA_1225 {

    static int[] arr;

    public static void move(int minus) {
        if(arr[0] - minus <= 0) arr[0] = 0;
        else arr[0] = arr[0] - minus;

        int temp = arr[0];
        for(int i=1;i<arr.length;i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int t = sc.nextInt();

            arr = new int[8];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            int cur = arr[0];
            int minusCnt = 1;
            while(cur > 0) {
                move(minusCnt++);
                if(minusCnt > 5) minusCnt = 1;
                cur = arr[arr.length-1];
            }

            System.out.print("#" + t + " ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

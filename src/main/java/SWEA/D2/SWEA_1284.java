package SWEA.D2;

import java.util.Scanner;

public class SWEA_1284 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int p = sc.nextInt(); // A사에 1L당 내야하는 금액
            int q = sc.nextInt(); // B사의 기본 요금
            int r = sc.nextInt(); // B사의 기본 요금에 해당하는 리터
            int s = sc.nextInt(); // B사의 1L당 요금
            int w = sc.nextInt(); // 사용하는 수도의 양

            int A = w * p;
            int B = (w <= r) ? q : (q+((w-r)*s));
            int result = Math.min(A,B);

            System.out.println("#"+test_case+" "+result);
        }
    }
}

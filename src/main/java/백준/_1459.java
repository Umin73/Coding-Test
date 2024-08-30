package 백준;

import java.util.Scanner;

public class _1459 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        long Y = sc.nextLong();
        long W = sc.nextLong();
        long S = sc.nextLong();

        long minD = Math.min(X, Y);
        long maxD = Math.max(X, Y);
        long totalD = X + Y;

        // 모두 한 블럭씩 걸어가는 경우
        long onlyBlock = totalD * W;

        // (minD, minD)까지 가로질러 간 후 나머지는 한 블럭씩 가는 경우
        long crossAndBlock = minD * S + (maxD - minD) * W;

        // 모두 대각선으로 걸어가는 경우(단, 크로스 할 블록이 홀수개인 경우, 마지막은 블럭을 걸어서 감)
        long onlyCross = ((totalD & 1) == 0) ? maxD * S : ((maxD - 1) * S) + W;

        System.out.println(Math.min(onlyBlock, Math.min(crossAndBlock, onlyCross)));
    }

}

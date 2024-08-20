package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7569 {

    public static class Tomato {
        int isRipen;    // 익었는지 유무
        int m;  // 가로 위치 정보
        int n;  // 세로 위치 정보
        int h;  // 높이 위치 정보
    }
    public static class Box {
        int[][] box;
    }
    static Box[] boxes = new Box[101];
    static int M, N, H;
    static int totalTomato = 0;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();   // 가로
        N = sc.nextInt();   // 세로
        H = sc.nextInt();   // 높이
        int start = -1;


        System.out.println(isRipe());
    }

    static void solution() {

    }

    static int isRipe() {
        return -1;
    }
}

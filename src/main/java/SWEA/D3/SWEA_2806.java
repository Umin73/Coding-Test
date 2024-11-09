package SWEA.D3;

import java.util.Scanner;

public class SWEA_2806 {

    static int[][] arr;
    boolean[][] board;
    static int answer;

    public static void setPosOfQueen(boolean[][] board) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(!board[i][j]);
            }
        }
    }

    public static void isPossibleToAttack() {
        int length = arr.length;
        boolean[][] board = new boolean[length][length];

        int r=0, c=0;
        for(int i = 0; i < arr.length; i++) {

            // 말 놓기

            answer++;
            // 가로 줄 false
            for(int j = 0; j < arr[i].length; j++) {
                board[r][j] = false;
            }

            // 세로 줄 false
            for(int j = 0; j < arr[i].length; j++) {
                board[j][c] = false;
            }

            // 대각선 false
            for(int j = 1; j < arr[i].length; j++) {
                if(r+j<length && c+j<length)
                    board[r+j][c+j] = false;

                if(r-j>=0 && c-j>=0)
                    board[r-j][c-j] = false;

                if(r-j>=0 && c+j<length)
                    board[r-j][c+j] = false;

                if(r+j < length && c-j>=0)
                    board[r+j][c-j] = false;
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            arr = new int[n][n];
            answer = n * n;
            isPossibleToAttack();
        }
    }
}

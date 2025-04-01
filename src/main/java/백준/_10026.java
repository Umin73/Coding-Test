package 백준;

import java.io.*;

public class _10026 {
    static int N;
    static char[][] arr;
    static char[][] arrB;
    static int[][] visitedA;
    static int[][] visitedB;
    static int answer1 = 0, answer2 = 0;

    static void dfsA(int idxA, int idxB, char color, int level) {
        visitedA[idxA][idxB] = level;

        if(visitedA[idxA+1][idxB] == 0 && arr[idxA+1][idxB] == color) dfsA(idxA+1, idxB, color, level);
        if(visitedA[idxA][idxB+1] == 0 && arr[idxA][idxB+1] == color) dfsA(idxA, idxB+1, color, level);
        if(visitedA[idxA-1][idxB] == 0 && arr[idxA-1][idxB] == color) dfsA(idxA-1, idxB, color, level);
        if(visitedA[idxA][idxB-1] == 0 && arr[idxA][idxB-1] == color) dfsA(idxA, idxB-1, color, level);
    }

    static void dfsB(int idxA, int idxB, char color, int level) {
        visitedB[idxA][idxB] = level;

        if(visitedB[idxA+1][idxB] == 0 && arrB[idxA+1][idxB] == color) dfsB(idxA+1, idxB, color, level);
        if(visitedB[idxA][idxB+1] == 0 && arrB[idxA][idxB+1] == color) dfsB(idxA, idxB+1, color, level);
        if(visitedB[idxA-1][idxB] == 0 && arrB[idxA-1][idxB] == color) dfsB(idxA-1, idxB, color, level);
        if(visitedB[idxA][idxB-1] == 0 && arrB[idxA][idxB-1] == color) dfsB(idxA, idxB-1, color, level);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visitedA = new int[N+2][N+2];
        visitedB = new int[N+2][N+2];
        arr = new char[N+2][N+2];
        arrB = new char[N+2][N+2];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                char curInput = input.charAt(j-1);
                arr[i][j] = curInput;
                arrB[i][j] = curInput == 'G' ? 'R' : curInput;
            }
        }

        // 적록색약인 사람은 빨강초록, 파랑으로만 구분 가능
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(visitedA[i][j] == 0) dfsA(i, j, arr[i][j], ++answer1);
                if(visitedB[i][j] == 0) dfsB(i, j, arrB[i][j], ++answer2);
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
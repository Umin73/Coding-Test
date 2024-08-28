package 백준;

import java.util.Scanner;

public class _14503 {

    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solution(r, c, d);
        System.out.println(answer);
    }

    public static void solution(int row, int col, int dir) {
        // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소함
        if(map[row][col] == 0) {
            map[row][col] = 2;
            answer++;
        }

        // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        boolean isClean = false;
        int initialDir = dir;
        int nextR;
        int nextC;
        int nextD;
        for (int i = 0; i < 4; i++) {
            nextD = (dir + 3) % 4;
            nextR = row + dr[nextD];
            nextC = col + dc[nextD];
            if(nextR < 0 || nextC < 0 || nextR >=N || nextC >= M) continue;
            if(map[nextR][nextC] == 0) {
                solution(nextR, nextC, nextD);
                isClean = true;
                break;
            }
            dir = (dir + 3) % 4;
        }

        // 2.현재 칸의 주변 4칸 중 청소될 수 있는 칸이 모두 청소되었으면
        //  1) 바라보는 방향을 유지한 채로 한 칸 후진하고 1번으로
        if(!isClean) {
            nextD = (initialDir + 2) % 4;   // 후진할 위치를 구하기 위해 nextD 구함
            nextR = row + dr[nextD];
            nextC = col + dc[nextD];
            if(nextR > 0 && nextC > 0 && nextR < N && nextC < M) {
                if(map[nextR][nextC] != 1) {
                    solution(nextR, nextC, initialDir);
                }
            }
        }
    }
}

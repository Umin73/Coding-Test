package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _4179 {

    static int R, C;
    static char[][] map;
    static int[][] jihoonArr, fireArr;
    static boolean[][] jihoonVisited, fireVisited;

    static int getAnswer() {
        int minTime = Integer.MAX_VALUE;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(i == 0 || j == 0 || i == R - 1 || j == C - 1) {
                    if(jihoonArr[i][j] >= 1 && (fireArr[i][j] == 0 || jihoonArr[i][j] < fireArr[i][j])) {
                        minTime = Math.min(minTime, jihoonArr[i][j]);
                    }
                }
            }
        }
        return minTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C];
        jihoonArr = new int[R][C];
        fireArr = new int[R][C];
        jihoonVisited = new boolean[R][C];
        fireVisited = new boolean[R][C];

        Deque<int[]> fireDeque = new ArrayDeque<>();
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < R; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j].charAt(0);
                if(map[i][j] == 'J') {
                    deque.offerLast(new int[]{i, j});
                    jihoonArr[i][j] = 1;
                    jihoonVisited[i][j] = true;
                } else if(map[i][j] == 'F') {
                    fireDeque.offerLast(new int[]{i, j});
                    fireArr[i][j] = 1;
                    fireVisited[i][j] = true;
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int curY = cur[0];
            int curX = cur[1];


            for(int[] dir : dirs) {
                int nextY = curY + dir[0];
                int nextX = curX + dir[1];

                if(nextY >= 0 && nextY < R && nextX >=0 && nextX < C
                    && !jihoonVisited[nextY][nextX] && map[nextY][nextX] == '.'
                    && jihoonArr[nextY][nextX] == 0) {
                    deque.offerLast(new int[]{nextY, nextX});
                    jihoonVisited[nextY][nextX] = true;
                    jihoonArr[nextY][nextX] = jihoonArr[curY][curX] + 1;
                }
            }
        }

        while(!fireDeque.isEmpty()) {
            int[] cur = fireDeque.pollFirst();
            int curY = cur[0];
            int curX = cur[1];

            for(int[] dir : dirs) {
                int nextY = curY + dir[0];
                int nextX = curX + dir[1];

                if(nextY >= 0 && nextY < R && nextX >=0 && nextX < C
                        && !fireVisited[nextY][nextX] && map[nextY][nextX] == '.'
                        && fireArr[nextY][nextX] == 0) {
                    fireDeque.offerLast(new int[]{nextY, nextX});
                    fireVisited[nextY][nextX] = true;
                    fireArr[nextY][nextX] = fireArr[curY][curX] + 1;
                }
            }
        }

        int answer = getAnswer();
        if(answer == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);

        br.close();
    }
}

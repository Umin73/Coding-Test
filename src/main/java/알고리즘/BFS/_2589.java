package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _2589 {

    static int H, W;
    static char[][] map;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);

        map = new char[H][W];

        for(int i=0; i<H; i++) {
            input = br.readLine().split("");
            for(int j=0; j<W; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        int answer = 0;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(map[i][j] == 'L') {
                    arr = new int[H][W];
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.addLast(new int[]{i, j});
                    arr[i][j] = 1;

                    int distance = 0;
                    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
                    while(!deque.isEmpty()) {
                        int[] cur = deque.pollFirst();
                        int curY = cur[0];
                        int curX = cur[1];
                        distance = Math.max(distance, arr[curY][curX] - 1);

                        for (int[] dir : dirs) {
                            int nextY = curY + dir[0];
                            int nextX = curX + dir[1];
                            if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W
                                    && map[nextY][nextX] == 'L' && arr[nextY][nextX] == 0) {
                                deque.addLast(new int[]{nextY, nextX});
                                arr[nextY][nextX] = arr[curY][curX] + 1;
                            }
                        }
                    }
                    answer = Math.max(answer, distance);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}

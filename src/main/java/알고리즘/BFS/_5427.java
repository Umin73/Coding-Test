package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _5427 {

    static int H, W;
    static char[][] map;
    static int[][] sanggeun, fire;
    static Deque<int[]> sanggeunDeque;
    static Deque<int[]> fireDeque;

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int findAnswer(int[][] sanggeun, int[][] fire) {
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if((i == 0 || i == H-1 || j==0 || j == W-1)&& (map[i][j] == '.' || map[i][j] == '@')) {
                    if(sanggeun[i][j] >= 1) {
                        if(fire[i][j] == 0 || sanggeun[i][j] < fire[i][j]) {
                            answer = Math.min(answer, sanggeun[i][j]);
                        }
                    }
                }
            }
        }
        return answer;
    }

    static int[][] bfs(int[][] arr, Deque<int[]> deque) {
        while(!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int curY = cur[0];
            int curX = cur[1];

            for(int[] dir : dirs) {
                int nextY = curY + dir[0];
                int nextX = curX + dir[1];

                if(nextY >=0 && nextY < H && nextX >=0 && nextX < W
                        && map[nextY][nextX] != '#' && arr[nextY][nextX] == 0) {
                    deque.offerLast(new int[]{nextY, nextX});
                    arr[nextY][nextX] = arr[curY][curX] + 1;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String[] input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);

            map = new char[H][W];
            sanggeun = new int[H][W];
            fire = new int[H][W];

            sanggeunDeque = new ArrayDeque<>();
            fireDeque = new ArrayDeque<>();
            for (int i = 0; i < H; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < W; j++) {
                    map[i][j] = input[j].charAt(0);
                    if(map[i][j] == '@') {
                        sanggeunDeque.addLast(new int[]{i, j});
                        sanggeun[i][j] = 1;
                    }
                    else if(map[i][j] == '*') {
                        fireDeque.addLast(new int[]{i, j});
                        fire[i][j] = 1;
                    }
                }
            }

            sanggeun = bfs(sanggeun, sanggeunDeque);
            fire = bfs(fire, fireDeque);

            int answer = findAnswer(sanggeun, fire);
            if(answer == Integer.MAX_VALUE) sb.append("IMPOSSIBLE");
            else sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}

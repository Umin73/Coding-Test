package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,1});
        visited[1][1] = true;

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];

            if(curY == N && curX == M) {
                break;
            }

            for(int i=0; i<4; i++) {
                int nextY = curY + dirs[i][0];
                int nextX = curX + dirs[i][1];
                if(nextY >= 1 && nextY <=N && nextX >=1 && nextX <=M
                    && !visited[nextY][nextX] && arr[nextY][nextX] != 0) {
                    queue.offer(new int[]{nextY,nextX});
                    visited[nextY][nextX] = true;
                    arr[nextY][nextX] = arr[curY][curX] + 1;
                }
            }
        }

        System.out.println(arr[N][M]);

        br.close();
    }
}

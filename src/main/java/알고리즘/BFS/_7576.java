package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _7576 {

    static int M, N;
    static int[][] arr;

    static boolean hasUnripe() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) return true;
            }
        }
        return false;
    }

    static int findAnswer() {
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] > answer) answer = arr[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); // 가로
        N = Integer.parseInt(input[1]); // 세로

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        if(!hasUnripe()) {
            System.out.println(0);
            br.close();
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<dirs.length;i++) {
                int nextY = curY + dirs[i][0];
                int nextX = curX + dirs[i][1];

                if(nextY >=0 && nextY < N && nextX >=0 && nextX < M
                    && arr[nextY][nextX] == 0) {
                    queue.offer(new int[]{nextY, nextX});
                    arr[nextY][nextX] = arr[curY][curX] + 1;
                }
            }
        }

        System.out.println(hasUnripe() ? -1 : findAnswer()-1);

        br.close();
    }
}

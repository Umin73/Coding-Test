package 알고리즘.DFS;

import java.io.*;

public class _4963 {

    static int W, H;
    static int[][] arr;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0,1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};

    public static void dfs(int curY, int curX) {
        if(arr[curY][curX] == 0) return;

        arr[curY][curX] = 0;
        for(int i=0; i<dirs.length; i++) {
            int nextY = curY + dirs[i][0];
            int nextX = curX + dirs[i][1];
            if(nextY >= 0 && nextY < H && nextX >= 0 && nextX < W) {
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);

            if(W == 0 && H == 0) break;

            arr = new int[H][W];
            for(int i=0; i<H; i++) {
                input = br.readLine().split(" ");
                for(int j=0; j<W; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            int cnt = 0;
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(arr[i][j] == 1) {
                        dfs(i, j);
                        cnt += 1;
                    }
                }
            }
            System.out.println(cnt);
        }

        br.close();
    }
}

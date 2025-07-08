package 알고리즘.DFS;

import java.io.*;

public class _16173 {

    static int N;
    static int[][] arr;
    static boolean isSuccess = false;

    static void dfs(int curY, int curX) {
        if(arr[curY][curX] == -2) return;
        if(arr[curY][curX] == -1) {
            isSuccess = true;
            return;
        }

        int jump = arr[curY][curX];
        int[][] dirs = {{1, 0}, {0,1}};

        arr[curY][curX] = -2;

        for (int i=0; i<2; i++) {
            int nextY = curY + (dirs[i][0] * jump);
            int nextX = curX + (dirs[i][1] * jump);
            if(nextY >=0 && nextY < N && nextX >=0 && nextX < N) {
                dfs(nextY, nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0, 0);
        System.out.println(isSuccess ? "HaruHaru" : "Hing");

        br.close();
    }
}

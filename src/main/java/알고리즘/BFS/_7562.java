package 알고리즘.BFS;

import java.io.*;
import java.util.*;

public class _7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2,1}, {1,2}};
        while(T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            int[][] arr = new int[l][l];
            boolean[][] visited = new boolean[l][l];

            String[] input = br.readLine().split(" ");
            int curY = Integer.parseInt(input[0]);
            int curX = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int targetY = Integer.parseInt(input[0]);
            int targetX = Integer.parseInt(input[1]);

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{curY, curX});
            visited[curY][curX] = true;

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();

                if(cur[0] == targetY && cur[1] == targetX) {
                    break;
                }

                for(int i=0; i<dirs.length; i++) {
                    int nextY = cur[0] + dirs[i][0];
                    int nextX = cur[1] + dirs[i][1];

                    if(nextY >=0 && nextY < l && nextX >=0 && nextX < l && !visited[nextY][nextX]) {
                        queue.offer(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                        arr[nextY][nextX] = arr[cur[0]][cur[1]] + 1;
                    }
                }
            }
            sb.append(arr[targetY][targetX]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

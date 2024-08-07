package _5_완전탐색;

import java.util.Arrays;
import java.util.Comparator;

public class 피로도 {
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    static void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] || k < dungeons[i][0]) {
                continue;
            }

            visited[i] = true;
            dfs(depth+1, k-dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}

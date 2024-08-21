package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7569 {

    static class Tomato {
        private int z;
        private int x;
        private int y;

        public Tomato(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    static int M, N, H;
    static ArrayList<Tomato> list = new ArrayList<Tomato>();
    static int[][][] box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();   // 가로
        N = sc.nextInt();   // 세로
        H = sc.nextInt();   // 높이

        box = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1) list.add(new Tomato(i, j, k));
                }
            }
        }

        int answer = bfs() -1;
        System.out.println((isRipen() ? answer : -1));
    }

    static int bfs() {
        int curX = 0;
        int curY = 0;
        int curZ = 0;
        int[] x = {-1, 0, 1, 0, 0, 0};
        int[] y = {0, 1, 0, -1, 0, 0};
        int[] z = {0, 0, 0, 0, 1, -1};

        Queue<Tomato> q = new LinkedList<Tomato>();
        for(Tomato tomato : list) {
            q.offer(tomato);
        }

        while(!q.isEmpty()) {
            Tomato cur = q.poll();
            curX = cur.getX();
            curY = cur.getY();
            curZ = cur.getZ();

            for(int i=0; i<6; i++) {
                if(curX+x[i] >= N || curY+y[i] >= M || curZ+z[i] >= H) {
                    continue;
                }
                if(curX+x[i]<0 || curY+y[i]<0 || curZ+z[i]<0) {
                    continue;
                }
                if(box[curZ+z[i]][curX+x[i]][curY+y[i]] == 0) {
                    box[curZ+z[i]][curX+x[i]][curY+y[i]] = box[curZ][curX][curY]+1;
                    q.offer(new Tomato(curZ+z[i],curX+x[i],curY+y[i]));
                }
            }
        }
        return box[curZ][curX][curY];
    }

    static boolean isRipen() {
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}

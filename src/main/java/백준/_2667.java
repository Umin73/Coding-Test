package 백준;

import java.util.*;

public class _2667 {

    static class Home {
        private int x;
        private int y;
        private int homeNum;

        public Home(int x, int y, int homeNum) {
            this.x = x;
            this.y = y;
            this.homeNum = homeNum;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getHomeNum() {
            return homeNum;
        }
    }

    static int N;
    static int[][] map = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int curHomeNum = 1;
    static ArrayList<Integer> answerList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Home first = null;
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j] == 1) {
                    if(first == null) first = new Home(j, i, 1);

                }
            }
        }

        if(first != null) bfs(first);

        System.out.println(curHomeNum);
        Collections.sort(answerList);
        for (int i = 0; i < curHomeNum; i++) {
            System.out.println(answerList.get(i));
        }
    }

    static void bfs(Home first) {
        int curX = first.getX();
        int curY = first.getY();
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        Queue<Home> q = new LinkedList<Home>();
        q.offer(first);
        visited[curY][curX] = true;
        answerList.add(1);

        while(!q.isEmpty()) {
            Home cur = q.poll();
            curX = cur.getX();
            curY = cur.getY();

            for(int i = 0; i < 4; i++) {
                int nextX = cur.getX() + xArr[i];
                int nextY = cur.getY() + yArr[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    q.offer(new Home(nextX, nextY, curHomeNum));
                    visited[nextY][nextX] = true;
                    answerList.set(curHomeNum-1, answerList.get(curHomeNum-1) + 1);
                }
            }
        }

        Home next = findNextHome(++curHomeNum);
        if(next != null) bfs(next);
        else return;
    }

    static Home findNextHome(int nextHomeNum) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    return new Home(j, i, nextHomeNum);
                }
            }
        }
        --curHomeNum;
        return null;
    }
}

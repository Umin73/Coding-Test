package 알고리즘.구현;

import java.io.*;

public class _14891 {

    /*
     * 회전 시 서로 맞닿은 극이 다름 -> 그 옆에 있는 톱니바퀴는 반대 방향으로 회전
     * */
    static int K;
    static int[][] wheelArr = new int[4][8];

    static void rotate(int no, int dir) {
        if(dir == 1) {
            int last = wheelArr[no][7];
            for(int i=7; i > 0; i--) {
                wheelArr[no][i] = wheelArr[no][i-1];
            }
            wheelArr[no][0] = last;
        } else {
            int first = wheelArr[no][0];
            for(int i=0; i<7; i++) {
                wheelArr[no][i] = wheelArr[no][i+1];
            }
            wheelArr[no][7] = first;
        }
    }

    static void solution(int no, int dir, boolean[] checked) {
        if(checked[no]) return;
        checked[no] = true;

        if(no != 3) { // 4번째 톱니바퀴 제외하고 오른쪽 톱니바퀴 돌릴 수 있음
            if(wheelArr[no][2] != wheelArr[no+1][6]) {
                solution(no+1, dir * -1, checked);
            }
        }
        if(no != 0) { // 1번째 톱니바퀴 제외하고 왼쪽 톱니바퀴 돌릴 수 있음
            if(wheelArr[no][6] != wheelArr[no-1][2]) {
                solution(no-1, dir * -1, checked);
            }
        }

        rotate(no, dir);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<input.length; j++) {
                wheelArr[i][j] = Integer.parseInt(input[j]); // N == 0,  S == 1
                // deque의 3번째는 오른쪽 톱니바퀴와 맞닿음
                // deque의 7번째는 왼쪽 톱니바퀴와 맞닿음
            }
        }

        K = Integer.parseInt(br.readLine());
        while(K-- > 0) {
            String[] input = br.readLine().split(" ");
            int no = Integer.parseInt(input[0]); // 회전시킬 톱니바퀴 번호
            int dir = Integer.parseInt(input[1]); // 1: 시계방향, -1: 반시계 방향

            solution(no-1, dir, new boolean[4]);
        }

        int sum = 0;
        for(int i=0; i<4; i++) {
            sum += wheelArr[i][0] * (1 << i);
        }
        System.out.println(sum);

        br.close();
    }
}

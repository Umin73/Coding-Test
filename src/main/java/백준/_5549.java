package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class _5549 {

    static int N, M;
    static int K;
    static String[][] mapArr;
//    static int[][] arrJ;
//    static int[][] arrO;
//    static int[][] arrI;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 가로
        M = Integer.parseInt(input[1]); // 세로
        K = Integer.parseInt(br.readLine()); // 조사 영역 수

        mapArr = new String[M+1][N+1];
//        arrJ = new int[N+1][M+1];
//        arrO = new int[N+1][M+1];
//        arrI = new int[N+1][M+1];
        // 지도의 내용 (지형 정보)
        for(int i=0; i<M;i++) {
            input = br.readLine().split("");
            for(int j=0; j<input.length; j++) {
                mapArr[i][j] = input[j];
            }
//            for(int j=0; j<N;j++) {
//                if(mapArr[j][i].equals("J")) arrJ[i][j] += 1;
//                else if(mapArr[j][i].equals("O")) arrO[i][j] += 1;
//                else if(mapArr[j][i].equals("I")) arrI[i][j] += 1;
//            }
        }

        for(int i=0; i<K;i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);

            int cntJ = 0;
            int cntO = 0;
            int cntI = 0;
            for(int j=a; j<=c; j++) {
                for(int k=b; k<=d; k++) {
                    if(Objects.equals(mapArr[j][k], "J")) cntJ++;
                    else if(Objects.equals(mapArr[j][k], "O")) cntO++;
                    else if(Objects.equals(mapArr[j][k], "I")) cntI++;
                }
                sb.append(cntJ).append(" ").append(cntO).append(" ").append(cntI).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}

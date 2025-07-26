package 알고리즘.구현;

import java.io.*;

public class _14719 {

    static int H, W;
    static char[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        arr = new char[H + 1][W];
        for(int i=0; i<W; i++) {
            int h = Integer.parseInt(input[i]);
            for(int j=h; j>0; j--) {
                arr[j][i] = 'b';
            }
        }

        int answer = 0;
        for(int h=1; h<=H; h++) {
            int lb = -1;
            for(int w=0; w<W; w++) {
                if(lb == -1 && arr[h][w] == 'b') {
                    lb = w;
                }
                else if(arr[h][w] == 'b') {
                    answer += w - lb - 1;
                    lb = w;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}

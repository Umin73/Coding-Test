package 알고리즘.Greedy;

import java.io.*;

public class _16953 {

    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        int answer = 1;
        int tempB = B;
        while(tempB != A && tempB > 0) {
            if(tempB % 10 == 1) tempB /= 10;
            else if(tempB % 2 == 0) tempB /= 2;
            else break;
            answer++;
        }
        if(tempB == A) System.out.println(answer);
        else System.out.println(-1);


        br.close();
    }
}

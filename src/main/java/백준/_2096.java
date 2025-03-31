package 백준;

import java.io.*;

public class _2096 {
    static int N;
    static int[] minArr = new int[3];
    static int[] maxArr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i=0; i<3; i++) {
            minArr[i] = maxArr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            int num0 = Integer.parseInt(input[0]);
            int num1 = Integer.parseInt(input[1]);
            int num2 = Integer.parseInt(input[2]);

            int[] newMin = new int[3];
            int[] newMax = new int[3];

            newMin[0] = Math.min(minArr[0], minArr[1]) + num0;
            newMin[1] = Math.min(minArr[0], Math.min(minArr[1], minArr[2])) + num1;
            newMin[2] = Math.min(minArr[1], minArr[2]) + num2;

            newMax[0] = Math.max(maxArr[0], maxArr[1]) + num0;
            newMax[1] = Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2])) + num1;
            newMax[2] = Math.max(maxArr[1], maxArr[2]) + num2;

            minArr = newMin;
            maxArr = newMax;
        }

        int minScore = Math.min(minArr[0], Math.min(minArr[1], minArr[2]));
        int maxScore = Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2]));
        System.out.println(maxScore + " " + minScore);
        br.close();
    }
}

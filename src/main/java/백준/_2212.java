package 백준;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] spots = new int[N];

        for (int i = 0; i < N; i++) {
            spots[i] = sc.nextInt();
        }
        Arrays.sort(spots);

        int[] diff = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = spots[i+1] - spots[i];
        }

        Arrays.sort(diff);
        for (int i = 0; i < N-K; i++) {
            answer += diff[i];
        }

        System.out.println(answer);

    }
}

package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _1026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        int[] arrB = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arrA[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arrB[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arrA);
        for(int i=0; i<N/2; i++) {
            int temp = arrA[i];
            arrA[i] = arrA[N-1-i];
            arrA[N-1-i] = temp;
        }
        Arrays.sort(arrB);

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arrA[i] * arrB[i];
        }

        System.out.println(sum);
        br.close();
    }
}

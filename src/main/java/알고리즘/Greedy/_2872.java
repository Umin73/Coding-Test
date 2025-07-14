package 알고리즘.Greedy;

import java.io.*;

public class _2872 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int expectNum = N; // 정렬된 상태에서 뒤에서 기대하는 값
        for(int i= N-1; i>=0; i--) {
            if(arr[i] == expectNum) expectNum--;
        }

        System.out.println(expectNum);
        br.close();
    }
}

package 알고리즘.구현;

import java.io.*;
import java.util.*;

public class _2108 {

    static int N;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        int sum = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
            sum += arr[i];
        }

        // 1. 산술 평균
        System.out.println((int)Math.round((double) sum/N));

        Arrays.sort(arr);

        // 2. 중앙 값
        System.out.println(arr[N/2]);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> {
            if(!e1.getValue().equals(e2.getValue())) {
                return e1.getValue() - e2.getValue();
            } else {
                return e1.getKey() - e2.getKey();
            }
        });
        int listMax = list.get(list.size()-1).getValue();
        while(true) {
            if(list.get(0).getValue() < listMax) list.remove(0);
            else break;
        }

        // 3. 최빈 값
        if(list.size() == 1) System.out.println(list.get(0).getKey());
        else System.out.println(list.get(1).getKey());

        // 4. 범위
        System.out.println(Math.abs(arr[0]-arr[N-1]));

        br.close();
    }
}

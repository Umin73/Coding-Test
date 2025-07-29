package 프로그래머스._해시;

import java.io.*;
import java.util.*;

public class _의상 {

    static public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1],0) + 1);
        }

        for(Integer num : map.values()) {
            answer *= (num+1);
        }

        return answer-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().replace("[","")
                                    .replace("]","")
                                    .replace("\"","")
                                    .replace(" ","")
                                    .split(",");

        String[][] clothes = new String[input.length/2][2];

        for(int i=0; i<input.length; i+=2){
            clothes[i/2][0] = input[i];
            clothes[i/2][1] = input[i+1].trim();
        }

        System.out.println(solution(clothes));

        br.close();
    }
}

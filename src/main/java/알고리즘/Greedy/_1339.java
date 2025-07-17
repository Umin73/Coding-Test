package 알고리즘.Greedy;

import java.io.*;
import java.util.*;

public class _1339 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }
        Map<Character, Integer> weightMap = new HashMap<>();

        // 모든 알파벳의 자리수 가중치를 계산
        for(String word: words) {
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                int weight = (int)Math.pow(10, word.length()-i-1);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + weight);
            }
        }

        // 가중치 내림차순 정렬
        List<Character> weightList = new ArrayList<>(weightMap.keySet());
        weightList.sort((a,b) -> weightMap.get(b) - weightMap.get(a));

        // 가중치 높았던 알파벳부터 큰 숫자 부여
        Map<Character, Integer> alphabetMap = new HashMap<>();
        int num = 9;
        for(char c : weightList) {
            alphabetMap.put(c, num--);
        }

        long sum = 0;
        for(String word : words) {
            int number = 0;
            for(int i=0; i<word.length(); i++) {
                number = (number * 10) + alphabetMap.get(word.charAt(i));
            }
            sum += number;
        }

        System.out.println(sum);
        br.close();
    }
}

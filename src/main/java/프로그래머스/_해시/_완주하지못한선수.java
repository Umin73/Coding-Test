package 프로그래머스._해시;

import java.io.*;
import java.util.*;

public class _완주하지못한선수 {

    static public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for(String c : completion) map.replace(c, map.get(c) - 1);

        String answer = "";
        for(String name : map.keySet()) {
            if(map.get(name).equals(1)) answer = name;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] participant = br.readLine().split(" ");
        String[] completion = br.readLine().split(" ");

        System.out.println(solution(participant, completion));

        br.close();
    }
}

package 해시;

import java.util.HashMap;

public class 완주하지_못한_선수 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}
                , new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}
                , new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}
                , new String[]{"stanko", "ana", "mislav"}));

    }

    static public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for(String p:participant) {
           map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(String c:completion) {
            map.put(c, map.get(c)-1);
        }

        for(String p:map.keySet()) {
            if(map.get(p) > 0) return p;
        }

        return "wrong";
    }
}

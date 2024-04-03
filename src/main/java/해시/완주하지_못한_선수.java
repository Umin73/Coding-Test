package 해시;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"},
                                    new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                                    new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                                    new String[]{"stanko", "ana", "mislav"}));

    }

    static public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>();

        for (String p:participant) {
            result.put(p,(result.containsKey(p)? result.get(p)+1 : 1));
        }

        for (String c:completion) {
            result.replace(c,result.get(c)-1);
        }

        for (String s : result.keySet()) {
            if(result.get(s) > 0) return s;
        }
        return "ERROR";
    }
}

package 프로그래머스._1_해시;


import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public static void main(String[] args) {

        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"},
                {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));

    }

    static public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }

        for(String m:map.keySet()) {
            answer *= (map.get(m) + 1); // 1은 입지 않는 경우
        }
        answer -= 1;

        return answer;
    }
}

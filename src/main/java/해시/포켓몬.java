package 해시;

import java.util.HashMap;
import java.util.Map;

public class 포켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }

    static public int solution(int[] nums) {
        Map<Integer,Integer> pokemonMap = new HashMap<>();

        for (int n:nums) {
            pokemonMap.put(n, (pokemonMap.containsKey(n)?pokemonMap.get(n)+1:1));
        }

        return (pokemonMap.size() > nums.length/2 ? nums.length/2 : pokemonMap.size());
    }
}




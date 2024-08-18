package 프로그래머스._1_해시;

import java.util.HashSet;

public class 포켓몬 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));

    }

    static public int solution(int[] nums) {
        HashSet<Integer> pokemon = new HashSet<>();
        int canHave = nums.length/2;

        for(int n:nums) {
            pokemon.add(n);
        }

        return Math.min(canHave, pokemon.size());
    }
}

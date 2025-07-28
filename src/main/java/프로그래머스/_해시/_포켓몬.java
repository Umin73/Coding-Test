package 프로그래머스._해시;

import java.io.*;
import java.util.*;

public class _포켓몬 {

    static public int solution(int[] nums) {
        int N = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        if(set.size() >= N/2) return N/2;
        else return set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().replace("[","").replace("]","");
        String[] strNum = input.split(",");
        int[] nums = new int[strNum.length];

        for(int i=0; i<nums.length; i++) nums[i] = Integer.parseInt(strNum[i]);

        System.out.println(solution(nums));

        br.close();
    }
}

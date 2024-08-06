package _5_완전탐색;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 소수찾기 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set.clear();
        recursive("", numbers);

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            int n = iter.next();
            System.out.println("number is " + n);
            if(isPrime(n)) answer++;
        }

        return answer;
    }

    public static void recursive(String comb, String others) {
        if(!comb.equals("")){
            set.add(Integer.parseInt(comb));
        }
        for(int i=0; i< others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }

    static boolean isPrime(int n) {
        if(n == 0 || n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}

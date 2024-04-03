package 해시;

import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }

    static boolean solution(String[] phone_book) {
        boolean answer = true;

        List<String> phoneList = new ArrayList<>();
        for (String p:phone_book) {
            phoneList.add(p);
        }

        Collections.sort(phoneList);

        for (int i = 1; i < phoneList.size(); i++) {
            if(phoneList.get(i).startsWith(phoneList.get(i-1))) return false;
        }

        return answer;
    }
}

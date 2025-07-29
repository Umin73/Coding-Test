package 프로그래머스._해시;

import java.io.*;
import java.util.*;

public class _전화번호목록 {

    static public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().replace("[","").replace("\"","").replace("]","").replace(" ","");
        String[] phoneBook = input.split(",");

        System.out.println(solution(phoneBook));

        br.close();
    }
}

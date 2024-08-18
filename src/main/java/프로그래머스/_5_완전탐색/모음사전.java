package 프로그래머스._5_완전탐색;

public class 모음사전 {

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        int answer = 1;
        int wordMaxLength = 5;
        String[] vowels = {"A", "E", "I", "O", "U"};
        char[] current = new char[wordMaxLength];
        int curIdx = 0;
        int vowelIdx = 0;

        /*
        * 단어길이가 길 수록 순위가 뒤로 밀림
        * 같은 길이가 더 길어질 수 없을 때 알파벳이 바뀜
        * 만약 바뀐 알파벳이 U가 된다면 알파벳 길이가 한칸 줄어든 상태로 가서 그 위치의 알파벳이 바뀜
        * A / AA/ AAA / AAAA / AAAAA / AAAAE / AAAAI/ AAAAO / AAAAU
        * AAAE AAAEA
        * */

        while (!word.equals(String.valueOf(current))) {
            answer++;
            if(curIdx < wordMaxLength - 1) {
                curIdx++;
            }
        }

        return answer;
    }
}

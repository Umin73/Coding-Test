package _2_스택큐;

public class 올바른_괄호 {

    public static void main(String[] args) {

        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    static boolean solution(String s) {
        int open = 0;
        int close = 0;

        for(int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) == '(') open++;
            else if(s.charAt(idx) == ')') close++;

            if(close > open) return false;

        }

        if(close == open) return true;
        else return false;
    }
}

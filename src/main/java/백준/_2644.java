package 백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2644 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] check = new boolean[10001];
    static int n, me, you, relation;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        me = sc.nextInt();
        you = sc.nextInt();
        relation = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
            check[i] = false;
        }

        for (int i = 0; i < relation; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(me);

        System.out.println(answer);
    }

    static void dfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<list.get(cur).size(); i++){
                int next = list.get(cur).get(i);
                if(!check[next]){
                    q.offer(next);
                    check[next] = true;

                    if(next == you){
                        answer = 1;
                        return;
                    }

                    dfs(next);
                    if(check[you]){
                        answer++;
                        return;
                    }
                }
            }
        }
        return;
    }
}

package incorrect_note;
import java.util.*;
public class boj_q15650 {
    static int N;
    static int M;
    static boolean[] isVisited;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isVisited = new boolean[N + 1];
        num = new int[N + 1];

        dfs(0, -1); 
    }

    //이전보다 커지는 시점에서 for문빠져나오기 
    static void dfs(int current, int prev) {
        if (current == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if (isVisited[i] == true) {
                    continue;
                }
              
                if (prev > i) {
                    continue;
                }
                isVisited[i] = true;
                num[current] = i;
                dfs(current + 1, num[current]);
                isVisited[i] = false;
            }
        }
    }
}
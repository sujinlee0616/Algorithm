package incorrect_note;


import java.util.Scanner;
//중복 포함한 M개를 고른 수열 
public class boj_NM_2 {
	static int N,M;
	static boolean v[];
	static int list[];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        v = new boolean[N+1];
        list = new int[N+1];

        dfs(0, -1); 
        //초기화(-1=아예 로직에서 제외) 
        //조합에서는 visited  가 굳이 필요 없더라 
    }

    //매개변수 두개를 받아서 이전처리 
    public static void dfs(int index, int prev) {
        if (index == M) {
            for (int i = 0; i < M; i++)  System.out.print(list[i] + " ");
            System.out.println();
            return;  // 리턴을 쓰는습관  -> 안쓰면 뭔가 하나꼬임 
        }
 
        for (int i = 1; i <= N; i++) {
               // if (v[i] == true) continue;
                //다음에 오는 수가 더 커야 됨 
                if (prev > i)continue;
             
                //v[i] = true;
                list[index] = i; //담아주기 
                //매개변수 처리)  next , prev=현재 
                dfs(index + 1, list[index]);
                //v[i] = false;
            }
        }
    }


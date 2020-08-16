package boj;

import java.util.Scanner;

// [조합]  
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 수열은 오름차순
// - 순열일 때는 visited[] 필요하지만, 조합일 때는 visited[] 필요 X. start만 있으면 됨. 
public class boj_q15650_NandM2_re {

	static int N, M;
	static int[] visited, list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new int[9]; // n과 m의 최대범위
		list = new int [9]; // (1 ≤ M ≤ N ≤ 8)
		dfs(0,0);
		sc.close();
	}
	
	static void dfs(int idx, int depth) {
		
		if(depth == M) {
			for(int i=0; i<M; i++)
				System.out.print(list[i]+" ");
			System.out.println();
			return;
		}
		
		// 1부터 N까지 숫자 중 어떤 거 쓸지...
		// visited 배열 안 써도 풀린다 ;ㅁ; 
		for(int i=idx+1; i<=N; i++) {
			// 1로 시작하면 다음 자리는 2부터 N까지 탐색...
			// if(visited[i] == 1) // visited[] 안 써도 됨. 왜냐면, for문의 다음 바퀴로 돌아간다. for문에서 처리됨.  
				// continue;
			//visited[i] = 1; // 방문처리 
			list[depth] = i;
			dfs(i, depth+1); 
			//visited[i] = 0; // 방문여부 초기화 
		}
	}
	
}

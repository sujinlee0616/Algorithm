package boj;

import java.util.Scanner;

// [순열]  
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
public class boj_q15649_NandM1_Re {
	
	static int N;
	static int M; 
	static int[] visited;
	static int[] list; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new int[9]; // n과 m의 최대범위
		list = new int [9]; // (1 ≤ M ≤ N ≤ 8)
		dfs(0);
	}
	
	// k번째 dfs를 돌림 
	static void dfs(int depth) {
		
		if(depth == M) {
			for(int i=0; i<M; i++)
				System.out.print(list[i]+" ");
			System.out.println("");
			return; // DFS 종료 
		}
			
		for(int i=1; i<=N; i++) {
			
			// 1. i가 이미 list에 있으면, 이 숫자 이미 사용했음 
			//     ==> for문 조건으로 돌아감. (반복문의 다음 바퀴를 돈다) 
			if(visited[i] == 1) 
				continue;
			// 2. i가 아직 list에 없다면, i를 쓸 수 있음 
			visited[i] = 1; // 1) 방문처리 - i 썼다고 표시 ==> list의 다음 index에서는 i 쓰지 X 
			list[depth] = i; // 2) 결과배열의 k번째 원소에 집어넣고 
			dfs(depth+1); // 
			visited[i] = 0; // 방문처리 해제 ★★★ ==> 12 13 14 다음에 21 23 24 할 수 있게..
		}
	}
}







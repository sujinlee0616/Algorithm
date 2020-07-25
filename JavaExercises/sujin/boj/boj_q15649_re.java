package boj;

import java.util.Scanner;

public class boj_q15649_re {
	
	static int n,m;
	static int list[], visited[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		visited = new int[9]; // n과 m의 최대 범위
		list = new int[9];
		dfs(0);
	}
	
	static void dfs(int k) {
		
		if(k==m) { // 0번부터 M번까지 수행했으면 모든 처리가 완료된 것. 
			for(int i=0;i<m;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return; // DFS 종료 
		} 
			
		// k가 m보다 작을 때, dfs(k) 
		for(int i=1;i<=n;i++) {
			// 1. 이미 list에 i가 있다면 (i를 방문했다면) 
			if(visited[i]==1) { 
				continue; // 건너뛴다 
			}
			// 2. 아직 list에 i가 없다면 (i를 아직 방문하지 않았다면)  
			visited[i]=1; // 1) 방문처리하고 
			list[k]=i; // 2) 결과배열의 k번째 원소에다가 집어넣고 
			dfs(k+1); // 3) k+1번째 결과배열을 정하기 위해 dfs(k+1)
			visited[i]=0; // 4) 다음 i 돌아야하니까 초기화시킴 
			
		}
	}
}




















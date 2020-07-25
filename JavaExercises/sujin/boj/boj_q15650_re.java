package boj;

import java.util.Scanner;

public class boj_q15650_re {

	static int m,n;
	static int list[],visited[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		visited=new int[9];
		list=new int[9];
		dfs(0,0);
	}
	
	static void dfs(int idx, int k) {
		// 수열의 끝에 도달하면 종료 
		if(k == m) {
			for(int i=0;i<m;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return; 
		}
		// 아직 그게 아니면 
		for(int i=idx+1;i<=n;i++) { // 2로 시작 ==> 두번째 자리는 3부터 N까지 탐색 
			// 이미 방문했으면 스킵 
			if(visited[i]==1)
				continue;
			// 방문한 적 없으면 
			visited[i]=1; // 1) 방문했다고 체크하고 
			list[k]=i; //2) 리스트에 i를 넣고
			dfs(i,k+1); // 3) k+1 탐색
			visited[i]=0; 
			
		}
		
	}
	
}









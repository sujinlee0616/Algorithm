package incorrect_note;

import java.util.Scanner;

public class boj_NM_1 {
		
//N과M 1 	
	
	static int N,M;
	static boolean v[]; //방문여부 담을 것 (==isVisited) 
	static int result[];//리스트로 담아보자  
	public static void main(String[] args) {
			//입력) 순열 
			Scanner scan=new Scanner(System.in);
			N=scan.nextInt();
			M=scan.nextInt();
			v=new boolean[N+1]; //1부터~N까지 
			result=new int[N+1];
			//depth++ 하기 전 0으로 초기화 
			dfs(0);
			
	}
	
	//depth= 방문횟수 
	public static void dfs(int depth) { 
		//출력)  재귀호출 하다가 끝까지 가면 그 결과를 담아서 리턴 
		if(depth==M) {
			//트리 끝까지 돌면서  
			for(int i=0;i<M;i++) System.out.print(result[i]+" ");
			System.out.println();
		}
		
		//3 
		for(int i=1;i<=N;i++) {
			
				if(v[i]==true)continue; // 조건) 이미 방문했다면 제외하고 
				v[i]=true; // 지금 방문한다면 f->t  바꿔주고 	
				
				// ***) 리스트에 담는다 
				result[depth]=i;
		
				dfs(depth+1);		
				
				v[i]=false; 
			
		}
		
	}
}

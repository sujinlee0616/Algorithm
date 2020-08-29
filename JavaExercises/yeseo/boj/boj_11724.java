package boj;

import java.util.Scanner;

public class boj_11724 {
//Connected Component 

	//*) visited==false인 애들 찾아 N(깊이)까지 count ++
	//?) 런타임 에러 : 역시 배열의 범위가 문제
	static int N,M,count=0;
	static int arr[][]=new int [1001][1001];
	static boolean visited[]=new boolean [1001];
	
	public static void main(String[] args) {
	
		Scanner scan=new Scanner(System.in);
		
		N=scan.nextInt();//depth
		M=scan.nextInt();//간선 개수 
		
		int v1,v2;
		for(int i=0;i<M;i++) {
			v1=scan.nextInt();
			v2=scan.nextInt();
			
			//인접행렬 만들기 index=입력 간선 번호 
			arr[v1][v2]=1;
			arr[v2][v1]=1;
		}
		
		//깊이 = N , default =1 (한개라도 연결되어있음 +2) 
		for (int j=1;j<=N;j++) {
			if(!visited[j]) {
				//false
				dfs(j);
				count++;
			}
		}
		System.out.println(count);
		scan.close();
		
	}
	// **** visited ==false인 애들 만큼 ++ 
	public static void dfs(int v) {
		visited[v]=true; // 방문
		

		for(int i=1;i<=N;i++) {
			if(arr[v][i]==1&& !visited[i]) {
				dfs(i);
			}
			
		//종료조건 
		if(i==N) 
			return;
		}
	}
}

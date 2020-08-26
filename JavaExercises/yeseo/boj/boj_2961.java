package boj;

import java.util.*;

public class boj_2961 {
//도영이가 만든 음식 
	// 곱-합의 차가 최소 인 것을 출력
	// 부분 집합의 합 (B)
	// 부분 집합의 곱 (S)
	// 종료 조건과 부합 조건! 
	
	static int min;
	static int count=0;
	static int S[],B[];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		////////
		min=Integer.MAX_VALUE;
		////////
		S=new int [N];
		B=new int [N];
		visited=new boolean [N];
		for(int i=0;i<N;i++) {
			S[i]=scan.nextInt();
			B[i]=scan.nextInt();
		}
		dfs(0,N);
		System.out.println(min);
		scan.close();
	}

	public static void dfs(int start,int n) {
		
		if(start==n) {//종료조건
			int x=1;
			int y=0;
			int temp=0;
			for(int i=0;i<n;i++) {
				if(visited[i]) {//true 
					x*=S[i]; //신맛 = 부분 집합의 곱
					y+=B[i]; //쓴맛 = 부분 집합의 합 
				}
			}
			
			//종료조건 
			if(x==0) return;
			
			//차이 
			temp=Math.abs(x-y); 
			
			//정답 도출 
			min=Math.min(min, temp);
			return;

		}
		
		visited[start]=true;
		dfs(start+1,n);
		visited[start]=false;
		dfs(start+1,n);
		
	}

}

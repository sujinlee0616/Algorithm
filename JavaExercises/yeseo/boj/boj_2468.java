package boj;

import java.util.Scanner;

public class boj_2468 {
//안전영역
// 높이가 N초과인 영역 중 상하좌우 탐색 후 최대 영역 도출 

	static int N,result;
	static int res[][]=new int[102][102];
	static int dy[]= {-1,1,0,0};
	static int dx[]= {0,0,-1,1};
	static boolean visited[][]=new boolean [102][102];
	//런타임에러 고치는 법 = 배열의 크기를 최대로 잡자 
	
	//주의? i,j,k 입력 순서 
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();

		for(int i=1;i<=N;i++) 
			for(int j=1;j<=N;j++) 
				res[i][j]=scan.nextInt();		
		
		//방문여부
		int result=1; // 최소 높이 = 1 
		for(int i=1;i<=100;i++) { //최대 높이 =100 
			//초기화
			for(int j=1;j<=N;j++)
				for(int k=1;k<=N;k++)
					visited[j][k]=false;
			//영역 세기 
			int count=0;
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(res[j][k]>=N && !visited[j][k]) {
						visited[j][k]=true;
						dfs(N,j,k); //높이, x, y 
						count++;
					}
				}
			}
			//**최대를 리턴 
			result=Math.max(result, count);
			
		}
		System.out.println(result);
		scan.close();
		
	}
	
	
	public static void dfs(int h, int x, int y) {
		for(int i=0;i<4;i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			//4방 탐색, 종료조건
			if(res[cx][cy]>=h&& visited[cx][cy]==false) {
				visited[cx][cy]=true;
				dfs(h,cx,cy);
			}
		}
	}
}

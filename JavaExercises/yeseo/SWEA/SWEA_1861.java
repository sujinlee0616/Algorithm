package SWEA;

import java.util.Scanner;
import java.util.Stack;

class Pos{
	int x;
	int y;
	
	Pos(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class SWEA_1861 {
/*
정사각형 방
- 행렬의 원소값은 중복을 허용하지 않는 서로 다른 수
- N^2 1<=Aij<=N^2
- 이동은 상하좌우 가능, 조건 )  (이동하려는 방의 번호) == current+1 
- 가장 많은 수의 방을 이동할 수 있는 start점을 반환하라 
(if방개수가 최대인 값이 여러개?작은 것 출력)

입력) 테스트케이스 
출력) 테스트케이스  출발  방개수   
 */
	
	
	static int res;
	static int s;
	static int N;
	static boolean [] visited;
	static int [][] arr;
	
	
	
	public static void main(String[] args) {
		//입력 
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int c=1; c<=T; c++) {
			N=sc.nextInt();
			res=0;
			s=101; //? 
			arr=new int[N][N];
			for(int i=0; i<N; i++)
				for(int j=0;j<N;j++) 
					arr[i][j]=sc.nextInt();
			
			
			//방문 행렬을 만들어줘 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					visited=new boolean[N*N+1];
					int move=dfs(i,j);
					if(res<move) {
						res=move;
						s=arr[i][j];
					}else if(move!=0 && res==move) {
						if(arr[i][j]<s)
							s=arr[i][j];
					}
				}
			}
			
			
			
			System.out.println("#"+c+" "+s+" "+res);
		}
		
		
	}

	public static int dfs(int x,int y) {
		int []dx= {-1,1,0,0};
		int []dy= {0,0,-1,1};
		Stack<Pos> stack=new Stack();
		int move=1;
		
		stack.push(new Pos(x,y));
		while(!stack.isEmpty()) {
			Pos p=stack.pop();
			int a=p.x;
			int b=p.y;
			
			for(int i=0;i<4;i++) {
				int cx=a+dx[i]; //current x 
				int cy=b+dy[i];
				//배열 범위 유효 조건 
				if(!(cx<0||cx>N-1||cy<0||cy>N-1)) {
					if(!visited[arr[cx][cy]]) {
						if(arr[cx][cy]-arr[a][b]==1) {//차이가 딱1 
							visited[arr[cx][cy]]=true;
							stack.push(new Pos(cx,cy));
							move++;
						}
					}
				}
				
			}
		}
		
		return move;
	}

}

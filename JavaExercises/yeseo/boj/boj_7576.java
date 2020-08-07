package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7576 {
/*
토마토(2차원)
익은토마토가 상하좌우(대각선 x)에 있으면 하루 지날 때 싱싱한 토마토도 익는다.

Anm이 주어질때 며칠 지나면 모든 토마토가 익을까

같은 레벨인 애들을 모두 색칠한다 = BFS 문제
000000
000000
000000
000001 


일반적으로 BFS는 visited2차원 배열을 만들어서 중복 방문을 방지하는데
이 문제의 경우 box배열을 한번 받고 말아버리기 때문에 재사용하고 1로 바꿔버리면 그만 .
 */

	static int N,M;
	static int [][]box;
	static int [] dx= {1,-1,0,0};
	static int [] dy= {0,0,1,-1};
	
	static class Dot{
		int x;
		int y;
		int day;
		
		public Dot(int x,int y, int day) {
			this.x=x;
			this.y=y;
			this.day=day;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		
		
		box=new int[M][N];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) 
			box[i][j]=scan.nextInt();
		}
		
		
		bfs();
	}
	
	static void bfs() {
		Queue<Dot> q= new LinkedList<>();
		int day=0;
		
		// 토마토가 있으면 EnQueue
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(box[i][j]==1)
					q.offer(new Dot(i,j,0));
			}
		}
		
		//큐가 다 빌때까지 상하좌우 움직여서 탐색  
		while(!q.isEmpty()) {
			Dot dot=q.poll();
			day=dot.day;
			
			for(int i=0;i<4;i++) {
				int cx=dot.x+dx[i];
				int cy=dot.y+dy[i];
				
				//OR if(cx<0 || cx>M || cy<0 || cy>N) continue;
				if(cx>=0 && cx<M && cy>=0 && cy<N) {
					if(box[cx][cy]==0) { // 아직 안익은토마토를 바꿔줘 
						box[cx][cy]=1;
						q.add(new Dot(cx,cy,day+1)); //날짜 계산 
					}
				}
			}
		}
		
		//ripe 체크
		if(check())
			System.out.println(day);
		else 
			System.out.println(-1);
	}
	
	// box에 0이 남았다? false ELSE true
	static boolean check() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(box[i][j]==0)
					return false;
			}
		}
		
		return true;
	}
	
	/*
	JH 's CODE 
	
	
	while(que.size() != 0) { 
	res++;   // 같은 레벨을 표시하기 위해서... 
	// 같은 레벨의 모든 토마토를 다 Queue에 넣을때까지 반복 → while문 
	int len = que.size();  
	while(len-- > 0) {
	 int[] node = que.poll();
	 for(int i = 0; i < 4; i++) {
		int nx = node[0] + dx[i];
		int ny = node[1] + dy[i];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
		if(arr[nx][ny] != 0) continue;
		arr[nx][ny] = 1;
		que.offer(new int[] {nx,ny});
	 }
  }
}
	 */
	
	

}
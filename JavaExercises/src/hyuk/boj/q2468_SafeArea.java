package hyuk.boj;

import java.util.Scanner;

public class q2468_SafeArea {
	
	private static int N,H;
	private static int ans,res;
	private static int[][] visited;
	private static int[][] arr, arrCopy;
	
	public static void main(String[] args) {
		new q2468_SafeArea().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr = new int[N][N];
		arrCopy = new int[N][N];
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = scn.nextInt();
				H = max(H, arr[i][j]);
			}
		}
		getAns();
		System.out.println(ans);
		
		scn.close();
	}
	private int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	private void getAns() {
		for(int h = 0; h <= H; h++) {
			//1. 물에 잠긴다 - 초기화
			init(h);
			//2. 전 노드를 돌면서 총 지역의 개수를 구한다
			getAreaNum();
			ans = max(ans, res);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
			}
		}
	}
	private void init(int h) {
		res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arrCopy[i][j] = arr[i][j];
				if(arrCopy[i][j] <= h) {
					arrCopy[i][j] = -1;
				}
				visited[i][j] = 0;
			}
		}
	}
	private void getAreaNum() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arrCopy[i][j] != -1 && visited[i][j] != 1) {
					res++;
					dfs(i,j);
				}
			}
		}
	}
	private void dfs(int x, int y) {
		visited[x][y] = 1;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arrCopy[nx][ny] == -1) continue;
			if(visited[nx][ny] == 1) continue;
			dfs(nx,ny);
		}
	}
}

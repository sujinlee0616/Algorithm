package hyuk.boj;

import java.util.Scanner;

public class q1861_SquareRoom {
	
	private static int N;
	private static int[][] arr;
	private static int res;
	
	public static void main(String[] args) {
		new q1861_SquareRoom().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int test = scn.nextInt();
		for(int t = 1; t <= test; t++) {
			N = scn.nextInt();
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			int ans = 0;
			int nodeSize = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					res = 0;
					dfs(i,j);
					if(ans < res) {
						nodeSize = arr[i][j];
						ans = res;
					} else if(ans == res) {
						if(nodeSize > arr[i][j]) {
							nodeSize = arr[i][j];
						}
					}
				}
			}
			System.out.println("#" + t + " " + nodeSize + " " + ans);
		}
		
		scn.close();
	}
	private void dfs(int x, int y) {
		res++;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arr[nx][ny] != arr[x][y]+1) continue;
			dfs(nx,ny);
		}
	}
}

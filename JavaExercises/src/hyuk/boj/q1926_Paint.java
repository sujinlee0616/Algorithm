package hyuk.boj;

import java.util.Scanner;

public class q1926_Paint {
	
	private static int N,M;
	private static int[][] arr;
	private static int area, count, tmpCount;
	public static void main(String[] args) {
		new q1926_Paint().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		getAns();
		
		System.out.println(count); // 페인트 개수
		System.out.println(area); // 최대 넓이
		scn.close();
	}
	private int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	private void getAns() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					count++;
					tmpCount = 0;
					dfs(i,j);
					//print();
					area = max(tmpCount, area);
				}
			}
		}
	}
	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private void dfs(int x, int y) {
		arr[x][y] = 0;
		tmpCount++;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(arr[nx][ny] == 0) continue;
			dfs(nx,ny);
		}
	}
}

package hyuk.boj;

import java.util.Scanner;

public class q2573_IceMountain {
	
	private int N,M;
	private int[][] arr;
	private int[][] visited;
	private int[] dx = {0,1,0,-1};
	private int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		new q2573_IceMountain().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		arr = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		int count = 0;
		while(true) {
			if(check()) {
				System.out.println(count);
				break;
			}
			init();
			if(allMelt()) {
				System.out.println(0);
				break;
			}
			seaSearch();
			count++;
			init();
			//print();
		}
		
		scn.close();
	}
	private void print() {
		System.out.println("\n============");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n============");
	}
	private boolean check() {
		int count = 0 ;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] > 0 && visited[i][j] == 0) {
					dfs(i,j);
					count++;
					if(count > 1) return true;
				}
			}
		}
		return false;
	}
	private void dfs(int x, int y) {
		visited[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(visited[nx][ny] == 1) continue;
			if(arr[nx][ny] <= 0) continue;
			dfs(nx,ny);
		}
	}
	private void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++ ) {
				visited[i][j] = 0;
			}
		}
	}
	private boolean allMelt() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] > 0) {
					return false;
				}
			}
		}
		return true;
	}
	private void seaSearch() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0 && visited[i][j] == 0) {
					dfsSea(i,j);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] != 0 && visited[i][j] != 0) {
					arr[i][j] -= visited[i][j];
				}
			}
		}
	}
	private void dfsSea(int x, int y) {
		visited[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if(arr[nx][ny] > 0) {
				visited[nx][ny]++;
				continue;
			}
			if(visited[nx][ny] == 1) continue;
			dfsSea(nx,ny);
		}
	}
}

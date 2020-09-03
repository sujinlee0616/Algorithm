package hyuk.boj;

import java.util.Scanner;

public class BOJ_14889_StartAndLink {
	
	private int ans = 987654321;
	private int N;
	private int[][] arr;
	private int[] visited;
	
	public static void main(String[] args) {
		new BOJ_14889_StartAndLink().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr= new int[N][N];
		visited = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		dfs(0,0);
		System.out.println(ans);
		scn.close();
	}
	private void dfs(int depth, int start) { 
		if(depth >= N/2) {
			int a = getScore(1);
			int b = getScore(0);
			ans = min(ans, Math.abs(a-b));
			return;
		}
		for(int i = start; i < N; i++) {
			visited[i] = 1;
			dfs(depth+1, i+1);
			visited[i] = 0;
		}
	}
	private int getScore(int mode) {
		int score = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(visited[i] == mode && visited[j] == mode) {
					score += arr[i][j];
				}
			}
		}
		return score;
	}
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
}

package hyuk.boj;

import java.util.Scanner;

public class q2961_Doyoung {
	
	private static int N;
	private static int[][] arr;
	private static int res = 1000000000;
	private static int[] visited;
	
	public static void main(String[] args) {
		new q2961_Doyoung().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr = new int[N][2];
		visited = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		dfs(0,1,0);
		System.out.println(res);
		scn.close();
	}
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
	private void dfs(int pos, int s, int g) {
		if(pos > N) return;
		if(pos != 0) {
			res = min(res, Math.abs(s - g));
		}
		for(int i = 0; i < N; i++) {
			if(visited[i] != 0) continue;
			visited[i] = 1;
			dfs(pos+1, s *arr[i][0], g + arr[i][1]);
			visited[i] = 0;
		}
	}
}

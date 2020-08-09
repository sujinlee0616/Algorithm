package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q7576_Tomato {
	
	private static int N,M;
	private static int[][] arr;
	
	public static void main(String[] args) {
		new q7576_Tomato().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		M= scn.nextInt();
		N = scn.nextInt();
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					que.offer(new int[] {i,j});
				}
			}
		}
		int res = bfs(que);
		if(check())
			System.out.println(res);
		else
			System.out.println(-1);
		scn.close();
	}
	private int bfs(Queue<int[]> que) {
		int res = -1;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(que.size() != 0) {
			res++;
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
		return res;
	}
	private boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}

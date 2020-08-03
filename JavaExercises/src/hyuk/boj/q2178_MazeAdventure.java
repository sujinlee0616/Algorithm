package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2178_MazeAdventure {
	
	public static void main(String[] args) {
		new q2178_MazeAdventure().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.next();
		}
		
		int[][] visited = new int[N][M];
		int res = bfs(N,M,arr,visited);
		System.out.println(res);
		
		scn.close();
	}
	
	private int bfs(int N, int M, String[] arr, int[][] visited) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		visited[0][0] = 1;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(que.size() != 0) {
			int[] node = que.poll();
			for(int i = 0; i < 4; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				int v = visited[node[0]][node[1]] + 1;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] != 0) continue;
				if(arr[nx].charAt(ny) == '0') continue;
				visited[nx][ny] = v;
				que.offer(new int[] {nx,ny});
			}
		}
		return visited[N-1][M-1];
	}
}

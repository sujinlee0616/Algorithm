package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class q7562_NightMoving {
	
	private static int N;
	private static int[][] visited;
	private static int x,y,fx,fy;
	
	public static void main(String[] args) {
		try {
			new q7562_NightMoving().service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void service() throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			visited = new int[N][N];
			String input[] = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			String input2[] = br.readLine().split(" ");
			fx = Integer.parseInt(input2[0]);
			fy = Integer.parseInt(input2[1]);
			
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] {x,y});
			visited[x][y] = 1;
			bfs(que);
			
			System.out.println(visited[fx][fy]-1);
		}
	}
	private void bfs(Queue<int[]> que) {
		int[] dx = {1,2,2,1,-1,-2,-2,-1};
		int[] dy = {2,1,-1,-2,-2,-1,1,2};
		
		while(que.size() != 0) {
			int[] node = que.poll();
			if(visited[fx][fy] != 0) return;
			for(int i = 0; i < 8; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny] != 0) continue;
				visited[nx][ny] = visited[node[0]][node[1]] + 1;
				que.offer(new int[] {nx,ny});
			}
		}
		visited[fx][fy] = 1;
	}
}

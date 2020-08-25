package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q4963_NumOfIsland {
	
	private static int w,h,count;
	private static int[][] arr;
	
	public static void main(String[] args) {
		new q4963_NumOfIsland().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			w = scn.nextInt();
			h = scn.nextInt();
			if(w == 0 && h == 0) break;
			count = 0;
			arr = new int[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1) {
						count++;
						bfs(i,j);
					}
				}
			}
			System.out.println(count);
		}
		
		scn.close();
	}
	private void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {x,y});
		arr[x][y] = 0;
		int[] dx = {0,1,1,1,0,-1,-1,-1};
		int[] dy = {1,1,0,-1,-1,-1,0,1};
		
		while(que.size() != 0) {
			int[] node = que.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if(arr[nx][ny] == 0) continue;
				arr[nx][ny] = 0;
				que.offer(new int[] {nx,ny});
			}
		}
	}
}

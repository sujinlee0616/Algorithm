package boj;

import java.util.Scanner;

public class boj_4963 {
//섬의 개수
	// 8방 탐색 & BFS
	
	//DFS 
	static int map[][];
	static int W, H, count;
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

	static int group;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) { ///////////////////////// 입출력 
			W = scan.nextInt();
			H = scan.nextInt();
			
			if(W==0 && H==0) break; ///////////// 종료조건
			
			map = new int[H][W];
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					map[i][j] = scan.nextInt();
			int group = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						group++;
						
						solution(i, j);
					}
				}
			}

			System.out.println(group);

		}
	}

	static void solution(int x, int y) {
		map[x][y] = 0;
		

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if ((nx >= 0 && nx < H) && (ny >= 0 && ny < W) && (map[nx][ny] == 1)) {

				solution(nx, ny);
			}
		}
	}
	
	
	/*BFS
	
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

	 */

}
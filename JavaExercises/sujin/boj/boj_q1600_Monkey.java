package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 다시 풀어야함 !!!! 
// 0: 평지, 1: 장애물 
public class boj_q1600_Monkey {

	static int K,W,H;
	static int[][] map;
	// 말의 움직임 
	static int[] hx = {2,  2, 1,  1, -2, -2, -1, -1};
	static int[] hy = {1, -1, 2, -2,  1, -1,  2, -2};
	// 인접한 4방향으로의 움직임
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1,-1, 0,  0};
	// 방문여부 표시배열 
	static boolean[][] visit;
	static int cnt;
	static int horseMove;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();
				// System.out.print(map[i][j]+" ");
			}
			// System.out.println();
		}
		sc.close();
		visit = new boolean [H+1][W+1];
		bfs();
	}
	
	public static void bfs() {
		Queue<Coordinate> q = new  LinkedList<Coordinate>();
		q.add(new Coordinate(0, 0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			// 다 탐색했다면  
			if(x == (W - 1) && y == (H - 1)) {
				System.out.println(cnt);
				break;
			}
			
			if(horseMove < K) {
				// 말처럼 움직이기 
				for(int i=0; i<8; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];
					
					if(nx < 0 || ny < 0 || nx >= W || ny >= H ) // map의 범위를 벗어난다면 
						continue;
					if(map[nx][ny] == 1 || visit[nx][ny] == true) // 방해물이 있다면 
						continue;
					
					q.add(new Coordinate(nx, ny));
					visit[nx][ny] = true;
					horseMove++; // horseMove 증가 
					cnt++;
				}
				// 일반 4방으로만 움직이기 	
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= W || ny >= H ) // map의 범위를 벗어난다면 
						continue;
					if(map[nx][ny] == 1 || visit[nx][ny] == true) // 방해물이 있다면 
						continue;
					
					q.add(new Coordinate(nx, ny));
					visit[nx][ny] = true;
					cnt++;
				}
			}
			else if(horseMove == K) {
				// 일반 4방으로만 움직이기 	
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= W || ny >= H ) // map의 범위를 벗어난다면 
						continue;
					if(map[nx][ny] == 1) // 방해물이 있다면 
						continue;
					
					q.add(new Coordinate(nx, ny));
					visit[nx][ny] = true;
					cnt++;
				}
			}
			else // horseMove > K 일 때 
				continue;
		}
		
		System.out.println("-1"); // 불가능하다면 
		return;
		
	}
	
	static class Coordinate {
		int x;
		int y;
		Coordinate(int a, int b){
			x = a;
			y = b;
		}
	}
}

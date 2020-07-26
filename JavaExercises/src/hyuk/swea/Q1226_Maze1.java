package hyuk.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1226_Maze1 {
	private final static int MAZE_SIZE = 16;
	private final static int TEST = 10;
	private static int[][] arr;
	private static int[][] visited;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		for(int t = 1; t <= TEST; t++) {
			int sadasd = scn.nextInt();
			String tmp;
			arr = new int[MAZE_SIZE][MAZE_SIZE];
			visited = new int[MAZE_SIZE][MAZE_SIZE];
			for(int i = 0; i < MAZE_SIZE; i++) {
				tmp = scn.next();
				for(int j = 0; j < MAZE_SIZE; j++) {
					arr[i][j] = tmp.charAt(j) - '0';
					visited[i][j] = 0;
				}
			}
			//1. 출발점 찾기
			int[] start = findStart();
			Queue<Point> que = new LinkedList<Point>();
			que.offer(new Point(start[0], start[1]));
			int res = bfs(que);
			System.out.println("#" + t + " " + res);
		}
		scn.close();
	}
	private static int[] findStart() {
		int[] start = new int[2];
		for(int i = 0; i < MAZE_SIZE; i++) {
			for(int j = 0; j < MAZE_SIZE; j++) {
				if(arr[i][j] == 2) {
					start[0] = i;
					start[1] = j;
					return start;
				}
			}
		}
		return null;
	}
	private static int bfs(Queue<Point> que) {
		boolean suc = false;
		while(que.size() != 0) {
			//print();
			Point p = que.poll();
			if(arr[p.x][p.y] == 3) {
				suc = true;
				break;
			}
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			int nx,ny;
			for(int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx < 0 || nx >= MAZE_SIZE || ny < 0 || ny >= MAZE_SIZE) continue;
				if(arr[nx][ny] != 1) {
					if(visited[nx][ny] == 0) {
						que.offer(new Point(nx,ny));
						visited[nx][ny] = 1;
					}
				}
			}
		}
		if(suc == false) {
			return 0;
		}
		return 1;
	}
	private static void print() {
		for(int i = 0; i < MAZE_SIZE; i++) {
			for(int j = 0; j < MAZE_SIZE; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
class Point {
	public int x;
	public int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

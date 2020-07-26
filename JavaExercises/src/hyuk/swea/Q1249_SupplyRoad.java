package hyuk.swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1249_SupplyRoad {
	private static int[][] arr;
	private static int[][] visited;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = scn.nextInt();
			PriorityQueue<Box> pq = new PriorityQueue<Box>();
			String tmpArr; 
			arr = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				tmpArr = scn.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = tmpArr.charAt(j) - '0';
				}
			}
			// 1. input to pq
			pq.offer(new Box(0, 0, 0));
			int res = bfs(N,arr, visited, pq);
			System.out.println("#" + t + " " + res);
		}
		scn.close();
	}

	private static int bfs(int N,int[][] arr, int[][] visited, PriorityQueue<Box> pq) {

		while (pq.size() != 0) {
			if(visited[N-1][N-1] != 0) {
				break;
			}
			// 1. 작은놈 꺼내기
			Box box = pq.poll();
			if (visited[box.x][box.y] == 1)
				continue;
			visited[box.x][box.y] = 1;
			arr[box.x][box.y]= box.value; 
			//2. 큐에 넣기
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			int nx,ny;
			for(int i = 0; i < 4; i++) {
				nx = box.x + dx[i];
				ny = box.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if(visited[nx][ny] == 0) {
					pq.offer(new Box(nx,ny,box.value + arr[nx][ny]));
				}
			}
		}

		return arr[N-1][N-1];
	}
}

class Box implements Comparable<Box> {
	public int x, y;
	public int value;

	public Box(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Box b) {
		if (this.value > b.value) {
			return 1;
		} else if (this.value < b.value) {
			return -1;
		}
		return 0;
	}
}

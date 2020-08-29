package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1600_MonkeyToWantToBeAHorse {

	private int K, H, W;
	private int[][] arr;
	private int[][][] visited;
	private Queue<Monkey> que;
	private int[] hdx = {1,2,2,1,-1,-2,-2,-1};
	private int[] hdy = {2,1,-1,-2,-2,-1,1,2};
	private int[] dx = {0,1,0,-1};
	private int[] dy = {1,0,-1,0};

	public static void main(String[] args) {
		new q1600_MonkeyToWantToBeAHorse().service();
	}

	private void service() {
		Scanner scn = new Scanner(System.in);

		K = scn.nextInt();
		W = scn.nextInt();
		H = scn.nextInt();
		arr = new int[H][W];
		visited = new int[H][W][K+1];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				arr[i][j] = scn.nextInt();
				for(int k = 0; k <= K; k++) {
					visited[i][j][k] = 987654321;
				}
			}
		}
		que = new LinkedList<Monkey>();
		bfs();
		
		int ans = getAns();
		System.out.println(ans);
		
		scn.close();
	}
	private void bfs() {
		que.offer(new Monkey(0,0,K));
		visited[0][0][K] = 1;
		
		while(que.size() != 0) {
			Monkey monkey = que.poll();
			for(int i = 0; i < 8; i++) {
				int nx = monkey.x + hdx[i];
				int ny = monkey.y + hdy[i];
				if(monkey.k == 0) break;
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(visited[nx][ny][monkey.k-1] <= visited[monkey.x][monkey.y][monkey.k]+1) continue;
				if(arr[nx][ny] == 1) continue;
				visited[nx][ny][monkey.k-1] = visited[monkey.x][monkey.y][monkey.k]+1;
				que.offer(new Monkey(nx,ny,monkey.k-1));
			}
			for(int i = 0; i < 4; i++) {
				int nx = monkey.x + dx[i];
				int ny = monkey.y + dy[i];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				if(visited[nx][ny][monkey.k] <= visited[monkey.x][monkey.y][monkey.k]+1) continue;
				if(arr[nx][ny] == 1) continue;
				visited[nx][ny][monkey.k] = visited[monkey.x][monkey.y][monkey.k]+1;
				que.offer(new Monkey(nx,ny,monkey.k));
			}
		}
	}
	private int getAns() {
		int ans = 987654321;
		for(int i = 0; i <= K; i++) {
			if(visited[H-1][W-1][i] != 0) {
				ans = min(ans,visited[H-1][W-1][i]);
			}
		}
		if(ans == 987654321) return -1;
		return ans-1;
	}
	private int min(int a, int b) {
		if(a > b)	return b;
		return a;
	}
}

class Monkey {
	public int x, y, k;

	public Monkey(int x, int y, int k) {
		super();
		this.x = x;
		this.y = y;
		this.k = k;
	}

}
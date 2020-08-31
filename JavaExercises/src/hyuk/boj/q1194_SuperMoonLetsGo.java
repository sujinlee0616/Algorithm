package hyuk.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1194_SuperMoonLetsGo {
	
	private int N,M;
	private char[][] arr;
	private int[][][] visited;
	private final static int KEY_SIZE = 64;
	Queue<MinSick> que = new LinkedList<MinSick>();
	
	public static void main(String[] args) {
		new q1194_SuperMoonLetsGo().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		
		arr = new char[N][M];
		visited = new int[N][M][KEY_SIZE];
		for(int i = 0; i < N; i++) {
			String tmp = scn.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == '0') {
					que.offer(new MinSick(i, j, 0,new int[KEY_SIZE]));
					visited[i][j][0] = 1;
				}
			}
		}
		
		bfs();
		scn.close();
	}
	private void bfs() {
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		while(que.size() != 0) {
			MinSick min = que.poll();
			int x = min.x;
			int y= min.y;
			int k = min.key;
			int[] keys = getKeys(min.keys);
			//print();
			if(arr[x][y] == '1') {
				System.out.println(visited[x][y][k]-1);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(arr[nx][ny] == '#') continue;
				if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F') {
					if(keys[arr[nx][ny]-'A'] == 0) continue;
				}
				if(visited[nx][ny][k] != 0) continue;
				if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f') {
					keys[arr[nx][ny] - 'a'] = 1;
					visited[nx][ny][getKeySet(keys)] = visited[x][y][k]+1;
					que.offer(new MinSick(nx, ny, getKeySet(keys),getKeys(keys)));
					
				} else {
					que.offer(new MinSick(nx, ny, k,min.keys));
				}
				visited[nx][ny][k] = visited[x][y][k]+1;
			}
		}
		System.out.println(-1);
	}
	private int getKeySet(int[] keys) {
		int ans = 0;
		for(int i = 5; i >= 0; i--) {
			if(keys[i] == 1) {
				ans += getPower(5-i);
			}
		}
		return ans;
	}
	private int getPower(int num) {
		int ans = 1;
		for(int i = 0; i < num; i++) {
			ans *= 2;
		}
		return ans;
	}
	private void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(visited[i][j][0] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private int[] getKeys(int[] keys) {
		int[] resKeys = new int[KEY_SIZE];
		for(int i = 0; i < KEY_SIZE; i++) {
			resKeys[i] = keys[i];
		}
		return resKeys;
	}
}

class MinSick {
	public int[] keys;
	public int x,y,key;

	public MinSick(int x, int y, int key, int[] keys) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
		this.keys = keys;
	}
	
}
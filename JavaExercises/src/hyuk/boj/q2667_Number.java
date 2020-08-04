package hyuk.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q2667_Number {
	
	private static int N;
	private static int[][] arr;
	private static List<Integer> res;
	
	public static void main(String[] args) {
		new q2667_Number().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		res = new ArrayList<Integer>();
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String s = scn.next();
			for(int j = 0; j < N; j++) {
				
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1) {
					bfs(i,j);
				}
			}
		}
		
		Collections.sort(res);
		System.out.println(res.size());
		for(int data : res) {
			System.out.println(data);
		}
		scn.close();
	}
	private void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {x,y});
		arr[x][y] = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int ans = 0;
		while(que.size() != 0) {
			int[] node = que.poll();
			ans++;
			for(int i = 0; i < 4; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(arr[nx][ny] == 0) continue;
				arr[nx][ny] = 0;
				que.offer(new int[] {nx,ny});
			}
			
		}
		res.add(ans);
	}
}

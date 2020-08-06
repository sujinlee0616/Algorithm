package hyuk.boj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class q2667_ComplexAreaNumber_review01 {
	
	private static int N;
	private static int[][] area;
	private static int ans;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		new q2667_ComplexAreaNumber_review01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		String s;
		area = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			s = scn.next();
			for(int j = 0; j < N; j++) {
				area[i][j] = (int)(s.charAt(j) - '0');
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			for(int j = 0;j < N; j++) {
				if(area[i][j] == 1) {
					ans = 0;
					dfs(i,j);
					res.add(ans);
				}
			}
		}
		Collections.sort(res);
		print(res);
		
		
		scn.close();
	}
	private void print(List<Integer> list) {
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	private void dfs(int x, int y) {
		ans++;
		area[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(area[nx][ny] == 0) continue;
			area[nx][ny] = 0;
			dfs(nx,ny);
		}
	}
}

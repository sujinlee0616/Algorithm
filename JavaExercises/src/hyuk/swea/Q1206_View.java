package hyuk.swea;

import java.util.Scanner;

public class Q1206_View {
	
	private static int[][] loc = new int[300][1010];
	private static int N;
	private static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int test = 10;
		for(int t = 1; t <= test; t++) {
			input();
			int res = countView();
			System.out.println("#" + t + " " + res);
		}
	}
	
	private static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 255; j++) {
				loc[j][i] = 0;
			}
		}
	}
	private static void input() {
		N = scn.nextInt();
		init();
		for(int i = 0; i < N; i++) {
			int h = scn.nextInt();
			for(int j = 0; j < h; j++) {
				loc[j][i] = 1;
			}
		}
	}
	private static int countView() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 255; j++) {
				if(loc[j][i] == 1) {
					if(check(j,i)) {
						count++;
					}
				}
			}
		}
		return count;
	}
	private static boolean check(int y, int x) {
		int[] dx = {-2, -1, 1, 2};
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			if(loc[y][nx] == 1) {
				return false;
			}
		}
		return true;
	}
}

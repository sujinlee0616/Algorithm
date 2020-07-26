package hyuk.swea;

import java.util.Scanner;

public class Q1210_Ladder {
	private static int[][] ladder = new int[100][100];
	private static int[][] visited = new int[100][100];
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = 10;
		for(int t = 1; t <= test; t++) {
			int te = scn.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = scn.nextInt();
				}
			}
			//print(ladder);
			int i = 0;
			for(i = 0; i < 100; i++) {
				boolean suc = false;
				if(ladder[0][i] == 1) {
					init();
					visited[0][i] = 1;
					int x = 0;
					int y = i;
					while(true) {
						if(ladder[x][y] == 2) {
							System.out.println("#" + te + " " + i);
							suc = true;
							break;
						} else if(x == 99) {
							break;
						}
						
						int[] dx= {0,0,1};
						int[] dy = {1,-1,0};
						int nx = 0; int ny = 0;
						for(int j = 0; j < 3; j++) {
							nx = x + dx[j];
							ny = y + dy[j];
							if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
							if(visited[nx][ny] == 1) continue;
							if(ladder[nx][ny] != 0) {
								x = nx; y = ny;
								visited[x][y] = 1;
								break;
							}
						}
					}
				}
				if(suc == true) {
					break;
				}
			}
		}
		scn.close();
	}
	
	private static void print(int[][] arr) {
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void init() {
		for(int i = 0 ; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				visited[i][j] = 0;
			}
		}
	}
}

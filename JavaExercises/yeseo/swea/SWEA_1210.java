package swea;

import java.util.Scanner;

public class SWEA_1210 {
	/*
	 * Ladder1 
	 * 
	 * 
	 * 2차원배열로 사다리 타기를 구현해보자
	 *
	 *1 = 우 혹은 좌 혹은 하향 (상은 없음) 
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= 10; t++) {
			int C = scan.nextInt();
			/////////////
			int find = 0;
			int ladder[][] = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = scan.nextInt();
					// System.out.println(ladder[i][j]+"i="+i+"j="+j);
				}
			}

			for (int i = 0; i < 100; i++) {
				if (ladder[0][i] == 1) {
					// y 100 하향 
					int x = 0;
					int y = i;
					// 이동 Vector
					int[][] v = new int[100][100];
					v[x][y] = 1;
					while (true) {
						//출발지점 보다는크고 (전위치도 true) (포인터 다음 위치 false  ) 
						if (y - 1 >= 0 && ladder[x][y - 1] == 1 && v[x][y + 1] == 0)
							y--;
						//도착지점 보다는 작고 
						else if (y + 1 < 100 && ladder[x][y + 1] == 1 && v[x][y + 1] == 0)
							y++;
						else
							x++;
						////////////
						v[x][y] = 1;
						if (x == 99) {
							if (ladder[x][y] == 2) { //종료조건 
								find = 1;
								System.out.println("#" + t + " " + i);
							}
							break;
						}
					}
					if (find == 1)
						break;
				}
			}
		}
	}
}

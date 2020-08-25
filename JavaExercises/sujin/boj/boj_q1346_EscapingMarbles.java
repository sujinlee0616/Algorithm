package boj;

import java.util.Scanner;

// - '.': 빈 칸 / '#': 공이 이동할 수 없는 장애물 또는 벽 / 'O': 구멍의 위치 / 'R':빨간 구슬의 위치 / 'B': 파란 구슬의 위치
// - 입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개
// - 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력
// - 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력

public class boj_q1346_EscapingMarbles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] arr = new String[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j]=sc.next();
			}
		}

	}
	
	
}

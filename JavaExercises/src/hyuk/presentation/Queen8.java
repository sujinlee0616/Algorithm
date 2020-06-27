package hyuk.presentation;

public class Queen8 {
	public static void main(String[] args) {
		int[][] arr = new int[8][8];
		locQueen(0,arr);
	}

	private static boolean locQueen(int pos, int arr[][]) {
		System.out.println("pos : " + pos);
		if (pos == 8) {
			// 출력
			printQueen(arr);
			return true;
		}

		for (int i = 0; i < 8; i++) {
			// 검사한다
			boolean ans = checkQueen(arr, pos, i);
			// 결과가 true이면 거기에 두고 다음으로!
			if(ans == true) {
				arr[pos][i] = 1;
				printQueen(arr);
				boolean res = locQueen(pos+1,arr);
				arr[pos][i] = 0;
				if(res == true) {
					return true;
				}
			}
			// 결과가 false이면 다음 포문!
		}
		return false;
	}

	private static void printQueen(int arr[][]) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i][j] == 0) {
					System.out.print("□");
				} else {
					System.out.print("■");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean checkQueen(int arr[][], int x, int y) {
		// 가로 검사
		int count = 0;
		for (int i = 0; i < 8; i++) {
			if (arr[x][i] == 1) {
				count++;
			}
		}
		if (count > 0) {
			return false;
		}

		// 세로 검사
		count = 0;
		for (int i = 0; i < 8; i++) {
			if (arr[i][y] == 1) {
				count++;
			}
		}
		if (count > 0) {
			return false;
		}
		// 대각선 검사
		count = 0;
		int[] dx = { -1, 1, 1, -1 };
		int[] dy = { 1, 1, -1, -1 };
		int tx = x;
		int ty = y;
		for (int k = 1; k <= 8; k++) {
			for (int i = 0; i < 4; i++) {
				tx = x; ty = y;
				tx += dx[i]*k;
				ty += dy[i]*k;
				if((tx < 0 || ty < 0 || tx >= 8 || ty >= 8)) {
					continue;
				}
				if(arr[tx][ty] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}

package hyuk.kakao;

public class Kakao_LockAndKey {
	public static void main(String[] args) {

		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};

		boolean ans = new Kakao_LockAndKey().solution(key, lock);
		System.out.println(ans);
	}

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;

		int N = lock.length;
		int M = key.length;

		int[][] arr = new int[2 * M + N][2 * M + N];
		for (int i = M; i < N + M; i++) {
			for (int j = M; j < N + M; j++) {
				arr[i][j] = lock[i - M][j - M];
			}
		}
		answer = getAnswer(arr, N, M, key, lock);

		return answer;
	}

	private boolean getAnswer(int[][] arr, int N, int M, int[][] key, int[][] lock) {
		for (int i = 0; i < N + M; i++) {
			for (int j = 0; j < N + M; j++) {
				if (locKey(arr, N, M, key, lock, i, j)) {
					//System.out.println("suc x,y : " + i + "," + j);
					return true;
				}
			}
		}
		return false;
	}

	private boolean locKey(int[][] arr, int N, int M, int[][] key, int[][] lock, int x, int y) {
		for (int i = 0; i < 4; i++) {
			rotKey(key, M);
			setLock(arr, N, M, key, lock, x, y);
			//print(arr,N,M);
			if (check(arr, N, M))
				return true;
			init(arr, N, M, lock);
		}
		return false;
	}

	private void setLock(int[][] arr, int N, int M, int[][] key, int[][] lock, int x, int y) {
		for(int i = x; i < x + M; i++) {
			for(int j = y; j < y + M; j++) {
				arr[i][j] += key[i-x][j-y];
			}
		}
	}

	private void rotKey(int[][] key, int M) {
		int[][] copiedKey = copyKey(key, M);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				copiedKey[j][M - i-1] = key[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				key[i][j] = copiedKey[i][j];
			}
		}
	}

	private int[][] copyKey(int[][] key, int M) {
		int[][] res = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				res[i][j] = key[i][j];
			}
		}
		return res;
	}

	private boolean check(int[][] arr, int N, int M) {
		for (int i = M; i < N + M; i++) {
			for (int j = M; j < N + M; j++) {
				if (arr[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	private void init(int[][] arr, int N, int M, int[][] lock) {
		for (int i = M; i < N + M; i++) {
			for (int j = M; j < N + M; j++) {
				arr[i][j] = lock[i - M][j - M];
			}
		}
	}
	
	
	private void print(int[][] key) {
		System.out.println("\n---------------");
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key.length; j++) {
				System.out.print(key[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n---------------");
	}
	private void print(int[][] key, int N, int M) {
		System.out.println("\n---------------");
		for(int i = 0; i < N+M*2; i++) {
			for(int j = 0; j < N+M*2; j++) {
				System.out.print(key[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n---------------");
	}
}

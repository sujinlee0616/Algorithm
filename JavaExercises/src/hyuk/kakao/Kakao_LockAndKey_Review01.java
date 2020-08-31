package hyuk.kakao;

public class Kakao_LockAndKey_Review01 {
	public static void main(String[] args) {
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,0,1},{1,1,0},{1,0,1}};
		boolean ans = new Kakao_LockAndKey_Review01().solution(key,lock);
		System.out.println(ans);
	}
	
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		
		//0. 초기화
		int N = lock.length;
		int M = key.length;
		//1. 검색할 배열 만들기
		int[][] arr = new int[2*M+N][2*M+N];
		for(int i = M; i < N+M; i++) {
			for(int j = M; j < N+M; j++) {
				arr[i][j] = lock[i-M][j-M];
			}
		}
		//2. 키 회전하기
		answer = rotKey(arr,N,M,key,lock);
		
		return answer;
	}
	private boolean rotKey(int[][] arr, int N, int M, int[][] key, int[][] lock) {
		for(int i = 0; i < 4; i++) {
			//키 회전 로직 
			key = getRotKey(key, M);
			//열쇠 짝 맞추기 - (0,0) ~ (N+M,N+M)
			if(getKey(arr,N,M,key,lock)) return true;
		}
		return false;
	}
	private int[][] getRotKey(int[][] key, int M) {
		int[][] copyKey = new int[M][M];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				copyKey[j][M-1-i] = key[i][j];
			}
		}
		return copyKey;
	}
	private boolean getKey(int[][] arr, int N, int M, int[][] key, int[][] lock) {
		for(int i = 0; i < N+M; i++) {
			for(int j = 0; j < N+M; j++) {
				//열쇠 짝 맞추기 - arr에 (x,y)부터 (x+M,y+M)까지
				makeArr(arr,key,i,j,M);
				// 검사하기
				if(check(arr,N,M)) return true;
				// 다시 초기화하기
				init(arr,lock,N,M);
			}
		}
		return false;
	}
	private void makeArr(int[][] arr, int[][] key, int x, int y, int M) {
		for(int i = x; i < x+M; i++) {
			for(int j = y; j < y+M; j++) {
				arr[i][j] += key[i-x][j-y];
			}
		}
	}
	private boolean check(int[][] arr, int N, int M) {
		for(int i = M; i < N+M; i++) {
			for(int j = M; j < N+M; j++) {
				if(arr[i][j] != 1) return false;
			}
		}
		return true;
	}
	private void init(int[][] arr, int[][] lock, int N, int M) {
		for(int i = M; i < M+N; i++) {
			for(int j = M; j < M+N; j++) {
				arr[i][j] = lock[i-M][j-M];
			}
		}
	}
}

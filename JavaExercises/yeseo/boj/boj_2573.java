package boj;


//X! 값 0 나옴 - 수정 필요 


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_2573 {
//빙산 
//4방 0의 개수 카운팅해서 줄어듦 
//0과 만나면 더이상 줄지 않음 
//두 덩어리 이상으로 분리되는 T 출력 (true) 
//전부 녹을때 까지 분리되지 않으면 0 (false) 

// in) N, M, map
// out) 최초의 시간 T 
	
	static int N, M;
	static int map[][]= new int[301][301];
	static boolean visited[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
// dfs는 구현하겠는데 init + allMelt 


	
	// 참고 
	public static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++ ) {
				visited[i][j] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//init();
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		Scanner scan=new Scanner(System.in);

		N=scan.nextInt();
		M=scan.nextInt();
		// 입력 받기
		for (int i = 0; i < N; i++) 			
			for (int j = 0; j < M; j++)
				map[i][j] = scan.nextInt();
		

		// solution
		int T = 0;
		while (true) {
			int count = 0;
			
			visited = new boolean[N][M];
			boolean check = false;

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (map[i][j] > 0 && visited[i][j] == false) {
						count++;
						if (count == 2) {
							check = true;
							break;
						}
						dfs(i, j);
					}
				}
			}
			// FALSE
			if (check)
				break;
			if (count == 0) {
				System.out.println(0);
				return;
			}
			init();
			// TRUE -> 두덩이로 나뉘는 부분 출력
			allMelt();
			T++;
		}
		System.out.println(T);
		return;
	}

	public static void dfs(int x, int y) {
		//초기화 
		visited[x][y]=true;
		// 탐색
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			// 범위 벗어난 경우
			if (cx < 1 || cx >= N - 1 || cy < 1 || cy >= M - 1)
				continue;
			// 조건에 맞는 경우
			if (map[cx][cy] > 0 && visited[cx][cy] == false)
				dfs(cx, cy);
		}
	}

	public static void allMelt() {

		int[][] temp = new int[301][301];

		for (int x = 0; x < N; x++)
			for (int y = 0; y < M; y++)
				temp[x][y] = map[x][y];

		for (int x = 1; x < N; x++) {
			for (int y = 1; y < N; y++) {
				int cnt = 0;
				if (temp[x][y] > 0) {

					// 탐색
					for (int i = 0; i < 4; i++) {
						int cx = x + dx[i];
						int cy = y + dy[i];

						if (temp[cx][cy] == 0)
							cnt++;
					}

					map[x][y] -= cnt;
					if (map[x][y] < 0)
						map[x][y] = 0;

				}
			}
		}
	}


}

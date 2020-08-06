package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [풀이방법1] 
// - 하루가 지나면, 익지 않은 토마토 옆에 있는 토마토가 익는다. 
// - M: 가로칸, N: 세로칸 // 2 ≤ M,N ≤ 1,000
// - 1: 익었음 / 0 : 안 익었음 / -1: 토마토 안 들어있는 칸. 
// - 토마토가 모두 익을때까지의 날짜 출력. 
//   (단, 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력) 

/* 다른풀이방법) 
  - visited[]를 int배여롤 만들어서 탐색할때마다 값 1씩 증가하게 만들고, 최대값 출력하면 day 출력 가능. 
  - 방문 안 한 경우 : visited[i][j]=0 
  - 1번째 노드 방문 : visited[i][j]=1
  - 2번째 노드 방문: visited[i][j]=2 ... 이런식으로 해서 
  - visitied[][] 최대값 - 1 하면 걸린 날짜 출력 가능. 
 */
public class boj_q7576_tomatoes {
	
	static int M;
	static int N; 
	static int[][] map;
	static boolean[][] visited;
	// (x,y) --> (0,1) 우 / (1,0) 하 / (0,-1) 좌 / (-1,0) 상  
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<coordinate> queue = new LinkedList<coordinate>();
	
	public static void main(String[] args) {
		// M X N =  10^6 = 100만 --> 걍 Scanner로 받아도 되겠넹 
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 가로칸 
		N = sc.nextInt(); // 세로칸 

		map = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				//System.out.print("map["+i+"]["+j+"]="+map[i][j]+" ");
			}
			//System.out.println();
		}
		bfs();
		
		// 모두 익히는게 불가능할 떄 -1 처리 해줘야함 
		
	}
	
	static void bfs() { // 인자가 필요 없겠는데? x_start, y_start가 주어지는게 아니라 내가 구해야 하니까. 
		
		int cntDay=0; 
		
		// 1. 시작점 집어넣는다 - 익은 애들을 일단 찾아서 넣어야 (값이 1인 애들) 
		// - 이중배열을 탐색해서 1인 애들의 x,y값을 queue에 넣자. 
		//   ==> findStart 메소드를 만들었음 
		
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					queue.add(new coordinate(i, j));
					visited[i][j] = true; // 방문 표시 
				}
			}
		}
		
		while(!queue.isEmpty()) {
			// 2. 집어넣은 놈 꺼낸다. 
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			
			// 3. 꺼낸 놈의 자식 Node를 Queue에 집어넣는다. (단, queue에 넣은 적 없어야함.) 
			// 상하좌우 4방향으로 탐색 - 하루 
			for(int i=0; i<4; i++) {
				int nx = x + dx[i]; 
				int ny = y + dy[i]; 
				
				if(nx>=0 && ny>=0 && nx<M && ny<N) { // map 범위 안에 x,y 좌표가 존재하면 
					if(map[nx][ny] == 0 && visited[nx][ny] == false ) {
						queue.add(new coordinate(nx, ny));
						visited[nx][ny] = true; // 방문 표시 
						map[nx][ny] = 1; // 주변 토마토를 익힌다 
					}
				}
				
				// Tip) 범위 체크하는거 아래와 같이 하면 중괄호 {} 안 만들어도 돼서 편하다. 
				// if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

			}
			//cntDay++; // <-- 여기서 cntDay++ 하면 엄청 중복되겠네.. 시작점도 여러개고 노드도 여러개잖아.. 
		}
		
		System.out.println(cntDay);
		
	}
	
	/* 
	static void findStart() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					queue.add(new coordinate(i, j));
				}
			}
		}
	}
	*/
	
	static class coordinate {
		int x;
		int y;
		coordinate(int a, int b){
			x = a;
			y = b;
		}
	}

}

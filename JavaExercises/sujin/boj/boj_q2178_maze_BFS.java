package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 최단경로 구하. BFS 문제. 
// N, M(2 ≤ N, M ≤ 100) ==> 숫자 작으니까 Scanner 써도 될듯. 

// 참고자료) BFS 설명 
// https://velog.io/@skyepodium/BFS%EB%8A%94-%EB%82%AF%EC%84%A4%EC%96%B4%EC%84%9C

// 배경지식) 
// - static int[] dx = {0,1,0,-1};
//   static int[] dy = {1,0,-1,0};
// - int nx = x + dx[i];
//   int ny = y + dy[i];
// - 위와 방법 쓰면 쉽게 좌표 구할 수 있다. 

public class boj_q2178_maze_BFS {
	
	static int n,m;
	// (dx,dy) : 우(0,1), 하(1,0), 좌(0,-1), 상(-1,0) // ★★★★★★★★★
	// ㅎ ㅏ.... 누가 이렇게 만들 생각을 했을까... 짱 우아해... 최고야..... 
	static int[] dx = {0,1,0,-1}; // ★★★
	static int[] dy = {1,0,-1,0}; // ★★★
	static int map[][]; // 미로 
	static boolean[][] visited; // 방문표시 배열 
	static int res;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		map=new int[n][m];
		String[] s=new String[n];
		
		for(int i=0;i<n;i++)
			s[i]=sc.next();
		
		// map배열에다가 입력값 넣었음 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = s[i].charAt(j)-'0';
				//System.out.print(map[i][j]+" ");
			}
			//System.out.println();
		}
		
		bfs(0,0);
		System.out.println(map[n-1][m-1]);
	}
	
	static void bfs(int x_start,int y_start) {
		// Queue를 이용해서 bfs를 구현해보자. 
		Queue<coordinate> queue = new LinkedList<coordinate>();
		
		// 방문여부 체크 배열 
		visited = new boolean[n][m];
				
		// 1. 시작점 집어넣는다 
		queue.add(new coordinate(x_start, y_start));
		visited[x_start][y_start] = true; // 방문 표시 
		
		while(!queue.isEmpty()) {
			// 2. 집어넣은 놈 꺼낸다. 
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			
			// 3. 꺼낸 놈의 자식 Node를 Queue에 집어넣는다. (단, queue에 넣은 적 없어야함. == 방문X여야) 
			// 상하좌우 4방향으로 탐색한다. ★★★★★★
			for(int i=0; i<4; i++) {
				int nx = x + dx[i]; // 0,1,0,-1  // ★★★
				int ny = y + dy[i]; // 1,0,-1,0  // ★★★
				// i=0 ==> nx=x+0; ny=y+1; ==> 우 
				// i=1 ==> nx=x+1; ny=y+0; ==> 하
				// i=2 ==> nx=x+0; ny=y-1; ==> 좌
				// i=3 ==> nx=x-1; ny=y+0; ==> 상
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) { // map 범위 안에 x,y 좌표가 존재하면 
					if(map[nx][ny] == 1 && visited[nx][ny] == false ) {
						queue.add(new coordinate(nx, ny));
						visited[nx][ny] = true; // 방문 표시 
						map[nx][ny] = map[x][y]+1; // 지나가는 경로대로 첨에 1부터 시작해서 2,3,... 
					}
				}
			}
		}
	}
	
	// [x][y] 함께 다루어야 하므로 클래스로 만든다. 
	static class coordinate {
		int x;
		int y;
		
		coordinate(int a, int b){
			x = a;
			y = b;
		}
		
	}



}

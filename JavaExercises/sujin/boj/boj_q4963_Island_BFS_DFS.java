package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [풀이방법1] BFS 풀이 
// - 백준 2667번 단비번호 붙이기와 비슷한 문제 ()
// - DFS/BFS 참고 : https://developer-mac.tistory.com/64

// [기타] BufferredWriter로 int 출력하기 
// - bw.write(cnt); 하면 아스키코드값이 출력됨!! (int cnt)
// - bw.write(cnt+"\n"); 과 같이 하는게 편함... 설명은 아래에.
public class boj_q4963_Island_BFS_DFS {
	
	// (x,y) :(-1,-1) 좌상, (-1,0) 상, (-1,1) 우상, (1,-1) 좌하, ... 
	static int dx[] = {-1,-1,-1,  1,1,1 , 0, 0};
	static int dy[] = {-1, 0, 1, -1,1,0 , 1,-1};
	static int[][] map;
	static int[][] visited;
	static Queue<coordinate> q;
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st1.nextToken());
			h = Integer.parseInt(st1.nextToken());
			
			if(w == 0 && h == 0) // 0,0일때만 멈춤 
				break;
			
			map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				String s = br.readLine();
				StringTokenizer st2 = new StringTokenizer(s);
				for(int j = 0; j < w; j++) 
					map[i][j]=Integer.parseInt(st2.nextToken());
			}
			
			int cnt = 0;
			visited = new int[h][w];
			
			// ★★★★★
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && visited[i][j] == 0)
						// [풀이방법1] BFS 사용 
						// bfs(i, j, ++cnt);
						// [풀이방법2] DFS 사용
						dfs(i, j, ++cnt);
				}
			}
			// System.out.println(cnt);
			bw.write(cnt+"\n");
			// [주의] 그냥 bw.write(cnt); 하면 아스키코드값이 출력됨!!! ==>   ★★★
			// - writer에 int를 넣으면 아스키 코드에 따른 char형 값이 출력된다.
	        // - 그러나 i와 개행 처리 문자열 "\n" 을 더하면 String 으로 자동 형변환 되기 때문에 저장되어 있는 int 값 그대로 출력이 가능하다.
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void bfs(int x, int y, int cnt) {
		
		q = new LinkedList<coordinate>();
		q.add(new coordinate(x, y));
		visited[x][y] = cnt;
		
		while(!q.isEmpty()) {
			x = q.peek().x;
			y = q.peek().y;
			q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
					if(map[nx][ny] == 1 && visited[nx][ny] == 0)
						bfs(nx, ny, cnt);
				}
			}
		}
		
	}
	
	static void dfs(int x, int y, int cnt) {
		visited[x][y] = cnt;
	
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx <h && ny < w )
				if(map[nx][ny] == 1 && visited[nx][ny] == 0)
					dfs(nx, ny, cnt);
		}
		
	}
	
}


class coordinate {
	int x;
	int y;
	coordinate(int a,int b){
		x = a;
		y = b;
	}
}





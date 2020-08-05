package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [풀이1] BFS
// - 인접한 단지의 수, 그리고 단지별 가구 수 오름차순으로 출력. 
// - map: N X N 정사각형. (5≤N≤25)
public class boj_q2667_BFS {
	
	static int n;
	static int[][] map;
	// (dx,dy) ==> (0,1) 우 // (1,0) 하 // (0,-1) 좌 // (-1,0) 상 
	static int[] dx = {0,1,0,-1}; 
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] tmp; // 작업용 임시 배열 
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력값 배열에 저장.. ==> 한 줄 문자열로 받아서 그거 한자씩 쪼개는 방법은 이미 써봤으니까 다른 방법 써보자. 
		// BufferedReader 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// map 저장 
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<n;j++) 
				map[i][j] = s.charAt(j)-'0';
		}
		
		bfs(map, 0,0);
		// 단지별 수 저장 - ArrayList에 담아서 오름차순 정렬할 때 Collections.sort() 써버리자. 
		
	}
	
	static void bfs(int[][] arr, int x_start, int y_start) {
		
		Queue<coordinate> queue = new LinkedList<coordinate>();
		
		visited = new boolean[n][n]; // 방문 체크 배열 
		tmp = new int[n][n]; // 작업용 임시 배열 

		// 1. 큐에 처음 시작하는 놈을 담자. (0,0)부터 시작해서 (n-1,n-1)까지 탐색한다고 치자. 
		queue.add(new coordinate(x_start, y_start)); 
		visited[x_start][y_start] = true; 
		
		int[] complex = new int[n*n]; // 단지의 수를 세는...complex 배열을 만들어보자. 
		// ex. complex[1]=3, complex[2]=4, ==> 1번단지에 집 3가구, 2번 단지에 집 4가구 있다. 
		int ci=0; // ci: complex_index. complex 배열의 인덱스. 
		
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			
			// 4방향으로 탐색 - map[][]==1인 놈을 찾아라. 찾은 후 단지 번호 붙이고 숫자 세라. 
			// 단지 숫자 세고 단지별 가구 수 세는게 까다롭겠네... 이걸 어떻게 해야할까? 
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 이걸 while문으로 하면 되려나? 
				while(arr[nx][ny]==1 && visited[nx][ny]==false) {
					arr[nx][ny] = arr[x][y] + 1; 
					
				}
				
			}
			
		}
		
	}
	
	// x,y 한 번에 다뤄야 하니까 편하게 쓰려고 클래스 만들었음 
	static class coordinate{
		int x;
		int y;
		coordinate(int a,int b){
			x=a;
			y=b;
		}
	}
	
}








package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [풀이1] BFS
// - 인접한 단지의 수, 그리고 단지별 가구 수 오름차순으로 출력. 
// - map: N X N 정사각형. (5≤N≤25)
// - 단지 수를 세고 단지별 가구 수를 카운트하는게 어려웠음. 
// - 이 문제는 DFS로 푸는게 더 쉽다. 

// [배경지식] Queue에서 add와 offer의 차이? 
// - 큐가 이미 꽉 찼을 때, add하면 예외를 발생시키지만 offer하면 추가 실패를 의미하는 false를 리턴한다. 

public class boj_q2667_BFS {
	
	static int n;
	static int[][] map;
	// (dx,dy) ==> (0,1) 우 // (1,0) 하 // (0,-1) 좌 // (-1,0) 상 
	static int[] dx = {0,1,0,-1}; 
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] tmp; // 작업용 임시 배열 
	static Queue<coordinate> q = new LinkedList<coordinate>();
	static ArrayList<Integer> house_in_complex = new ArrayList<Integer>(); // 인덱스번호 단지의 가구 수 ex) house_in_complex.get(0) = 12; ==> 0번째 단지에는 12가구가 있음 
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력값 배열에 저장.. ==> 한 줄 문자열로 받아서 그거 한자씩 쪼개는 방법은 이미 써봤으니까 다른 방법 써보자. 
		// BufferedReader 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int complex = 0; // 단지의 수 
		
		// map 저장 
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<n;j++) 
				map[i][j] = s.charAt(j)-'0';
		}
		
		visited = new boolean[n][n]; // 방문 체크 배열 
		
		// BFS로 풀려면, BFS(map,0,0) 하면 단지 카운트하고 단지별 가구 수 카운트하는게 너무 복잡해짐... ==> for문 돌려서 그때그때 count하자. 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && visited[i][j]==false){
					bfs(i,j);
					complex++;
				}
			}
		}
		System.out.println(complex);
		
		// 단지별 수 저장 - 오름차순으로 출력하랬으니까 ArrayList에 담아서 Collections.sort() 써버리자. 
		Collections.sort(house_in_complex);
		for(int i=0;i<house_in_complex.size();i++) {
			System.out.println(house_in_complex.get(i));
		}
	}
	
	static void bfs(int x_start, int y_start) {
		
		int house=1; // 이 단지의 가구 수 

		// 1. 큐에 처음 시작하는 놈을 담자. (0,0)부터 시작해서 (n-1,n-1)까지 탐색한다고 치자. 
		q.add(new coordinate(x_start, y_start)); 
		visited[x_start][y_start] = true; 
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			// 4방향으로 탐색 - map[][]==1인 놈을 찾아라. 찾은 후 단지 번호 붙이고 숫자 세라. 
			// 단지 숫자 세고 단지별 가구 수 세는게 까다롭겠네... 이걸 어떻게 해야할까? 
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(map[nx][ny]==1 && visited[nx][ny]==false) {
						q.add(new coordinate(nx, ny));
						visited[nx][ny] = true;
						house++;
					}
				}
			}
		}
		house_in_complex.add(house);
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








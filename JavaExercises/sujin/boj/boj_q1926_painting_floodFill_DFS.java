package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// - 플러드필(flood fill) 문제. 
// - 다른 방법으로도 풀 수 있는지 체크해볼 것 
// - 단지 번호 붙이기(boj q2667)이랑 거의 유사한 문제.  

// [배경지식]
// - List의 최대값 구하기 : Collections.max(list);

// [배경지식] Flood Fill 
// - https://m.blog.naver.com/jh20s/221156150859
// - https://ko.wikipedia.org/wiki/%ED%94%8C%EB%9F%AC%EB%93%9C_%ED%95%84

public class boj_q1926_painting_floodFill_DFS {
	
	static int n;
	static int m;
	static int[][] map;
	// (dx,dy) ==> (0,1) 우 / (1,0) 하 / (0,-1) 좌 / (-1,0) 상 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; 
	static boolean[][] visited; 
	
	static int paintings;
	static int tmp_area;
	static ArrayList<Integer> area = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		visited = new boolean[n][m];
		
		// 이렇게 하면 행이 바뀌면 연속되는 area여도 새로 bfs 실행함 ★★★
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1 && visited[i][j]==false) {
					tmp_area = 1;
					dfs(i,j);
					paintings++;
	                area.add(tmp_area);
				}
			}
		} 
		
		System.out.println(paintings);
        try {
            System.out.println(Collections.max(area)); // 
        } catch (Exception e) {
            System.out.println(0);
        }
		
	}

	static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
        	int nx = x + dx[i];
        	int ny = y + dy[i];
        	
            if(nx >= 0 && ny >= 0 && nx <n && ny <m) {
            	if(map[nx][ny]==1 && visited[nx][ny]==false) {
            		tmp_area++;
                    dfs(nx,ny);
            	}
            }
        }
    }

	
}






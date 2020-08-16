package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 푸는 중!!! 
public class boj_q4963_Island {
	
	// (x,y) :(-1,-1) 좌상, (-1,0) 상, (-1,1) 우상, (1,-1) 좌하, ... 
	static int dx[] = {-1,-1,-1,  1,1,1 , 0, 0};
	static int dy[] = {-1, 0, 1, -1,1,0 , 1,-1};
	static int[][] arr;
	static Queue<coordinate> q;
	static int island;
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		// 여러번 받으려면? 
		w = Integer.parseInt(st1.nextToken());
		System.out.println("w="+w);
		h = Integer.parseInt(st1.nextToken());
		System.out.println("h="+h);
		
		arr = new int[h+1][w+1];
		
		for(int i=1; i<=h; i++) {
			String s = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s);
			for(int j=1; j<=w; j++) {
				arr[i][j]=Integer.parseInt(st2.nextToken());
				// System.out.print(arr[i][j]+" ");
			}
			// System.out.println();
		}
		
		br.close();
		
		System.out.println(bfs(arr,0,0));
		
		// 1X1 또는 1X4, 5X1 이런 경우?
			
	}
	
	static int bfs(int[][] arr, int x_start, int y_start) {
		island = 0; 
		
		q = new LinkedList<coordinate>();
		q.add(new coordinate(x_start, y_start));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for(int i=0; i<8; i++) {
				int nx = x_start + dx[i];
				int ny = y_start + dy[i];
				
				if(nx>=0 && ny>=0 && nx<=w && ny<=h) {
					
				}
				island++;
			}
		}
		
		return island;
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





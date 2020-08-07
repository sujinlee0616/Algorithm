package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1249 {
/*
보급로 

복구시간 = 깊이 가 가장 낮은 (짧은) 경로의 깊이를 구하라
거리는 고려 안 함 

입력) TestCase
배열 개수 = N 
NxN배열 요소값 
 */
	static int N;
	static int[][] map;
	//direction 
	static int[] mx= {-1,1,0,0};
	static int[] my= {0,0,-1,1};
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			N=Integer.parseInt(br.readLine());
			
			map=new int[N][N];
			
		for(int i=0;i<N;i++) {
			String []temp=br.readLine().split("");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
			}
		}
		
		dkstra(t,0,0);
	 }
		
		br.close();
	}
	//다익스트라 - 하나의 정점에 연결된 정점을 추가해 최단 경로를 갱신 
	//힙(우선순위 큐) 
	private static void dkstra(int test,int x,int y) {
		boolean[][]visited;
		int [][]distance;
		
		visited=new boolean[N][N];
		distance=new int[N][N];
		
		//distance 
		for(int i=0;i<N;i++) {
			//모두 가장 큰 수로 초기화 함 
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			
			distance[x][y]=0;
			visited[x][y]=true;
			
			for(i=0;i<4;i++) {
				int dx=x+mx[i];
				int dy=y+my[i];
				if(isValidPosition(dx,dy)&&!visited[dx][dy])
					distance[dx][dy]=map[dx][dy];
			}
			
			for(int a=0;a<N*N-2;a++) {
				int min=Integer.MAX_VALUE;
				int minX=-1;
				int minY=-1;
				
				for(i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(!visited[i][j]&&distance[i][j]!=Integer.MAX_VALUE) {
							if(distance[i][j]<min) {
								min=distance[i][j];
								minX=i;
								minY=j;
							}
						}
					}
				}
				
				visited[minX][minY]=true;
				for(i=0;i<4;i++) {
					int dx=minX+mx[i];
					int dy=minY+my[i];
					if(isValidPosition(dx, dy) && !visited[dx][dy]){
	                    if(distance[dx][dy] > distance[minX][minY] + map[dx][dy]){
	                        distance[dx][dy] = distance[minX][minY] + map[dx][dy];
	                    }
	                }                
	            }
	        }

	        System.out.println("#" + test + " " + distance[N-1][N-1]);
		}
	 }
	  
	    private static boolean isValidPosition(int x, int y){
	        if(x < 0 || x >= N || y < 0 || y >= N)
	            return false;
	        return true;
	    }
	}
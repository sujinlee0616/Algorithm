package incorrect_note;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_D_BFS {
//DFS BFS
/*
간선, 노드, 정점
정점은 1~N순으로 
간선은 양방향 

 */
	public static void dfs(int arr[][],boolean visited[],int p) {
		int N=arr.length-1; // 1~N
		visited[p]=true; 
		System.out.print(p+" "); // 정점 출력
		
		for(int i=1;i<=N;i++) {
			if(arr[p][i]==1 && !visited[i]) //간선 연결 & false (not visited) 
				dfs(arr,visited,i);
		}
		
	}
	
	
	public static void bfs(int arr[][],int p) {
		Queue<Integer> q=new LinkedList<>();
		
		int N=arr.length-1;
		boolean visited[]=new boolean[arr.length];
		
		q.add(p);
		visited[p]=true;
		
		while(!q.isEmpty()) {
			p=q.poll();
			System.out.print(p+" ");
			
			
			for(int i=1;i<=N;i++) {
				if(arr[p][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true; //if false => add => true (다시는 방문 안하게) 
				}
			}
		}
			
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int V=scan.nextInt();
		
		//간선 연결된 인접행렬을 만듦 
		int [][]arr=new int [N+1][N+1];
		for(int i=0;i<M;i++) {
			int v=scan.nextInt();
			int w=scan.nextInt();
			
			arr[v][w]=1;
			arr[w][v]=1;
		}
		boolean visited[]=new boolean[arr.length];//방문여부 확인 
		dfs(arr,visited,V);
		System.out.println();
		bfs(arr,V);
		
	}
}

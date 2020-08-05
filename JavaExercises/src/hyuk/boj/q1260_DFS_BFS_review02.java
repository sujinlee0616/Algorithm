package hyuk.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1260_DFS_BFS_review02 {
	
	private static int N,M,V;
	private static List<Integer>[] arr;
	private static int[] visited;
	
	public static void main(String[] args) {
		new q1260_DFS_BFS_review02().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		V = scn.nextInt();
		arr =  new List[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		//정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		//dfs
		visited = new int[N+1];
		dfs(V);
		System.out.println();
		visited = new int[N+1];
		bfs();
		
		scn.close();
	}
	private void dfs(int node) {
		
		if(node != V) {
			System.out.print(" ");
		}
		visited[node] = 1;
		System.out.print(node);
		
		List<Integer> childs = arr[node];
		int len = childs.size();
		for(int i = 0; i < len; i++) {
			int child = childs.get(i);
			if(visited[child] == 1) continue;
			dfs(child);
		}
	}
	private void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(V);
		visited[V] = 1;
		while(que.size() != 0) {
			int node = que.poll();
			if(node != V) {
				System.out.print(" ");
			}
			System.out.print(node);
			List<Integer> childs = arr[node];
			int len = childs.size();
			for(int i = 0; i < len; i++) {
				int child = childs.get(i);
				if(visited[child] == 1) continue;
				visited[child] = 1;
				que.offer(child);
			}
		}
	}
}

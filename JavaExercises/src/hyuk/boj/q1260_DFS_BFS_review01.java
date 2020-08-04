package hyuk.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1260_DFS_BFS_review01 {
	public static void main(String[] args) {
		new q1260_DFS_BFS_review01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		int V = scn.nextInt();
		
		List<Integer>[] input = new List[N+1];
		for(int i = 1; i <= N; i++) {
			input[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			int from = scn.nextInt();
			int to = scn.nextInt();
			input[from].add(to);
			input[to].add(from);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(input[i]);
		}
		
		int[] visited = new int[N+1];
		dfs(N,M,input,visited,V);
		System.out.println();
		visited = new int[N+1];
		bfs(N,M,input,visited,V);
		scn.close();
	}
	private void dfs(int N, int M, List[] input, int[] visited,int v) {
		System.out.print(v + " ");
		visited[v] = 1;
		List<Integer> childs = input[v];
		int len = childs.size();
		for(int i = 0; i < len; i++) {
			int child = childs.get(i);
			if(visited[child] == 1) continue;
			visited[child] = 1;
			dfs(N,M,input,visited,child);
		}
	}
	private void bfs(int N, int M, List[] input, int[] visited, int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(v);
		visited[v] = 1;
		while(que.size() != 0) {
			int node = que.poll();
			System.out.print(node + " ");
			List<Integer> childs = input[node];
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

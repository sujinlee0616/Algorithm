package hyuk.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1260_DFS_BFS {
	
	private static int[] visited;
	
	public static void main(String[] args) {
		new q1260_DFS_BFS().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		int V = scn.nextInt();
		List<Integer>[] nodes = new List[N+1];
		for(int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			nodes[a].add(b);
			nodes[b].add(a);
		}
		for(int i = 1; i <= N; i++) {
			Collections.sort(nodes[i]);
		}
		visited = new int[N+1];
		dfs(nodes, V);
		System.out.println();
		visited = new int[N+1];
		bfs(nodes, V);
		
		scn.close();
	}
	private void dfs(List<Integer>[] list, int pos) {
		System.out.print(pos + " ");
		visited[pos] = 1;
		List<Integer> childs = list[pos];
		int len = childs.size();
		for(int i = 0; i < len; i++) {
			int child = childs.get(i);
			if(visited[child] == 1) continue;
			dfs(list, child);
		}
	}
	private void bfs(List<Integer>[] list, int pos) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(pos);
		visited[pos] = 1;
		while(que.size() != 0) {
			int node = que.poll();
			System.out.print(node + " ");
			List<Integer> childs = list[node];
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

package hyuk.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class q1260_DFS_BFS {
	
	private boolean[] isSelected;
	
	public static void main(String[] args) {
		new q1260_DFS_BFS().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N,M,S;
		N = scn.nextInt();
		M = scn.nextInt();
		S = scn.nextInt();
		List<Integer>[] graph = new List[N+1]; // 0번 인덱스는 사용하지 않는다
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		// 정렬
		for(int i = 1; i <= N; i++) {
			sort(graph[i]);
		}
		// dfs 탐색 
		isSelected = new boolean[N+1];
		dfs(graph, S);
		System.out.println();
		isSelected = new boolean[N+1];
		bfs(graph, S);
		scn.close();
	}
	//오름차순
	private void sort(List<Integer> arr) {
		int min;
		for(int i = 0; i < arr.size()-1; i++) {
			min = i;
			for(int j = i+1; j < arr.size(); j++) {
				if(arr.get(min) > arr.get(j)) {
					min = j;
				}
			}
			int tmp = arr.get(min);
			arr.set(min, arr.get(i));
			arr.set(i, tmp);
		}
	}
	private void dfs(List<Integer>[] graph, int pos) {
		System.out.print(pos + " ");
		
		isSelected[pos] = true;
		
		List<Integer> childs = graph[pos];
		int len =childs.size();
		for(int i = 0; i < len; i++) {
			int child = childs.get(i);
			if(isSelected[child]) continue;
			dfs(graph,child);
		}
		isSelected[pos] = false;
	}
	private void bfs(List<Integer>[] graph, int pos) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(pos);
		isSelected[pos] = true;
		List<Integer> childs;
		int len;
		int child;
		
		while(que.size() != 0) {
			int node = que.poll();
			System.out.print(node + " ");
			childs = graph[node];
			len = childs.size(); 
			for(int i = 0; i < len; i++) {
				child = childs.get(i);
				if(isSelected[child]) continue;
				isSelected[child] = true;
				que.offer(child);
			}
		}
	}
}

package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q11724_ConnectedComponent {
	
	private static int N,M;
	private static int[] visited;
	private static List<Integer>[] arr;
	private static int ans;
	
	public static void main(String[] args) {
		new q11724_ConnectedComponent().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		visited = new int[N+1];
		arr = new List[N+1];
		
		for(int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
		scn.close();
	}
	private void dfs(int node) {
		visited[node] = 1;
		List<Integer> childs = arr[node];
		int len = childs.size();
		
		for(int i = 0; i < len; i++) {
			int child = childs.get(i);
			if(visited[child] == 1) continue;
			dfs(child);
		}
	}
}

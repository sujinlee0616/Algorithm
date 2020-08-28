package hyuk.boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1325_hacking {
	static ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[10001];
	static boolean[] visited = new boolean[10001];
	static int[] ans = new int[10001];
	static int cnt = 0;
	static Queue<Integer> que = new LinkedList<Integer>();

	public static void main(String[] args) {
		new q1325_hacking().solve();
	}

	private void solve() {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1].add(v2);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[10001];
			que.offer(i);
			visited[i] = true;
			bfs(i);
		}

		for (int i = 1; i <= n; i++) {
			if (max < ans[i]) {
				max = ans[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if (max == ans[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb.toString());
	}

	public static void bfs(int v) {

		while (que.size() != 0) {
			int node = que.poll();
			for (int vv : a[node]) {
				if (!visited[vv]) {
					visited[vv] = true;
					ans[vv]++;
					que.offer(vv);
				}
			}
		}
	}
}
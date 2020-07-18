package hyuk.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1949_NiceTown {

	private static int[] visited = new int[10010];
	private static List<Integer> town[] = new ArrayList[10010];
	private static int res;
	private static int[] count;
	private static int[][] dynamic;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			count[i] = scn.nextInt();
		}
		for (int i = 0; i <= N; i++) {
			town[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			town[a].add(b);
			town[b].add(a);
		}
		dynamic = new int[N+1][2];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < 2; j++) {
				dynamic[i][j] = -1;
			}
		}
		visitTown(1, 0);
		visited[1] = 1;
		visitTown(1, 1);

		System.out.println(res);
	}

	public static int visitTown(int node, int flag) {
		int funcAns = 0;
		//System.out.println("size : " + town[node].size());
		visited[node] = 1;
		for (int i = 0; i < town[node].size(); i++) {
			if (visited[town[node].get(i)] == 0) {
				if (flag == 1) {
					// res = max(res, count[node] + visitTown(town[node].get(i), 0));
					if(dynamic[town[node].get(i)][0] == -1) {
						funcAns += visitTown(town[node].get(i), 0);
					} else {
						funcAns += dynamic[town[node].get(i)][0];
					}
				} else {
					//System.out.println("town[node].get(i) : " + town[node].get(i));
					int tmp = 0;
					if(dynamic[town[node].get(i)][0] == -1) {
						tmp = visitTown(town[node].get(i), 0);
					} else {
						tmp = dynamic[town[node].get(i)][0];
					}
					int tmp2 = 0;
					if(dynamic[town[node].get(i)][1] == -1) {
						tmp2 = visitTown(town[node].get(i), 1);
					} else {
						tmp2 = dynamic[town[node].get(i)][1];
					}
					funcAns += max(tmp, tmp2);
				}
			}
		}
		if (flag == 1) {
			funcAns += count[node];
		}
		res = max(res, funcAns);
		
		visited[node] = 0;
		dynamic[node][flag] = funcAns;
		return funcAns;
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}
}

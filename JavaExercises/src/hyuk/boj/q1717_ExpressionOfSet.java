package hyuk.boj;

import java.util.Scanner;

public class q1717_ExpressionOfSet {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		DisjointSet set = new DisjointSet(N);
			
		for(int i = 0; i < M; i++) {
			int op = scn.nextInt();
			int a = scn.nextInt();
			int b = scn.nextInt();
			switch (op) {
			case 0:
				set.union(a, b);
				break;
			case 1:
				if (set.find(a) == set.find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				break;
			}
		}
	}
	
}

class DisjointSet {
public int[] parent, rank;
	
	public DisjointSet(int N) {
		N = N+1;
		parent = new int[N];
		rank = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public int find(int target) {
		if(target == parent[target]) {
			return target;
		}
		return parent[target] = find(parent[target]);
	}
	
	public void union(int a, int b) {
		a = find(a); b = find(b);
		
		if(a == b) return;
		
		if(rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
		if(rank[a] == rank[b]) {
			rank[b]++;
		}
	}
}
package datastructure;

public class DisjointSet_Review01 {
	
	private final static int SIZE = 10;
	
	public static void main(String[] args) {
		MyDisjointSet_Review01 ds = new MyDisjointSet_Review01(SIZE);
		//1. 모든 부모노드 출력해보기
		print(ds);
		//2. 트리 만들어보기 
		ds.union(1, 2);
		ds.union(3, 4);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(8, 6);
		ds.union(9, 8);
		ds.union(10, 8);
		//3. 모든 부모도느 출력해보기
		print(ds);
		//4. 큰거 합쳐보기
		ds.union(9, 3);
		print(ds);
		//5. 나머지 합쳐보기
		ds.union(1, 10);
		print(ds);
		//6. 성공 ^^ :D
	}
	private static void print(MyDisjointSet_Review01 ds) {
		for(int i = 0; i < SIZE; i++) {
			System.out.print(ds.find(i+1) + " ");
		}
		System.out.println();
	}
}

class MyDisjointSet_Review01 {
	public int[] parent;
	public int[] rank;
	
	public MyDisjointSet_Review01(int size) {
		parent = new int[size+1];
		rank = new int[size+1];
		for(int i = 1; i <= size; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	public int find(int node) {
		int u = parent[node];
		if(u == node) return u;
		
		parent[node] = find(parent[node]);
		return parent[node];
	}
	public void union(int u, int v) {
		//1. find
		u = find(u);
		v = find(v);
		if(u == v) return;
		if(rank[u] > rank[v]) {
			parent[v] = u;
		}else if(rank[u] < rank[v]) {
			parent[u] = v;
		}else {
			parent[v] = u;
			rank[u]++;
		}
	}
}
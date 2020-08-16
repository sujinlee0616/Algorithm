package etc;

import java.util.Scanner;

// 집합 S={1,2,3,....,N}의 부분집합을 모두 출력하고, 맨 마지막으로는 집합 S의 부분집합의 개수를 출력하라. 
public class subset {
	
	static int[] visited, list;
	static int elementNum;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		elementNum = 7;
		visited = new int[9]; // n과 m의 최대범위
		list = new int [9]; // (1 ≤ M ≤ N ≤ 8)
		
		System.out.println("{}");
		cnt=1;
		dfs(0,0);
		System.out.println(cnt);
	}
	
	static void dfs(int start, int depth) {
		if(depth <= elementNum && depth!=0) {
			System.out.print("{");
			for(int i=0; i<depth-1; i++)
				System.out.print(list[i]+",");
			System.out.println(list[depth-1]+"}");
		}	
		for(int i=start+1; i<=elementNum; i++) {
			if(visited[i] == 1)  
				continue;
			visited[i] = 1; // 방문처리 
			list[depth] = i;
			dfs(i, depth+1); 
			visited[i] = 0; // 방문여부 초기화 
			cnt++;
		}
	}
}

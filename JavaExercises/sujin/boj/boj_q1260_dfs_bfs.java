package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
 * Q. 15649와 1260(그래프)의 DFS는 왜 구현방식이 조금 다른가? 
 - 1260에서는 DFS 구현 시에 false로 바꿔주는 처리를 해주지 않았음. 이유는 아래와 같음. 
 - 트리는 싸이클이 없어서 false로 바꿔줘도 다시 그 노드를 탐색하지 않음. 
 - 하지만, 그래프는 싸이클이 있기 때문에 false로 바꿔주면 다른 노드의 경로로 다시 탐색이됨. 
    ==> 그래프 같은 경우 정확히 한번씩 순회하기 위해서는 false로 바꿔주면 안된다
 */

public class boj_q1260_dfs_bfs {
	
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); // 정점의 개수
		int m=sc.nextInt(); // 간선의 개수 
		int start=sc.nextInt(); // 시작점
		
		// 그래프 입력받음
		// 1) 정점의 수대로 list를 만든다 - 
		list = new ArrayList[n+1]; // 직관적으로 이해하기 쉽게 1,2,...n 으로 하기 위해서 n+1 크기로 만들어줬음 
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<Integer>(); // i번째 점에 있는 연결점들
		}
		// 2) i번째 점에 있는 연결점들 리스트를 채운다. 
		for(int i=0;i<m;i++) { // 간선의 개수만큼 입력받음 
			int u=sc.nextInt(); // u: 간선의 점1
			int v=sc.nextInt(); // v: 간선의 점2
			list[u].add(v); // 점u의 연결점 리스트에 v 추가
			list[v].add(u); // 점v의 연결점 리스트에 u를 추가 
		}
		// ==> 이렇게하면 그래프의 모양을 다 저장했음. 
		
		// 제대로 들어갔는지 확인 
		//for(int i=1;i<=n;i++) 
			//System.out.println("list["+i+"]"+list[i]);		
		
		// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
		for(int i=1;i<=n;i++)
			Collections.sort(list[i]);
		
		visited = new boolean[n+1]; // visited 다른 메소드에서도 쓸거니까 static으로 빼놓자 
		dfs(start);
		System.out.println();
		
		visited = new boolean[n+1];
		bfs(start);
		System.out.println();
	}
	
	
	static void dfs(int start) {
		if(visited[start]) {  // 이미 방문했으면 return 
			return;
		}
		// 이전에 방문한 적 없다면 
		visited[start]=true;
		System.out.print(start+" ");
		for(int y:list[start]) { // x점의 연결점 리스트에 있는 y들에 대해서 
			// list를 이 메소드에서 써야하니까 list를 static으로 만들어놓자  
			if(!visited[y]) { // y점을 방문한적 없다면 
				dfs(y); // dfs해라  - 재귀로..... 계속계속... 탐색... 
			} 
				
		}
	}
	
	static void bfs(int start) {
		// Queue로 구현... 
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) { // queue에 데이터가 있는동안 while문 돌림 
        	int x=queue.poll(); // 1. 큐에서 하나 꺼내고 
        	System.out.print(x+" "); // 2. 꺼낸 애는 출력하고 
        	// 3. 자식 node를 queue에 넣는다. (단, 기존에 이 자식 node를 방문한적이 없어야함) 
        	for(int y:list[x]) { // 점 x의 연결점들에서 
        		if(!visited[y]) { // 기존에 방문한적 없는 노드라면 
        			visited[y]=true; // 방문여부 true로 바꿔주고 
        			queue.add(y); // queue에 넣어준다. 
        		}
        	}
        }
	}

	
	
}









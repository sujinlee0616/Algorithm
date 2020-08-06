package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//배경지식) 
//1. ArrayList: https://lktprogrammer.tistory.com/113
//2. ArrayList 배열
//- int[] arr=new int[n]; 
// ===> int 배열. arr 배열의 원소는 int로 구성되어 있다. 
//      ex) arr[0]=1 (int값) 
// ArrayList<Integer>[] list = new ArrayList[n+1]; 
// ===> ArrayList<Integer> 배열. list의 원소는 ArrayList<Integer>로 구성되어 있다. 
//      ex) list[0] : 1,2,3 int 값이 들어있는 ArrayList           
// ===> list[i]=new ArrayList<Integer>(); 

// 질문) ArrayList<Integer>[] list=new ArrayList<Integer>[n+1]; 는 왜 안되는가? 

public class boj_q1260_dfs_bfs2 {
	
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
		// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); // 정점의 개수 
		int m=sc.nextInt(); // 간선의 개수 
		int start=sc.nextInt(); // 시작점 
		
		list = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<Integer>(); // 정점의 개수만큼 list 생성. list[i]: 점 i의 연결점들의 리스트. 
		}
		for(int i=0;i<m;i++) {
			int v=sc.nextInt();
			int u=sc.nextInt();
			list[v].add(u);
			list[u].add(v);
		}
		
		// test 
		//for(int i=1;i<=n;i++) 
		//	System.out.println("list["+i+"]="+list[i]);
		//System.out.println("================");
		
		// "단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문" 
		// ==> list[i]를 오름차순으로 정렬. ==> 숫자가 작은 연결점이 앞에 위치 ==> 더 먼저 방문. 
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
		}
		
		// test 
		//for(int i=1;i<=n;i++) 
		//	System.out.println("list["+i+"]="+list[i]);
		
		visited=new boolean[n+1];
		dfs(start);
		System.out.println();
		
		visited=new boolean[n+1];
		bfs(start);
		
	}
	
	static void dfs(int start) {
		// DFS(Depth First Search) ==> Stack을 이용해서 구현. 
		if(visited[start]==true) // 이미 방문했으면 return 
			return;
		
		//기존에 방문한 적 없으면
		visited[start]=true;
		System.out.print(start+" ");
		
		for(int y:list[start]) {
			// y점을 방문한 적이 없다면 
			if(visited[y]!=true)
				dfs(y);
		}
		
	}
	
	static void bfs(int start) {
		// BFS(Breadth First Search) ==> Queue를 이용해서 구현. 
		Queue<Integer> que=new LinkedList<Integer>();
		// 질문) Queue를 생성할 때는 왜 LinkedList로 생성할까?? 
		
		// 1. Queue에 start 넣는다. 
		que.add(start);
		visited[start]=true;
		
		while(!que.isEmpty()) {
			int x=que.poll();
			// 2. 젤 front에 있는 놈 꺼내고 출력한다.
			System.out.print(x+" ");
			// 3. 자식 Node를 queue에 넣는다. (단, 이전에 들어간 적 없어야함) 
			for(int y:list[x]) {
				if(visited[y]!=true) {// 이전에 방문한 적 없다면 
					visited[y]=true; 
					que.add(y);
				}
			}
		}
	}

}









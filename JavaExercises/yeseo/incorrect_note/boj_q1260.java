package incorrect_note;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj_q1260 {
/*
DFS      /    BFS
| :스택     -  : 큐 


재귀함수로 호출하는 건 일단 구현 하고 하려고... 


N (정점)
M (간선) 
V (정점 번호 = 탐색 시작 번호)  
-> 정점번호부터 방문된 점을 순서대로 출력 


주의)
ArrayList로 연산하는게 속도 측면에서 효율적이라는 것 
false로 초기화하면 반복해서 탐색을 하게 된다 ( 비효율적 이라는 것 ) 
 */

	
	
	
	
	public static void dfs_stack(int [][]a, int v) {
		
		Stack<Integer> stack=new Stack<>();
		int n=a.length-1;
		
		boolean []visited=new boolean[a.length];
		boolean flag=true;
		
		stack.push(v);  //정점을 다 스택에 담음 
		
		visited[v]=true; //isVisited= true 정점부터 돌거니까 
		System.out.print(v+" "); //  정점을 먼저 출력하고   첫번째방문 하는건 정점이니까 
		
		while(!stack.isEmpty()) {
			int vv=stack.peek();  // 젤 위에 있는 (v)를 기준으로 =top 
			
			//flag=false; //다음으로 넘어가기전에 false로 초기화 해주고 visited // 
			
			for(int i=1;i<=n;i++) {
				if(a[vv][i]==1&& !visited[i]) {  // 아직 방문도 안했고 간선이 연결되어있으면 스택에 넣어라 
					stack.push(i);
					System.out.print(i+" ");
					
					visited [i]=true;
			//		flag=true;
					break;
					
					//나중에 재귀로 바꾸는 것과 같은 원리 
				}
			}
			
			
			if(!flag) //false 
				stack.pop();
			
		}
	}

	
	
	//재귀
	public static void dfs(int [][]arr,boolean c[],int p) {
	 int n=arr.length-1;
	 c[p]=true; 
	 System.out.print(p+" ");

	 for(int i=1;i<=n;i++) {
		 if(arr[p][i]==1 && !c[i]) //true 
			 dfs(arr,c,i);
			//top에 있는 정점을 기준으로 간선이 연결되어있고 아직 방문하지 않은 정점을 push, 반대는 pop
		 //c[v]=false로 바꿀 필요 x => 모든 경우의 수를 구하고 경로탐색만 하는 경우는 false로 초기화 
	 }
	}
	
	
	public static void bfs(int [][]a, int v) {
		Queue<Integer> q=new LinkedList<>();
		
		int n=a.length-1;
		boolean visited[]=new boolean[a.length];
		
		q.add(v);
		visited[v]=true;
		
		while(!q.isEmpty()) {
			v=q.poll();
			System.out.print(v+" ");
			
			for(int i=1;i<=n;i++) {
				if(a[v][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
					//false로 초기화 안해. 하면 다음에 또 탐색.
					//front인 정점을 기준으로 연결된 간선이 있으면 방문, 조건에 맞으면 큐에 넣고 
					//DFS의 경우 break를 걸어줌 ( BFS는 모두 큐에 넣었으니까 너비 기준으로 탐색만 하면 됨) 
					//모든 경우를탐색 할 수 있고, 최단 경로로 탐색한다고 할 수 있음 
				}
			}
		}

	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt(); //4
		int M=scan.nextInt(); //5 간선 
		int V=scan.nextInt(); //1 시작하는 지점? 
		
		int [][]a=new int[N+1][N+1]; //인접행렬
		for(int i=0;i<M;i++) {
			int v1=scan.nextInt(); //점 1
			int v2=scan.nextInt(); // 점2
			
			a[v1][v2]=1;   // 서로 연결 되어있음  v1= 1-> v2= 2 ==1  2->1 둘 다 
			a[v2][v1]=1;
		}
		
		
		boolean []c=new boolean[a.length];
		dfs(a, c ,V);
		dfs_stack(a,V);
		System.out.println();
		bfs(a,V);
			
	}
}

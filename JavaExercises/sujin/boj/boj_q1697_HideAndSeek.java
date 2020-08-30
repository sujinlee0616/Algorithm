package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_q1697_HideAndSeek {

	static int N, K; 
	static int visit[] = new int[100001]; 
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		K = sc.nextInt();  
		bfs(); 
	} 
	
	public static void bfs() { 
		
		Queue<Integer> q = new LinkedList<Integer>(); 
		q.add(N); 
		visit[N] = 1; // 방문처리 
		
		while(!q.isEmpty()) { 
			N = q.poll(); 
			if (N == K) // 다 돌았으면 break 
				break; 
			
			if(N+1 <= 100000 && visit[N+1] == 0) { 
				q.add(N+1); 
				visit[N+1] = visit[N]+1; 
			} 
			
			if(N-1 >= 0 && visit[N-1] == 0) { 
				q.add(N-1); 
				visit[N-1] = visit[N]+1; 
			} 
			
			if(N*2 <= 100000 && visit[N*2] == 0) { 
				q.add(N*2); 
				visit[N*2] = visit[N]+1; 
			}
			
		} 
		
		System.out.println(visit[K]-1); // 0이 아닌 1에서 시작 해서 -1해주기 
	
	}
	
}

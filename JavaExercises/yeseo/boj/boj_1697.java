package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1697 {
//숨바꼭질 
//DFS/BFS
	

	static int N,K;
	static boolean visited[]=new boolean [100001]; //1~100000
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		K=scan.nextInt();
		//BFS 구현 
		System.out.println(bfs(N,K));
		scan.close();
	}
	//움직이는 경우의 수가 오직 세개 => visit만 점검하면 되는 문제 
	public static int bfs(int N,int K) {
		int time=0;
		Queue<Integer> q=new LinkedList<>();
		q.add(N); //수빈 
		
		while(true) {
			int size=q.size();
			
			for(int i=0;i<size;i++) {
				N=q.peek();
				q.poll();
				
				//조건에 부합하면
				if(N==K) return time;
				
				//x-1 
				if(N>0 && visited[N-1]==false) {
					q.add(N-1);
					visited[N-1]=true;
				}
				
				//x+1
				if(N<100000 && visited[N+1]==false) {
					q.add(N+1);
					visited[N+1]=true;
				}
				
				//2*x 
				if(N*2<=100000 && visited[N*2]==false) {
					q.add(N*2);
					visited[N*2]=true;
				}	
			}
			time++;
		}
	}
}

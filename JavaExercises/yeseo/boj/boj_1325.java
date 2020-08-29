package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1325 {
//효율적 해킹 
	//dfs 	
	// 시간초과 !! (BufferdR/W로변경 필요) 
	static int N,M;
	static int count[];
	static int res[]=new int [10001];
	//** List자체를 배열로 담음 
	static ArrayList<Integer> arr[];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
	
		//******************
		arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
			arr[i]=new ArrayList();
		
		for(int i=0;i<M;i++) {
			int s=scan.nextInt();
			int e=scan.nextInt();
			///////////////
			arr[s].add(e);
		}
		
		// (1)
		count=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			visited=new boolean[N+1];
			dfs(i);
		}
	
		//(2)	
		int max=0;
		for(int i=1;i<=N;i++) {
			if(count[i]>max) max=count[i];
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=N;i++)
			if(count[i]==max) 
				System.out.print(i+" ");
	}
	
	public static void dfs(int v) {

		visited[v]=true;
		
		for(int a:arr[v]) {
			if(!visited[a]) {
				count[a]++;
				dfs(a);
			}
		}
	}
	
}

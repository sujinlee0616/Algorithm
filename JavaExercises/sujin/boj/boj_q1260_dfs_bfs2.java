package boj;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
		// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); // 정점의 개수 
		int m=sc.nextInt(); // 간선의 개수 
		int start=sc.nextInt(); // 시작점 
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for(int i=0;i<m;i++) {
			list[i]=new ArrayList<Integer>();
			
		}
		
	}

}

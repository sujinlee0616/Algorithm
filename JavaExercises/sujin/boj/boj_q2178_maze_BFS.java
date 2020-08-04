package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 최단경로 구하. BFS 문제. 
// N, M(2 ≤ N, M ≤ 100) ==> 숫자 작으니까 Scanner 써도 될듯. 

// 참고자료) BFS 설명 
// https://velog.io/@skyepodium/BFS%EB%8A%94-%EB%82%AF%EC%84%A4%EC%96%B4%EC%84%9C

public class boj_q2178_maze_BFS {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int[][] arr=new int[n][m];
		String[] s=new String[n];
		
		for(int i=0;i<n;i++)
			s[i]=sc.next();
		
		// arr배열에다가 입력값 넣었음 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = s[i].charAt(j)-'0';
				//System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+" ");
			}
			//System.out.println();
		}
		
		bfs(0,0);
	}
	
	static int bfs(int x,int y) {
		int res=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		
		return res;
	}
	

}

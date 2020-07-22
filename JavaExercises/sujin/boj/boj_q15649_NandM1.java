package boj;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 자력으로 못 풀었음 ㅠㅠ 
// 관련 자료) 
// 1.Youtube 순열 설명 - https://www.youtube.com/watch?v=MjW10t9ppok
// 2.코드출처 - https://fbtmdwhd33.tistory.com/36
public class boj_q15649_NandM1 {
	
	static int m,n; // N과 M을 입력받는다.
	static int list[],check[]; // 숫자의 방문여부를 체크 할 방문배열과 결과를 저장 할 배열을 선언
	
	static void dfs(int cnt) { // DFS메소드, 반복횟수를 인자로 받는다. 초기 0부터 시작
			
		if(cnt == m) { // 0부터 M번까지 반복했으면 하나의 처리가 완성
        			   // 개인적인 생각으로는 이부분이 백트래킹에 해당한다고 생각한다.
                       // M보다 큰 횟수는 고려하지 않고 배제한다.
			for(int i=0;i<m;i++) { // 현재 결과배열을 출력
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return; // DFS 종료 
		}
		
		for(int i =1;i<=n;i++) { // 수의 범위는 1부터 N까지이다.
			
			if(check[i]==1) continue; // 이미 방문한 배열이면 건너뛴다.
			check[i]=1; // 방문하지 않았다면, 방문처리 후
			list[cnt]=i; // 현재 반복횟수에 해당하는 배열에 i값을 넣는다.
			dfs(cnt+1); // 반복횟수를 증가시킨다.
			check[i]=0; // dfs가 종료 후에는 다시 방문여부를 0으로 초기화한다.
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		check = new int[9]; // n과 m의 최대범위
		list = new int [9];
		dfs(0);
	}
	
}


// N=4, M=4일 때 
/* public static void main(String[] args) {
	
	boolean[] visited = new boolean[4];
	
	for(int i=0; i<4; i++) {
		if(visited[i] == true) continue;
		else { 
			visited[i] = true; 
			for(int j=0; j<4; j++) {
				if(visited[j] == true) continue;
				else {
					visited[j] = true;
					for(int k=0; k<4; k++) {
						if(visited[k] == true) continue;
						else {
							visited[k] = true;
							for(int l=0; l<4; l++) {
								if(visited[l] == true) continue;
								else {
									visited[l] = true;
									System.out.println((i+1)+" "+(j+1)+" "+(k+1)+" "+(l+1));
								}
								visited[l] = false;
							}
						}
						visited[k]=false;
					}
				}
				visited[j]=false;
			}
		}
		visited[i]=false;
	}
}
*/

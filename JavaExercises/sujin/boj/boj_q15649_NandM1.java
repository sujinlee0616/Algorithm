package boj;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 자력으로 못 풀었음 ㅠㅠ 
// 관련 자료) 
// 1.Youtube 순열 설명 - https://www.youtube.com/watch?v=MjW10t9ppok
// 2.코드출처 - https://fbtmdwhd33.tistory.com/36

// idea) 
// 1. 순열 만들기 
// {a,b,c,d}가 있다면 이것들을 순열로 만드는 방법은 
// 1) 맨 앞에 a 고정시키고 + {b,c,d} 순열
// 2) 맨 앞에 b 고정시키고 + {a,c,d} 순열 
// 3) 맨 앞에 c 고정시키고 + {a,b,d} 순열
// 4) 맨 앞에 d 고정시키고 + {a,b,c} 순열
// ===> 재귀(recursion) 
// 2. 방문 여부를 체크하는 visited[i] 배열을 만들어서 이미 넣은 원소는 또 넣지 않는다. 
//  - visited[i]:i가 list에 들어있는지를 체크하는 배열 
//  - list[i]: 결과배열 

// background 지식) 
// 1. 클래스내의 어떠한 메소드가 실행되고 해당 메소드 실행에 따라 나온 값을 호출한 곳에서 돌려받고자 할때
// 2. 해당 메소드 실행중 특정 조건에 따라 해당 메소드의 진행을 멈추고 빠져나올때

public class boj_q15649_NandM1 {
	
	static int m,n; // N과 M을 입력받는다.
	static int list[],visited[]; // 숫자의 방문여부를 체크 할 방문배열과 결과를 저장 할 배열을 선언
	
	static void dfs(int k) { // DFS메소드. 초기 0부터 시작
		//System.out.println("=============== dfs("+k+")===============");
			
		if(k == m) { // 0부터 M번까지 수행했으면 모든 처리가 완료된거임 ==> 결과배열 출력 
			for(int i=0;i<m;i++) { 
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return; // DFS 종료 
		}
		
		// k가 m보다 작을 때, dfs(k) 
		for(int i=1;i<=n;i++) { // 수의 범위는 1부터 N까지이다.
			// System.out.println("=============== k="+k+", i="+i+"===============");
			if(visited[i]==1) {
				System.out.println("visited["+i+"]==1 ==> continue");
				continue; // 1. i가 이미 list에 들어가있으면 건너뛴다 
			}
			// 2. i가 list에 아직 없다면 (들어가있지 않다면) 
			visited[i]=1; // 1) 방문처리 하고 
			System.out.println("visited["+i+"]=1;");
			list[k]=i; // 2) 결과배열의 k번째 원소에다가 집어넣는다 ==> 결과배열의 k번째까지 완성되었음 
			System.out.println("list["+k+"]="+i);
			dfs(k+1); // 3) k+1번째 결과배열을 정하기 위해 dfs(k+1)을 수행 
			System.out.println("======== dfs("+(k+1)+") 호출 ========");
			//visited[i]=0; // 4) 방문처리를 해제한다. <== why? 
			System.out.println("visited["+i+"]=0;");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		visited = new int[9]; // n과 m의 최대범위
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

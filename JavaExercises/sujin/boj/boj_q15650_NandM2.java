package boj;

import java.util.Scanner;

//자력으로 못 풀었음 ㅠㅠ 
//관련 자료) 
//1.Youtube 순열 설명 - https://www.youtube.com/watch?v=MjW10t9ppok
//2.코드출처 - https://fbtmdwhd33.tistory.com/36

public class boj_q15650_NandM2 {
	
	static int m,n; // M과 N변수
	static int list[],check[]; // 결과를 저장 할 list배열과 방문 여부를 체크 할 방문 배열
	
	static void dfs(int idx,int cnt) { // DFS메소드, 반복문의 시작부분을 변경해줘야 하므로 인자를 하나 더 추가한다.
  	
		if(cnt == m) { // 기존의 종료조건 이었던 수열의 끝에 도달하면 종료하는 부분은 동일하다.
			for(int i=0;i<m;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i =idx+1;i<=n;i++) { // 반복문의 시작 부분을 변경해줘야 한다.
        							 // 초기에 시작할 때는 두번 째 자리는 1부터 N까지 탐색 
                                     // 2로 시작할 때는 두번 째 자리는 3부터 N까지 탐색
                                     // 3으로 시작할 때는 두번 째 자리는 4부터 N까지 탐색.. 반복이다.
			if(check[i]==1) continue; // 동일하다. 이미 방문한 경우는 넘긴다.
			check[i]=1; // 방문하지 않은 경우는 방문 처리 후
			list[cnt]=i; // cnt값의 자리는 i로 즉, 초기에는 0번인덱스(첫 번째 자리)는 1이다.
			dfs(i,cnt+1); // 현재의 i값보다 큰 경우를 탐색해야 하므로 i를 전달 후 반복문 시작부분에서 +1 해주는 것
			check[i]=0; // 모두 찾은 후에는 다시 방문 여부를 초기화
	
		}

	}
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		
		check = new int[9];
		list = new int [9];
		dfs(0,0); // 초기의 시작은 1부터 N까지 탐색해야 하므로 0을 전달
	}
}

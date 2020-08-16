package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// [중복조합] 
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// 고른 수열은 비내림차순이어야 한다.
public class boj_q15652_NandM4 {
	
	static int N;
	static int M;
	static int[] visited;
	static int[] list;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.close();
		
		visited = new int[9]; // n과 m의 최대범위
		list = new int [9]; // (1 ≤ M ≤ N ≤ 8)
		dfs(1,0);
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int idx, int cnt) throws IOException {
		if(cnt == M) {
			for(int i=0; i<M; i++)
				bw.write(String.valueOf(list[i])+" ");
			bw.newLine();
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			//visited[i] = 1; // 방문처리  <== 없어도 됨. 왜냐면 for문에서 안 돔...
			list[cnt] = i;
			dfs(i,cnt+1);
			//visited[i] = 0; // 방문여부 초기화 <== 없어도 됨. 왜냐면 for문에서 안 돔...
		}
	}

}





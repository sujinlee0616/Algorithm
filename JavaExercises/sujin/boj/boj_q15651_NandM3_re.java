package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// [중복순열]
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
public class boj_q15651_NandM3_re {

	static int N,M;
	static int list[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		br.close();
		
		list = new int[9];
		dfs(0);
		
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int depth) throws IOException {
		if(depth == M) {
			for(int i=0; i<M; i++)
				bw.write(String.valueOf(list[i])+" ");
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			list[depth] = i;
			dfs(depth+1);
		}
	}
	
	
}







package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q15651_NAndM_Review01 {
	
	private static int N,M;
	private static int[] arr;
	private static StringBuilder sb;
	
	public static void main(String[] args) {
		try {
			new q15651_NAndM_Review01().service();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void service() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N];
		sb = new StringBuilder();
		
		dfs(0);
		
		System.out.println(sb);
		
		br.close();
	}
	private void dfs(int cnt) {
		if(cnt >= M) {
			appendToBuilder();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[cnt] = i+1;
			dfs(cnt+1);
		}
	}
	private void appendToBuilder() {
		for(int i = 0; i < M; i++) {
			sb.append(arr[i] + " ");
		}
		sb.append("\n");
	}
}

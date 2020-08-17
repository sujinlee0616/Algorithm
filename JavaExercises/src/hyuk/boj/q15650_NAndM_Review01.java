package hyuk.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q15650_NAndM_Review01 {
	
	private static int N,M;
	private static int[] arr;
	private static StringBuilder sb;
	private static int count;
	
	public static void main(String[] args) {
		try {
			new q15650_NAndM_Review01().service();
		} catch (Exception e) {
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
		
		dfs(0,0);
		System.out.println("count : " + count);
		System.out.println(sb);
		
		br.close();
	}
	private void dfs(int cnt, int start) {
//		if(cnt >= M) {
//			appendToBuilder();
//			return;
//		}
		appendToBuilder(cnt);
		count++;
		if(cnt >= M) {
			return;
		}
		
		for(int i = start; i < N; i++) {
			arr[cnt] = i+1;
			dfs(cnt+1, i+1);
		}
	}
	private void appendToBuilder() {
		for(int i = 0; i < M; i++) {
			sb.append(arr[i] + " ");
		}
		sb.append("\n");
	}
	private void appendToBuilder(int c) {
		sb.append("{");
		for(int i = 0; i < c; i++) {
			if(i != 0) {
				sb.append(" ");
			}
			sb.append(arr[i]);
		}
		sb.append("}");
		sb.append("\n");
	}
}

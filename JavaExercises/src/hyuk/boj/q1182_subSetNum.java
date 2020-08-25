package hyuk.boj;

import java.util.Arrays;
import java.util.Scanner;

public class q1182_subSetNum {
	
	private static int ans,C,N;
	private static int[] arr;
	
	public static void main(String[] args) {
		new q1182_subSetNum().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		C = scn.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		
		dfs(0,0,0);
		System.out.println(ans);
		scn.close();
	}
	private void dfs(int depth, int start, int sum) {
		if(sum == C && depth != 0) {
			ans++;
		}
		if(depth >= N) return;
		
		for(int i = start; i < N; i++) {
			dfs(depth + 1, i + 1, sum + arr[i]);
		}
	}
	
}

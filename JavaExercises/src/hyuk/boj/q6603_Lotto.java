package hyuk.boj;

import java.util.Scanner;

public class q6603_Lotto {
	
	private final static int NUM = 6;
	private static int k;
	private static int[] arr, ans;
	private static StringBuilder sb;
	
	public static void main(String[] args) {
		new q6603_Lotto().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			k = scn.nextInt();
			if(k == 0) break;
			arr = new int[k];
			ans = new int[NUM];
			sb = new StringBuilder();
			for(int i = 0; i < k; i++) {
				arr[i] = scn.nextInt();
			}
			
			dfs(0,0);
			System.out.println(sb);
		}
		
		scn.close();
	}
	private void dfs(int depth, int start) {
		if(depth >= NUM) {
			print();
			return;
		}
		for(int i = start; i < k; i++) {
			ans[depth] = arr[i];
			dfs(depth+1, i+1);
		}
	}
	private void print() {
		for(int i = 0; i < NUM; i++) {
			sb.append(ans[i]);
			if(i != NUM-1) {
				sb.append(" ");
			}
		}
		sb.append("\n");
	}
}

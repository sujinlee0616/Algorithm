package hyuk;

import java.util.Scanner;

public class SubSet {
	
	private static int N,count;
	private static int[] arr;
	
	public static void main(String[] args) {
		new SubSet().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr = new int[N];
		
		dfs(0,0);
		System.out.println(count);
		scn.close();
	}
	private void dfs(int depth, int start) {
		print(depth);
		count++;
		if(depth >= N) return;
		
		for(int i = start; i < N; i++) {
			arr[depth] = i+1;
			dfs(depth+1, i+1);
		}
	}
	private void print(int cnt) {
		System.out.print("{");
		for(int i = 0; i < cnt; i++) {
			if(i != 0) {
				System.out.print(" ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("}");
	}
}

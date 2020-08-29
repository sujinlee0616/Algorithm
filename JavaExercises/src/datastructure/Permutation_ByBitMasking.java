package datastructure;

import java.util.Scanner;

public class Permutation_ByBitMasking {
	
	private int N,M;
	private int[] arr,ans;
	
	public static void main(String[] args) {
		new Permutation_ByBitMasking().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		M = scn.nextInt();
		arr = new int[N];
		ans = new int[M];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		permutation(0,0);
		
		scn.close();
	}
	
	private void permutation(int depth, int flag) {
		if(depth >= M) {
			print();
			return;
		}
		for(int i = 0; i < N; i++) {
			if((flag & (1 << i)) != 0) continue;
			ans[depth] = arr[i];
			permutation(depth+1, flag | (1 << i));
		}
	}
	private void print() {
		System.out.println("\n----------");
		for(int i = 0 ; i < M; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println("\n----------");
	}
}

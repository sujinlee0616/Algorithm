package datastructure;

import java.util.Scanner;

public class Permutation_ByBitMasking_Review01 {
	public static void main(String[] args) {
		new Permutation_ByBitMasking_Review01().solution();
	}
	public void solution() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[M];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		permutation(N,M,arr,ans,0,0);
		
		scn.close();
	}
	private void permutation(int N, int M, int[] arr, int[] ans, int depth, int flag) {
		if(depth >= M) {
			print(ans,M);
			return;
		}
		for(int i = 0; i < N; i++) {
			if((flag & (1 << i)) != 0) continue;
			ans[depth] = arr[i];
			permutation(N,M,arr,ans,depth+1,(flag | (1<<i)));
		}
	}
	private void print(int[] ans, int M) {
		System.out.println("------------");
		for(int i = 0; i < M; i++) {
			if(i != 0) System.out.print(" ");
			System.out.print(ans[i]);
		}
		System.out.println("\n------------");
	}
}

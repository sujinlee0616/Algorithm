package hyuk.boj;

import java.util.Scanner;

public class q2798_BlackJack {
	
	private static int value;
	private static int N,M;
	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		value = 0;
		
		blackJack(0, 0, 0);
		System.out.println(value);
	}
	
	private static int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	
	private static void blackJack(int pos, int sum, int count) {
		if(count >= 3) {
			if(sum <= M ) {
				value = max(value, sum);
			}
			return;
		}
		
		for(int i = pos; i < N; i++) {
			blackJack(i+1, sum + arr[i], count+1);
		}
	}
}

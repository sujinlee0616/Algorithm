package hyuk.presentation;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		if(N < 2) {
			System.out.println("FALSE");
			return;
		}
		
		for(int i = 2; i < N; i++) {
			if( N % i == 0) {
				System.out.println("FALSE");
				return;
			}
		}
		System.out.println("TRUE");
	}
}

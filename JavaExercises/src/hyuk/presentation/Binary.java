package hyuk.presentation;

import java.util.Scanner;

public class Binary {
	public static void main(String[] args) {
		int N = 0;
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		getBinary(N);
	}
	
	private static void getBinary(int N) {
		if(N <= 1) {
			printBinary(N);
			return;
		}
		
		getBinary(N / 2);
		printBinary(N % 2);
	}
	
	private static void printBinary(int N) {
		System.out.print(N);
	}
}

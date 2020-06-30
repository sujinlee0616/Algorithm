package hyuk.presentation;

import java.util.Scanner;

public class Mountain {
	public static void main(String[] args) {
		int N = 0;
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		
		getMountain(N);
	}
	
	private static void getMountain(int N) {
		if(N <= 1) {
			printMountain(N);
			return;
		}
		
		getMountain(N-1);
		printMountain(N);
		getMountain(N-1);
	}
	
	private static void printMountain(int N) {
		System.out.print(N);
	}
}

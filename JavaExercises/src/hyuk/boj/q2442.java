package hyuk.boj;

import java.util.Scanner;

public class q2442 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		for(int i = 1; i <= N; i++) {
			for(int j = N-i; j > 0; j--) {
				System.out.print(' ');
			}
			for(int j = 0; j < i*2-1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}

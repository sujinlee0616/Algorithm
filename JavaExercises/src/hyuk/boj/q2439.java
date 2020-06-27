package hyuk.boj;

import java.util.Scanner;

public class q2439 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}

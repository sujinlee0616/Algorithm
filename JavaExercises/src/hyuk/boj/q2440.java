package hyuk.boj;

import java.util.Scanner;

public class q2440 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}

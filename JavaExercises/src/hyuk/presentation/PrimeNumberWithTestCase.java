package hyuk.presentation;

import java.util.Scanner;

public class PrimeNumberWithTestCase {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int Test = scn.nextInt();
		
		for(int t = 0; t < Test; t++) {
			int prime = scn.nextInt();
			boolean ans = isPrimeNumber(prime);
			System.out.println(ans);
		}
	}

	public static boolean isPrimeNumber(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

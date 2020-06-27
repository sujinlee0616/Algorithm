package hyuk.boj;

import java.util.Scanner;

public class q1978 {

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
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] arr = new int[110];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(isPrimeNumber(arr[i])) {
				count++;
			}
		}
		System.out.println(count);
	}
}

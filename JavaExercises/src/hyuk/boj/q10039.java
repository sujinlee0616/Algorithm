package hyuk.boj;

import java.util.Scanner;

public class q10039 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = scn.nextInt();
			if(arr[i] < 40) {
				arr[i] = 40;
			}
		}
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += arr[i];
		}
		System.out.println(sum/5);
	}
}

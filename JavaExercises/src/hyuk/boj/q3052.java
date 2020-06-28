package hyuk.boj;

import java.util.Scanner;

public class q3052 {
	public static void main(String[] args) {
		int[] arr = new int[50];
		int count = 0;
		Scanner scn = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			arr[scn.nextInt()%42]++;
		}
		
		for(int i = 0; i < 42; i++) {
			if(arr[i] != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}

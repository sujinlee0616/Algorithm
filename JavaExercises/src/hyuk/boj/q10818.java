package hyuk.boj;

import java.util.Scanner;

public class q10818 {
	public static void main(String[] args) {
		int min = 1000010;
		int max = -1000010;
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] arr = new int[1000010];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(min + " " + max);
	}
}

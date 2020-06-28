package hyuk.boj;

import java.util.Scanner;

public class q10817 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr= new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = scn.nextInt();
		}
		
		int max;
		int tmp;
		for(int i = 0; i < 2; i++) {
			max = i;
			for(int j = i+1; j < 3; j++) {
				if(arr[max] < arr[j]) {
					max = j;
				}
			}
			
			tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;
		}
		System.out.println(arr[1]);
	}
}

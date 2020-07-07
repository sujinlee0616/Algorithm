package hyuk.boj;

import java.util.Scanner;

public class q1026_Treasure {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] arr = new int[N];
		int[] brr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		for(int i = 0; i < N; i++) {
			brr[i] = scn.nextInt();
		}
		
		sortArr(arr,"");
		sortArr(brr,"DESC");
		int S = 0;
		for(int i = 0; i < N; i++) {
			S += (arr[i] * brr[i]);
		}
		System.out.println(S);
	}
	
	public static void sortArr(int[] arr, String mode) {
		int value = 0;
		
		for(int i = 0; i < arr.length-1; i++) {
			value = i;
			for(int j = i+1; j < arr.length; j++) {
				if(mode.equals("DESC")) {
					if(arr[value] < arr[j]) {
						value = j;
					}
				} else {
					if(arr[value] > arr[j]) {
						value = j;
					}
				}
			}
			int tmp = arr[i];
			arr[i] = arr[value];
			arr[value] = tmp;
		}
	}
}

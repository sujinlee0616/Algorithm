package hyuk.boj;

import java.util.Arrays;
import java.util.Scanner;

public class q1026_Treasure_review01 {
	public static void main(String[] args) {
		new q1026_Treasure_review01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int[] arr = new int[N];
		int[] brr= new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
			
		}
		for(int i = 0; i < N; i++) {
			brr[i] = scn.nextInt();
		}
		sort(arr,0);
		sort(brr,1);
		int res = 0;
		for(int i = 0; i < N; i++) {
			res += arr[i] * brr[i];
		}
		System.out.println(res);
		scn.close();
	}
	
	private void sort(int[] arr, int mode) {
		int target;
		for(int i = 0; i < arr.length-1; i++) {
			target = i;
			for(int j = i+1; j < arr.length; j++) {
				if(mode == 0) {
					if(arr[target] > arr[j]) {
						target = j;
					}
				}else {
					if(arr[target] < arr[j]) {
						target = j;
					}
				}
			}
			int tmp = arr[target];
			arr[target] = arr[i];
			arr[i] = tmp;
		}
	}
}

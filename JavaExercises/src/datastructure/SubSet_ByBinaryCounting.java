package datastructure;

import java.util.Scanner;

public class SubSet_ByBinaryCounting {
	
	private int N;
	private int[] arr;
	
	public static void main(String[] args) {
		new SubSet_ByBinaryCounting().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		
		getSubset();
		
		scn.close();
	}
	private void getSubset() {
		for(int i = 0; i < (1 << N); i++) {
			System.out.print("{");
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println("}");
		}
	}
}

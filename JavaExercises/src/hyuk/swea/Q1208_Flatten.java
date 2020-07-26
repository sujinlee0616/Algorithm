package hyuk.swea;

import java.util.Scanner;

public class Q1208_Flatten {
	
	private static int[] input = new int[110];
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = 10;
		for(int t= 1; t <= test; t++) {
			int res = 0; // 차이
			int count = scn.nextInt();
			for(int i = 0; i < 100; i++) {
				input[i] = scn.nextInt();
			}
			for(int i = 0; i < count; i++) {
				res = diff();
				if(res <= 1) {
					break;
				}
				input[getMaxIndex()]--;
				input[getMinIndex()]++;
			}
			res = diff();
			System.out.println("#" + t + " " + res);
		}
	}
	
	private static int getMaxIndex() {
		int res = input[0];
		int resI = 0;
		for(int i = 1; i < 100; i++) {
			if(res < input[i]) {
				res = input[i];
				resI = i;
			}
		}
		return resI;
	}
	private static int getMinIndex() {
		int res = input[0];
		int resI = 0;
		for(int i = 1; i < 100; i++) {
			if(res > input[i]) {
				res = input[i];
				resI = i;
			}
		}
		return resI;
	}
	private static int diff() {
		int a = input[getMaxIndex()];
		int b = input[getMinIndex()];
		return Math.abs(a-b);
	}
}

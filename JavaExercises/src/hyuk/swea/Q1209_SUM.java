package hyuk.swea;

import java.util.Scanner;

public class Q1209_SUM {
	
	private final static int TEST = 10;
	private final static int SIZE = 100;
	private static int[][] arr;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		for(int t = 1; t <= TEST; t++) {
			int asdasd = scn.nextInt();
			arr = new int[SIZE][SIZE];
			for(int i = 0; i < SIZE; i++) {
				for(int j = 0; j < SIZE; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			int res = 0;
			res = max(res , getMax());
			System.out.println("#" + t + " " + res);
		}
		scn.close();
	}
	private static int max(int a, int b) {
		if(a > b)	return a;
		return b;
	}
	private static int getMax() {
		int res = 0;
		//가로
		for(int i = 0; i < SIZE; i++) {
			int sum = 0;
			for(int j = 0; j < SIZE; j++) {
				sum += arr[i][j];
			}
			res = max(res, sum);
		}
		//세로
		for(int i = 0; i < SIZE; i++) {
			int sum = 0;
			for(int j = 0; j < SIZE; j++) {
				sum += arr[j][i];
			}
			res = max(res, sum);
		}
		//대각성
		int sum = 0;
		for(int i = 0; i < SIZE; i++) {
			sum += arr[i][i];
		}
		res = max(res, sum);
		sum = 0;
		for(int i = 0; i < SIZE; i++) {
			sum += arr[i][SIZE-i-1];
		}
		res = max(res, sum);
		return res;
	}
}

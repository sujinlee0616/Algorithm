package hyuk.boj;

import java.util.Scanner;

public class q2847_DongJun {
	
	private static int N;
	private static int[] arr;
	private static int op;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		op = 0;
		
		makeLevel(0);
		System.out.println(op);
	}
	private static int makeLevel(int start) {
		if(start >= N-1) {
			return arr[start];
		}
		
		int x = makeLevel(start+1);
		if(x <= arr[start]) {
			op += (arr[start] - x + 1);
			return x-1;
		}
		return arr[start];
	}
}

package hyuk.swea;

import java.util.Scanner;

public class Q1859_MillionaireProject {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int test = scn.nextInt();
		for(int t = 1; t <= test; t++) {
			long res = 0;
			int N= scn.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = scn.nextInt();
			}
			int dx = 0;
			int right = arr[N-1];
			for(int i = N-2; i >= 0; i--) {
				dx = arr[i] - right;
				if(dx < 0) {
					res += -1 * dx;
				} else {
					right = arr[i];
				}
			}
			System.out.println("#" + t + " " + res);
		}
		
		scn.close();
	}
}

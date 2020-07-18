package hyuk.boj;

import java.util.Scanner;

public class q5582_CommonString {
	private static int[][] arr = new int[4010][4010];
	public static void main(String[] args) {
		
		//(1,1)부터 dynamic programming
		int ans = 0;
		Scanner scn = new Scanner(System.in);
		String a = scn.next();
		String b = scn.next();
		
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) != b.charAt(j-1)) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = arr[i-1][j-1] + 1;
					ans = max(ans,arr[i][j]);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static int max(int a, int b) {
		if(a >= b) {
			return a;
		}
		return b;
	}
}

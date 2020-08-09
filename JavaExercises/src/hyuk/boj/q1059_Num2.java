package hyuk.boj;

import java.util.Scanner;

public class q1059_Num2 {
	
	private static int L,N, resL, resR;
	private static int[] arr;
	
	public static void main(String[] args) {
		new q1059_Num2().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		L = scn.nextInt();
		arr = new int[1010];
		for(int i = 0; i < L; i++) {
			arr[scn.nextInt()] = 1;
		}
		N = scn.nextInt();
		if(arr[N] == 1) System.out.println(0);
		else {
			dfs(N);
			
			check();
			
		}
		
		
		scn.close();
	}
	private void dfs(int x) {
		arr[x] = 1;
		int[] dx = {-1,1};
		for(int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			if(nx < 1 || nx > 1000) continue;
			if(arr[nx] == 1) continue;
			if(i == 0) resL++;
			else resR++;
			dfs(nx);
		}
	}
	private void check() {
		if(resL == 0 && resR == 0) {
			System.out.println(0);
		} else if(resL > 0 && resR == 0) {
			System.out.println(resL);
		} else if(resL == 0 && resR > 0) {
			System.out.println(resR);
		} else {
			System.out.println(resL * (resR+1) + resR);
		}
	}
}

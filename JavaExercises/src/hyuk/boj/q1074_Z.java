package hyuk.boj;

import java.util.Scanner;

public class q1074_Z {
	
	private static int N,r,c,ans;
	
	public static void main(String[] args) {
		new q1074_Z().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		r = scn.nextInt();
		c = scn.nextInt();
		getZ(0,0,N);
		System.out.println(ans);
		
		scn.close();
	}
	
	private void getZ(int x, int y, int n) {
		int len = getLen(n);
		if(len == 1) {
			return;
		}
		
		int mx = x+len/2;
		int my = y+len/2;
		int rx = r - mx;
		int ry = c - my;
		if(rx < 0 && ry < 0) {
			getZ(x,y,n-1);
		} else if(rx < 0 && ry >= 0) {
			ans += (len * len / 4);
			getZ(x,my,n-1);
		} else if(rx >= 0 && ry < 0) {
			ans += (len * len / 4) * 2;
			getZ(mx,y,n-1);
		} else {
			ans += (len * len / 4) * 3;
			getZ(mx,my,n-1);
		}
	}
	private int getLen(int n) {
		int res = 1;
		for(int i = 0; i < n; i++) {
			res *= 2;
		}
		return res;
	}
}

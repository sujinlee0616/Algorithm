package hyuk.boj;

import java.util.Scanner;

public class q2869_Snail {
	public static void main(String[] args) {
		new q2869_Snail().service(); 
	}
	
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int A = scn.nextInt(); int B = scn.nextInt(); int V = scn.nextInt();
		int res = binarySearch(A,B,V);
		System.out.println(res + 1);
		scn.close();
	}
	private int binarySearch(int A, int B, int V) {
		int lo = -1; int hi = 1000000000;
		int mid = lo;
		while(lo + 1 < hi) {
			mid = (lo + hi) / 2;
			if(formula(A,B,mid,V) == true) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return hi;
	}
	private boolean formula(int A, int B, int mid, int V) {
		if((A - B)*(long)mid + A >= V) return true;
		return false;
	}
}

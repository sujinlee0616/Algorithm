package hyuk.boj;

import java.util.Scanner;

public class Q2512_Deposit {
	
	private static int N,M;
	private static int[] deposit;
	
	public static void main(String[] args) {
		new Q2512_Deposit().service();
	}
	
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		deposit = new int[N];
		for(int i = 0; i < N; i++) {
			deposit[i] = scn.nextInt();
		}
		M = scn.nextInt();
		
		long res = binarySearch(0L, (long)(M+1));
		if(getCal(M) <= M) {
			res = getMax();
		}
		System.out.println(res);
		scn.close();
	}
	
	private long binarySearch(long start, long end) {
		long mid = (start + end) / 2;
		long value = getCal(mid);
		if(value == M) {
			return (int)mid;
		}
		if(start + 1 >= end) {
			return start;
		}
		if(value <= M) {
			return binarySearch(mid, end);
		}else {
			return binarySearch(start, mid);
		}
	}
	
	private long getMax() {
		long res = 0;
		for(int i = 0; i < N; i++) {
			res = max(res,deposit[i]);
		}
		return res;
	}
	private long max(long a, long b) {
		if(a > b)	return a;
		return b;
	}
	private long getCal(long mid) {
		long res = 0;
		for(int i = 0; i < N; i++) {
			if(mid >= deposit[i]) {
				res += deposit[i];
			} else {
				res += mid;
			}
		}
		return res;
	}
}

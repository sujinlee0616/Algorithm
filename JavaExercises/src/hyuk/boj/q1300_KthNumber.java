package hyuk.boj;

import java.util.Scanner;

public class q1300_KthNumber {
	
	private static long N,k;
	private final static long MIN = 1L;
	private final static long MAX = 10000000000L;
	
	public static void main(String[] args) {
		new q1300_KthNumber().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextLong();
		k = scn.nextLong();
		k -= 1;
		
		long res = binarySearch(MIN-1,MAX,k);
		System.out.println(res);
		scn.close();
	}
	private long binarySearch(long start, long end, long findNum) {
		long mid = (start + end) / 2;
		long value = getCal(mid);
		if(start + 1 >= end ) {
			return start;
		}
		if(value <= findNum) {
			return binarySearch(mid, end, findNum);
		} else {
			return binarySearch(start, mid, findNum);
		}
	}
	private long getCal(long mid) {
		long count = 0;
		for(int i = 1; i <= N; i++) {
			if(mid > i * N) {
				count += N;
			} else {
				count += binarySearchForCal(0, N, mid, i);
			}
		}
		return count;
	}
	private long binarySearchForCal(long start, long end, long target, int multi) {
		long mid = (start + end) / 2;
		if(start + 1 >= end) {
			return start;
		}
		if(mid * multi < target) {
			return binarySearchForCal(mid, end, target, multi);
		} else {
			return binarySearchForCal(start, mid, target, multi);
		}
	}
}

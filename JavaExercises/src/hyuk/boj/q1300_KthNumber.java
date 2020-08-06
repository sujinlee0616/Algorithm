package hyuk.boj;

import java.util.Scanner;

public class q1300_KthNumber {
	
	private static int N,k;
	private final static long MIN = 1;
	private final static long MAX = 10000000000L;
	
	public static void main(String[] args) {
		new q1300_KthNumber().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		k = scn.nextInt();
		
		long res = binarySearch(MIN-1,MAX,k);
		System.out.println(res);
		scn.close();
	}
	private long binarySearch(long start, long end, long findNum) {
		long mid = (start + end) / 2;
		System.out.println("mid : " + mid);
		System.out.println("find : " + findNum);
		long firstValue = getCal(mid);
		long secondValue = getCal(mid+1);
		System.out.println(firstValue);
		System.out.println(secondValue);
		if(findNum >= firstValue && findNum < secondValue) {
			return mid;
		}
		if(start + 1 >= end) {
			return end;
		}
		if(findNum < firstValue) {
			return binarySearch(start, mid, findNum);
		}else {
			return binarySearch(mid, end, findNum);
		}
	}
	private long getCal(long mid) {
		long count = 0;
		long index;
		for(int i = 1; i <= N; i++) {
			index = mid / i - 1;
			if(index > N) index = N;
			count += index;
		}
		return count;
	}
}

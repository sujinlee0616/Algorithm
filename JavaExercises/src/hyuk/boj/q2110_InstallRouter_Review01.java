package hyuk.boj;

import java.util.Arrays;
import java.util.Scanner;

public class q2110_InstallRouter_Review01 {
	
	private static long N,C;
	private static long[] arr;
	
	public static void main(String[] args) {
		new q2110_InstallRouter_Review01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextLong();
		C = scn.nextLong();
		arr = new long[(int)N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = scn.nextLong();
		}
		Arrays.sort(arr);
		
		long res = binarySearch(1, 1000000000 + 1);
		System.out.println(res);
		scn.close();
	}
	private long binarySearch(long start, long end) {
		long mid = (start + end) / 2;
		long value = getCal(mid);
		
		if(start + 1 >= end) { 
			return start;
		}
		
		if(value < C) {
			return binarySearch(start, mid);
		} else {
			return binarySearch(mid, end);
		}
	}
	private long getCal(long mid) {
		long count = 1;
		long cur = arr[0];
		long next;
		for(int i = 1; i < N; i++) {
			next = arr[i];
			if(next - cur >= mid) {
				count++;
				cur = next;
			}
		}
		return count;
	}
}

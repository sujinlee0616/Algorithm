package hyuk.boj;

import java.util.Arrays;
import java.util.Scanner;

public class q2110_InstallRouter {
	
	private static int N,C;
	private static int[] arr;
	
	public static void main(String[] args) {
		new q2110_InstallRouter().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		C = scn.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scn.nextInt();
		}
		Arrays.sort(arr);
		long res = binarySearch(1L, 1000000000L + 1);
		System.out.println(res);
		scn.close();
	}
	private long binarySearch(long start, long end) {
		long mid = (start + end) / 2;
		if(start + 1 >= end) {
			return start;
		}
		long value = getCal(mid);
		if(value < C) {
			return binarySearch(start, mid);
		} else {
			return binarySearch(mid, end);
		}
	}
	private long getCal(long mid) {
		long count = 1;
		long pos = arr[0];
		for(int i = 1; i < N; i++) {
			if(arr[i] - pos >= mid) {
				count++;
				pos = arr[i];
			}
		}
		return count;
	}
}

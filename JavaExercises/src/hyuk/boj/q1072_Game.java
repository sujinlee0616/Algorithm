package hyuk.boj;

import java.util.Scanner;

public class q1072_Game {
	
	private static long X,Y,Z;
	private static final long MAX = 100000000000L;
	private static long ans;
	
	public static void main(String[] args) {
		new q1072_Game().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		X = scn.nextLong();
		Y = scn.nextLong();
		
		long maxSize = MAX;
		Z = (Y*100/X);
		ans = binarySearch(0, maxSize);
		if(Z == ((Y + ans)*100 / (X + ans))) {
			ans = -1;
		}
		System.out.println(ans);
		scn.close();
	}
	
	private long binarySearch(long start, long end) {
		if(start + 1 >= end) {
			return end;
		}
		long mid = (start + end) / 2;
		long value = getCal(mid);
		
		if(value < (Z+1)) {
			return binarySearch(mid, end);
		} else {
			return binarySearch(start, mid);
		}
	}
	private long getCal(long mid) {
		long ans = ((Y + mid)*100 / (X + mid));
		return ans;
	}
}

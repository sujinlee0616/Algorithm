package hyuk.swea;

import java.util.Scanner;

public class Q8016_OddPiramid_Review01 {
	public static void main(String[] args) {
		new Q8016_OddPiramid_Review01().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int tc = scn.nextInt();
		for(int t = 1; t <= tc; t++) {
			long floor = scn.nextLong();
			long left = 0; 
			long right = 0;
			left = getFloor(floor-1) + 2;
			right = getFloor(floor);
			System.out.println("#" + t + " " + left + " " + right);
		}
		
		scn.close();
	}
	private long getFloor(long floor) {
		floor = 2 * floor * floor - 1;
		return floor;
	}
}

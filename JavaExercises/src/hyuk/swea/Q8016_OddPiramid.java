package hyuk.swea;

import java.util.Scanner;

public class Q8016_OddPiramid {
	public static void main(String[] args) {
		new Q8016_OddPiramid().service();
	}
	private void service() {
		Scanner scn = new Scanner(System.in);
		
		int tc = scn.nextInt();
		for(int t= 1; t <= tc; t++) {
			int floor = scn.nextInt();
			long ansL = getFloor(floor-1) + 2;
			long ansR = getFloor(floor);
			System.out.println("#" + t + " " + ansL + " " + ansR);
		}
		scn.close();
	}
	private long getFloor(int floor) {
		return 2 * (long)floor * floor -1;
	}
}

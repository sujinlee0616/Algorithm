package hyuk.swea;

import java.util.Scanner;

public class Q1204_MostFrequentNumber {
	
	private static int[] scoreRange = new int[110];
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for(int t = 1; t <= test; t++) {
			int testNum = scn.nextInt();
			init();
			for(int i = 0; i < 1000; i++) {
				scoreRange[scn.nextInt()]++;
			}
			int maxN = 0;
			int maxI = 0;
			for(int i = 0; i <= 100; i++) {
				if(maxN <= scoreRange[i]) {
					maxN = scoreRange[i];
					maxI = i;
				}
			}
			System.out.println("#" + testNum + " " + maxI);
		}
		
		scn.close();
	}
	private static void init() {
		for(int i = 0; i <= 100; i++) {
			scoreRange[i] = 0;
		}
	}
}

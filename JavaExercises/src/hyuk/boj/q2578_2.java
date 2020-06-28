package hyuk.boj;

import java.util.Scanner;

public class q2578_2 {
	public static void main(String[] args) {
		int[][] bingo = new int[5][5];
		int[] question = new int[25];
		Scanner scn = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = scn.nextInt();
			}
		}
		for(int i = 0; i < 25; i++) {
			question[i] = scn.nextInt();
		}
		
		int count = 0;
		for(int k = 0; k < 25; k++) {
			count++;
			int bingoNum = 0;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(bingo[i][j] == question[k]) {
						bingo[i][j] = -1;
					}
				}
			}
			
			for(int i = 0; i < 5; i++) {
				int bingoCount = 0;
				for(int j = 0; j < 5; j++) {
					if(bingo[i][j] == -1) {
						bingoCount++;
					}
				}
				if(bingoCount == 5) {
					bingoNum++;
				}
			}
			for(int i = 0; i < 5; i++) {
				int bingoCount = 0;
				for(int j = 0; j < 5; j++) {
					if(bingo[j][i] == -1) {
						bingoCount++;
					}
				}
				if(bingoCount == 5) {
					bingoNum++;
				}
			}
			
			int bingoCount = 0;
			for(int i = 0; i < 5; i++) {
				if(bingo[i][i] == -1) {
					bingoCount++;
				}
			}
			if(bingoCount == 5) {
				bingoNum++;
			}
			bingoCount = 0;
			for(int i = 0; i < 5; i++) {
				if(bingo[i][4-i] == -1) {
					bingoCount++;
				}
			}
			if(bingoCount == 5) {
				bingoNum++;
			}
			if(bingoNum >= 3) {
				System.out.println(count);
				return;
			}
		}
	}
}

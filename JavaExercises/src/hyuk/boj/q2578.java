package hyuk.boj;

import java.util.Scanner;

public class q2578 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] bingo = new int[5][5];
		int[] question = new int[25];
		int totalCount = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = scn.nextInt();
			}
		}
		for(int i = 0; i < 25; i++) {
			question[i] = scn.nextInt();
		}
		
		for(int k = 0; k < 25; k++) {
			totalCount++;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(bingo[i][j] == question[k]) {
						bingo[i][j] = -1;
					}
				}
			}
			//�˻�
			int count = 0;
			for(int i = 0; i < 5; i++) {
				int bingoCount = 0;
				for(int j = 0; j < 5; j++) {
					if(bingo[i][j] == -1) {
						bingoCount++;
					}
				}
				if(bingoCount == 5) {
					count++;
				}
			}
			
			for(int i = 0 ; i < 5; i++) {
				int bingoCount = 0;
				for(int j = 0; j < 5; j++) {
					if(bingo[j][i] == -1) {
						bingoCount++;
					}
				}
				if(bingoCount == 5) {
					count++;
				}
			}
			
			int bingoCount = 0;
			for(int i = 0; i < 5; i++) {
				if(bingo[i][i] == -1) {
					bingoCount++;
				}
			}
			if(bingoCount == 5) {
				count++;
			}
			
			bingoCount = 0;
			for(int i = 0; i < 5; i++) {
				if(bingo[i][4-i] == -1) {
					bingoCount++;
				}
			}
			if(bingoCount == 5) {
				count++;
			}
			if(count >= 3) {
				System.out.println(totalCount);
				return;
			}
		}
	}
}

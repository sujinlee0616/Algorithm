package SWEA;

import java.util.Scanner;

public class SWEA_1209 {
	/*
	 * SUM 
	 * 1)이차원배열에 값 담기
	 *  2)가로 (행) 세로 (열) 우하향대각선(R) 좌하향대각선(L) 탐색 -> 100x100이면 2*100+2
	 * 202번 탐색 
	 * 3)탐색하고 저장하고 Max리턴하면 끝
	 * 
	 * 단)테스트 케이스도는 동안 
	 * sum을 초기화 하는 것 
	 * if문 빠져나오는 시기 
	 * 주의 !!!! 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = scan.nextInt();
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = scan.nextInt();
					// System.out.print(arr[i][j]); 잘 들어감 확인 
				}
			}
			
			//행,열,왼,오 
			int sumA=0;
			int sumB=0;
			int sumL=0;
			int sumR=0;
			int max=0;
			
			//행탐색+열탐색 
			for(int b=0;b<100;b++) {
				sumA=0; sumB=0; //!
			 for(int a=0;a<100;a++) {
				sumA+=arr[a][b]; //00 10 20 30 
				sumB+=arr[b][a]; //00 01 02 03 
			 }
			 if(sumA>max)max=sumA;
			 if(sumB>max)max=sumB;
			}
			
			//우대각+좌대각 
			for(int i=0;i<100;i++) {
				sumL=0; sumR=0;
				 sumL+=arr[i][i]; //11 22 33 
				 sumR+=arr[i][99-i]; // 199 298 ...
			}
			if(sumL>max)max=sumL; //! 
			if(sumR>max)max=sumR; 
			System.out.println("#" + T+" "+max);
		}
	}
}

package boj;

import java.util.Scanner;

public class boj_q2442_star {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		scan.close();
		
		for(int i=1; i<=n; i++) {
			int space=((2*n-1)-(2*i-1))/2;
			for(int a=1; a<=space; a++) {
				System.out.print(" ");
			}
			for(int j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			// 뒤에 공백 넣으면 제출형식 잘못됐다고함... ==> 주석처리 
//			for(int b=1; b<=space; b++) {
//				System.out.print(" ");
//			}
			System.out.println("");
		}
		
	}

}

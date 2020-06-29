package boj;

import java.util.Scanner;

public class boj_q2439_star {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		scan.close();
		
		for(int i=1; i<=n; i++) {
			int space=n-i;
			
			for(int j=1; j<=space; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}
	
}

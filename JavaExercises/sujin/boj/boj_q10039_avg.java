package boj;

import java.util.Scanner;

public class boj_q10039_avg {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int[] scores=new int[5];
		int total=0;
		
		for(int i=0;i<5;i++) {
			scores[i]=scan.nextInt();
			if(scores[i]<40)
				scores[i]=40;
			total+=scores[i];
		}
		scan.close();
		
		int avg=total/5;
		System.out.println(avg);
		
	}

}

package SWEA;

import java.util.Scanner;

public class SWEA_1989 {
//초심자 회문검사 40'
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int T=scn.nextInt();
		for(int i=0;i<T;i++) {
			String word=scn.next();
			
			
			//중간에서 한칸씩 앞으로가며 동일한지 검사 
			int answer=1;
			for(int j=0; j<word.length()/2; j++) {
				if(word.charAt(j)!=word.charAt(word.length()-j-1)) // 3 ) 0-2
					answer=0;
			}
			System.out.println("#"+i+answer);
		}
	}
	
	
}

package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

// 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력
public class boj_q10820_String {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String s=sc.nextLine();
			int lower=0;
			int upper=0;
			int number=0;
			int space=0;
			
			for(int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				
				if('A'<=c && c<='Z')
					upper++;
				else if('a'<=c && c<='z')
					lower++;
				else if('0'<=c && c<='9')
					number++;
				else if(c==' ')
					space++;
			}
			System.out.println(lower+" "+upper+" "+number+" "+space);
		}
	}
}

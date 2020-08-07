package swea;

import java.util.Scanner;

public class SWEA_2007 {
/*
 패턴 마디의 길이
 마디 최대길이 = 10
 패턴 최대길이 = 30
 pattern
 block 
 
 이중 for문  | substring
 블록이반복된다면?
 길이를 반환 

 
 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int i=1;i<=T;i++) {
			String pattern=scan.next();
			for(int j=1;j<=pattern.length();j++) {
				String check=pattern.substring(0,j); //0-1KO,0-2KOR,0-3KORE,0-4KOREA,0-5KOREAK
				//0-1 1-2 0-2 2-4 j는 하나 이상부터 시작 왜? 다음 글자검색 
				String block=pattern.substring(j,j+j);//1-2OR,2-4REA,3-6EAKO,4-8AKORE,5-10KOREAK
				if(check.equals(block)) {
					System.out.println("#"+i+" "+check.length());
					break;
				}
			}
		}
	}
	
}

package datastructure_book;

import java.util.Scanner;

public class Ch8_p292_prac1_BruteForce {

	// 브루트-포스법으로 문자열을 검색하는 메서드 
	static int bfMatch(String txt, String pat) {
		int pt=0; // txt(텍스트) 커서 
		int pp=0; // pat(패턴) 커서 
		
		while(pt!=txt.length() && pp!=pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) { // text의 커서번호 문자와 pattern의 커서번호 문자가 같다면 
				pt++;
				pp++;
				// 다음 번호 문자들도 비교하기 위해서 ++해줌 
			}else { // text의 커서번호 문자와 pattern의 커서번호 문자가 다르다면 
				pt=pt-pp+1; // ex) 텍스트의 14,15,16번째 글자가 패턴의 0,1,2번째 글자와 같았지만 그 다음에선 다르다면 
					 		//     텍스트는 15번째 글자부터 다시 검색 시작해야. ==> pt=pt-pp+1;
				pp=0;
			}
		}
		
		if(pp==pat.length()) // 검색 성공 
			return pt-pp; 
		return -1; 
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("텍스트: ");
		String s1=sc.next();
		
		System.out.println("패턴: ");
		String s2=sc.next();
		
		int idx=bfMatch(s1,s2);
		
		if(idx==-1) System.out.println("텍스트에 패턴이 없습니다.");
		else {
			// 일치하는 부분 바로 앞까지의 길이를 구한다. 
			int len=0; 
			for(int i=0;i<idx;i++) 
				len+=s1.substring(i,i+1).getBytes().length;
			len+=s2.length();
			
			System.out.println((idx+1)+"번째 문자부터 일치합니다. ");
			System.out.println("텍스트: "+s1);
			System.out.printf(String.format("패턴: %%%ds\n", len), s2);
		}
		
	}
}




package boj;

import java.util.Scanner;

// 못 풀었음 ㅠㅠ 
// 두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성하시오.\
// 첫째 줄에 두 문자열에 모두 포함 된 부분 문자열 중 가장 긴 것의 길이를 출력한다.
public class boj_q5582 {

	public static int solution(String txt, String pat) {
		
		int pt=0; // 텍스트의 인덱스 
		int pp=0; // 패턴의 인덱스 
		int min=0;
		int common=0;
		
		for(int i=0; i<pat.length(); i++) {
			// pat의 i번째를 검사 
			//pp=0;
			while(pp<pat.length()) {
				for(int j=0; j<txt.length(); j++) {
					pp=i;
					if(pat.indexOf(pp)==txt.indexOf(j)) { // pat의 i번째가 txt의 j번째와 같다면 
						pp++;
						common++;
					}
					else {
						pp=pat.length();
						if(min<common)
							min=common;
						common=0;
						break;
					}
				}
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String txt=sc.next();
		String pat=sc.next();
		System.out.println(solution(txt,pat));
	}
}

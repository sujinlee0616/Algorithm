package datastructure_book;

public class Ch8_p305_prac4_Boyer_Moore {
	
	// Boyer-Moore법으로 문자열을 검색하는 메소
	static int bmMath(String txt, String pat) {
		int pt; // 텍스트의 커서 
		int pp; // 패턴의 커서 
		int txtLen=txt.length(); // 텍스트의 문자 개수 
		int patLen=pat.length(); // 패턴의 문자 개수 
		int[] skip=new int[Character.MAX_VALUE+1]; // 건너뛰기 표 
		
		// 건너뛰기 표 만들기
		for(pt=0; pt<=Character.MAX_VALUE; pt++) 
			skip[pt]=patLen;
		for(pt=0; pt<patLen-1; pt++)
			skip[pat.charAt(pt)] = patLen - pt -1; // pt==patLen-1
		
		// 검색 
		while(pt<txtLen) {
			pp=patLen-1; // pat의 끝 문자에 주목 
			
			while(txt.charAt(pt)==pat.charAt(pp)) {
				if(pp==0)
					return pt; // 검색 성공 
				pp--;
				pt--; 
			}
			pt += (skip[txt.charAt(pt)] > patLen-pp) ? skip[txt.charAt(pt)] : patLen-pp;
		}
		return -1; // 검색 실패 
		
	}
	
	
}





package datastructure_book;

public class Ch8_p300_prac3_KMPmatch {

	// KMP법으로 문자열 검색하는 메소드 
	static int kmpMatch(String txt, String pat) {
		int pt=1; // 텍스트의 커서 
		int pp=0; // 패턴의 커서 
		int[] skip=new int[pat.length()+1];
		
		// 건너뛰기 표를 만든다. 
		skip[pt]=0;
		while(pt!=pat.length()) {
			if(pat.charAt(pt)==pat.charAt(pp))
				skip[++pt]=++pp;
			else if(pp==0)
				skip[++pt]=pp;
			else
				pp=skip[pp];
		}
		
		// 검색
		pt=pp=0;
		while(pt!=txt.length() && pp!=pat.length()) {
			if(txt.charAt(pt)==pat.charAt(pp)) {
				pt++;
				pp++;
			}
			else if(pp==0)
				pt++;
			else
				pp=skip[pp];
		}
		if(pp==pat.length())
			return pt-pp;
		return -1; // 검색 실패 
	}
	
}

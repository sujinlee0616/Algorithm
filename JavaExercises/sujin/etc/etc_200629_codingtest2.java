package etc;

// 배열 emails : 매개변수 

public class etc_200629_codingtest2 {
	
	public static int solution(String[] emails) {
		int answer=0;
		int countEmail=emails.length;
		int[] check=new int[countEmail]; // 유효성검사 배열. 맞으면+1, 틀리면-1 
		String[] name=new String[countEmail];
		String[] domain=new String[countEmail];
		
		for(int i=0; i<countEmail; i++) {
			// 1. 소문자 체크 
			if(emails[i].equals(emails[i])) {
				check[i]=1;
			}
			else {
				check[i]=-1;
			}
			
			// 2. @체크 
			int locAt1=emails[i].indexOf("@");
			int locAt2=emails[i].lastIndexOf("@");
			if(locAt1==-1) // @가 하나도 없으면 틀린 것 
				check[i]=-1;
			if(locAt1!=locAt2) // @가 두 개 이상이면 틀린 것 
				check[i]=-1;
			
			// 3. 소문자, ., @ 말고 다른 문자가 있으면 - 정규식 사용?
			
			// 4. 길이 체크
			if(emails[i].length()<1 || emails[i].length()>100)
				check[i]=-1;
			
			// 위의 애들이 검증됐을 때 
			if(check[i]!=-1) {
				name[i]=emails[i].substring(0,emails[i].indexOf("@"));
				//System.out.println("name["+i+"]="+name[i]);
				domain[i]=emails[i].substring(emails[i].indexOf("@"),emails[i].length());
				//System.out.println("domain["+i+"]="+domain[i]);
				
				// 1) 도메인 부분 유효성 체크 ===> 런타임 에러 
				// 	- 입력 : {“@”}
				//  - 이럴 경우, length : 1인데, 지금 로직으로는 do_leng-4 = -3
				int do_leng=domain[i].length();
				String last4letters=domain[i].substring(do_leng-4,do_leng);
				//System.out.println("last4letters="+last4letters);
				if(last4letters.equals(".com") || last4letters.equals(".net") || last4letters.equals(".org")) {
				}
				else {
					check[i]=-1;
				}
				
			}
			else {
				name[i]="WRONG";
				domain[i]="WRONG";
			}
		}
		
		for(int i=0; i<countEmail; i++) {
			if(check[i]!=-1)
				answer++;
		}
		
		System.out.println(answer);
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		//String[] emails= {"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"};
		//String[] emails= {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
		String[] emails= {"A.def@x.com", "AAA", "ABC@defx", "ABC@defx.xyz"}; // 0이어야하는데..ㅠ
		
		solution(emails);
		//System.out.println(solution(emails));
		
	}

}

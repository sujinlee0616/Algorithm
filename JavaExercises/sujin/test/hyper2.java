package test;

public class hyper2 {
	
	public static void main(String[] args) {
		// String[] emails = {"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"};
		// String[] emails = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
		String[] emails = {
				"@hello.net", //X        0   
				"@hello.nat", //X        1  
				"@name@hello.net", //X   2
				"na.me@hello.net", //O   3
				"n0me@hello.net", //X    4
				"name.hello.net" , //X   5
				"hello.net@", //X        6  
				"hello.net@hello", //X   7  
				"hello.net@.net", //X    8
				"hello.net@a.net.", //X  9  
				"hello.net@a.net"}; //O  10 
		System.out.println(solution(emails));

		// emails의 원소는 영문 소문자, ., @로 이루어진 문자열
		// [조건]
		// 1. 전체 조건: 이름@도메인이름.탑레벨도메인
		// 2. 이름 : 영문 소문자와 .로만 구성되며 길이가 1 이상이어야
		// 3. 도메인 : 영문 소문자로만 구성되며 길이가 1 이상이어야
		// 4. 탑레벨 도메인 : com, net, org 중 하나 --> 완료 
	}
	
	static int solution(String[] emails) {
		int ans = 0;
		int leng = emails.length;
		boolean check[] = new boolean[leng];
		String[] name = new String[leng];
		String[] domainName = new String[leng];
		
		// 초기화 
		for(int i=0; i<leng; i++) 
			check[i] = true;
		
		// 4. 탑 레벨 도메인 검사
		for(int i=0; i<leng; i++)
			if(!(emails[i].endsWith(".com") || emails[i].endsWith(".net") || emails[i].endsWith(".org")))
				check[i] = false; 
				 
				
		// 1. 전체조건 검사 
		// 1) @ 있는지
		for(int i=0; i<leng; i++) 
			if(!emails[i].contains("@"))
				check[i] = false; 
		// 2) @ 한 개 맞는지 
		for(int i=0; i<leng; i++) 
			if(emails[i].indexOf("@") != emails[i].lastIndexOf("@"))
				check[i] = false; 
		
		// 2. 검사 
		for(int i=0; i<leng; i++) {
			if(check[i]==true) {
				name[i] = emails[i].substring(0, emails[i].indexOf("@"));
				domainName[i] = emails[i].substring(emails[i].indexOf("@")+1,emails[i].length()-4);
				
				// 2. 이름 검사  : 영문 소문자와 .로만 구성되며 길이가 1 이상이어야
				// 1) 길이 1 이상인지 
				int nameLeng = name[i].length();
				if(nameLeng<=0)
					check[i] = false;
					
				// 2) 영문 소문자, .로만 구성되었는지  ==> 왜 제거가 안되지? 아아..!! 
				for(int j=0; j<nameLeng; j++)
					if( !( name[i].charAt(j)>='a' && name[i].charAt(j)<='z' || name[i].charAt(j)=='.') )
						check[i] = false; 
				
				// 3. 도메인 검사: 영문 소문자로만 구성되며 길이가 1 이상이어야
				int domainNameLeng = domainName[i].length();
				if(domainNameLeng<=0) 
					check[i] = false;
				for(int j=0; j<domainNameLeng; j++)
					if( !( domainName[i].charAt(j)>='a' && domainName[i].charAt(j)<='z' ) ) 
						check[i] = false; 
			}
		}
			
		
		for(int i=0; i<leng; i++)
			if(check[i]==true)
				ans++;
		
		return ans;
	}

}


/* 
리뷰) 내가 코드 짜면서 어떤 실수를 했는가  

 1. 조건이 여러개 있을 때, 
 - 초기화를 다 true로 해놓고 
 - 조건이 하나라도 틀리면 false 처리 
 - false처리만 해줘야지, true 처리 해주면 안 됨. 
  ==> 왜냐면, 조건1은 틀렸는데 조건2가 맞다고 true 처리하면 결과적으로 틀린건데도 true 처리되니까  

 2. 코드 실수 
 - 이렇게 해야하는데 
   if( !( name[i].charAt(j)>='a' && name[i].charAt(j)<='z' || name[i].charAt(j)=='.') ) 
	 	check[i] = false; 
 - 이렇게 잘못 생각했음   
   if( !( name[i].charAt(j)>='a' || name[i].charAt(j)<='z' || name[i].charAt(j)=='.') ) 
		check[i] = false; 
   // ==> || 이면 a~z 사이라는걸 체크를 못 함 ㅠㅠ
 */
